package org.salem.service.don;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.stripe.Stripe;
import com.stripe.model.Charge;

import org.salem.controller.dto.AccountRequestDto;
import org.salem.controller.dto.DonFinancialRequestDto;
import org.salem.controller.dto.DonMaterialRequestDto;
import org.salem.controller.dto.DonRequestDto;
import org.salem.domain.account.Account;
import org.salem.domain.account.AccountRepository;
import org.salem.domain.account.ERole;
import org.salem.domain.account.Name;
import org.salem.domain.don.Don;
import org.salem.domain.don.DonRepository;
import org.salem.domain.dto.DonPersistDto;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.salem.domain.exception.InvalidDonTypeException;
import org.salem.domain.exception.ResourceNotFoundException;
import org.salem.domain.message.EmailNotification;
import org.salem.domain.message.Message;
import org.salem.domain.message.MessageInformation;
import org.salem.domain.message.Notification;
import org.salem.service.account.AccountFactory;
import org.salem.service.assemler.DonAssembler;
import org.salem.service.assemler.NameAssembler;
import org.salem.service.dto.DonDto;
import org.salem.service.exception.StrikeException;
import org.salem.service.message.NotificationSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DonService {

    @Autowired
    private final DonFactory donFactory;

    @Autowired
    private final DonAssembler donAssembler;

    @Autowired
    private final NameAssembler nameAssembler;

    @Autowired
    private final DonRepository donRepository;

    @Autowired
    private final AccountFactory accountFactory;

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final NotificationSenderService notificationSenderService;

    @Value("${stripe.keys.secret}")
    private String API_SECRET_KEY;

    @Value("${spring.mail.username}")
    private String emailSalem;

    private final static String AMOUNT = "amount";
    private final static String CURRENCY = "currency";
    private final static String DESCRIPTION = "description";
    private final static String SOURCE = "source";
    private final static String PASSWORD = "password";

    private static final Logger LOGGER = Logger.getLogger(DonService.class.getName());

    public DonService(final DonFactory donFactory, final DonAssembler donAssembler, final NameAssembler nameAssembler,
            final DonRepository donRepository, final AccountRepository accountRepository,
            final AccountFactory accountFactory, final NotificationSenderService notificationSenderService) {
        this.donFactory = donFactory;
        this.donAssembler = donAssembler;
        this.nameAssembler = nameAssembler;
        this.donRepository = donRepository;
        this.accountRepository = accountRepository;
        this.accountFactory = accountFactory;
        this.notificationSenderService = notificationSenderService;

    }

    public List<DonDto> findAllDon() {
        final List<DonPersistDto> donPersists = this.donRepository.findAllDon();
        final List<Don> dons = this.donAssembler.createListDon(donPersists);
        final List<DonDto> donDtos = this.donAssembler.createListDonDto(dons);

        return donDtos;
    }

    public List<DonDto> findDonByEmail(final String email) throws ResourceNotFoundException {
        final List<DonPersistDto> donPersists = this.donRepository.findDonByEmail(email);
        if (donPersists.size() == 0) {
            throw new ResourceNotFoundException("Don not found for this email : " + email);
        }
        final List<Don> dons = this.donAssembler.createListDon(donPersists);
        final List<DonDto> donDtos = this.donAssembler.createListDonDto(dons);

        return donDtos;
    }

    public DonDto createDonMaterial(final DonMaterialRequestDto donMaterialRequestDto)
            throws InvalidAccountTypeException, InvalidDonTypeException {

        final String email = donMaterialRequestDto.getEmail();

        final DonRequestDto donRequestDto = this.donAssembler.create(donMaterialRequestDto);
        LOGGER.info("Create don : " + email + " : " + LOGGER.getName());
        DonDto donDto = new DonDto();

        final Account accountFind = this.accountRepository.findByEmail(email);
        if (accountFind != null && accountFind.hasEmail(email)) {
            final Don don = this.donFactory.create(donRequestDto);
            don.setAccount(accountFind);
            final Don donSave = this.donRepository.save(don);
            this.accountRepository.save(accountFind);
            donDto = this.donAssembler.create(donSave);
        } else {
            donDto = this.createDonAccountNotExist(donRequestDto);
        }

        return donDto;
    }

    public DonDto saveDonFinancial(final DonFinancialRequestDto donFinancialRequestDto)
            throws InvalidAccountTypeException, InvalidDonTypeException {

        final String email = donFinancialRequestDto.getEmail();

        final DonRequestDto donRequestDto = this.donAssembler.create(donFinancialRequestDto);

        LOGGER.info("Create don : " + email + " : " + LOGGER.getName());
        DonDto donDto = new DonDto();

        final Account accountFind = this.accountRepository.findByEmail(email);
        if (accountFind != null && accountFind.hasEmail(email)) {
            final Don don = this.donFactory.create(donRequestDto);
            don.setAccount(accountFind);
            final Don donSave = this.donRepository.save(don);
            this.accountRepository.save(accountFind);
            donDto = this.donAssembler.create(donSave);
        } else {
            donDto = this.createDonAccountNotExist(donRequestDto);
        }

        return donDto;
    }

    public DonDto createDonFinancial(final DonFinancialRequestDto donFinancialRequestDto) throws StrikeException {

        final String email = donFinancialRequestDto.getEmail();

        LOGGER.info("Create don financial : " + email + " : " + LOGGER.getName());

        final String token = donFinancialRequestDto.getToken();
        final int value = Integer.parseInt(donFinancialRequestDto.getValue());
        final String currency = donFinancialRequestDto.getCurrency();
        try {
            Stripe.apiKey = API_SECRET_KEY;
            final Map<String, Object> chargeParams = new HashMap<>();
            final int valueCent = this.convertToCent(value);
            chargeParams.put(AMOUNT, valueCent);
            chargeParams.put(CURRENCY, currency);
            chargeParams.put(DESCRIPTION, "Charge for " + email);
            chargeParams.put(SOURCE, token);
            final Charge charge = Charge.create(chargeParams);
            validateCharge(charge);
            return this.saveDonFinancial(donFinancialRequestDto);
        } catch (final Exception ex) {
            final String message = ex.getMessage();
            throw new StrikeException(message);
        }
    }

    public DonDto createDonFinancialThankYou(final DonFinancialRequestDto donFinancialRequestDto) throws Exception {

        final Name name = this.nameAssembler.createName(donFinancialRequestDto.getFirstName(),
                donFinancialRequestDto.getLastName());
        final Message message = new Message(name, donFinancialRequestDto.getEmail(),
                donFinancialRequestDto.getPhoneNumber(), donFinancialRequestDto.getComment());

        final EmailNotification emailNotification = new EmailNotification();
        emailNotification.setEmailRecipient(donFinancialRequestDto.getEmail());
        emailNotification.setCreationDate(LocalDateTime.now());
        emailNotification.setCreationDate(LocalDateTime.now());

        final String subject = MessageInformation.REMERCIMENT;
        final String mesageSend = MessageInformation.formateDonThankYouMessage(message);
        emailNotification.setSubject(subject);
        emailNotification.setMessage(mesageSend);
        emailNotification.setName(name);

        final List<Notification> notifications = new ArrayList<>();
        notifications.add(emailNotification);

        this.notificationSenderService.send(notifications);
        return new DonDto();
    }

    public DonDto createDonMaterialThankYou(final DonMaterialRequestDto donMaterialRequestDto) throws Exception {

        final Name name = this.nameAssembler.createName(donMaterialRequestDto.getFirstName(),
                donMaterialRequestDto.getLastName());
        final Message message = new Message(name, donMaterialRequestDto.getEmail(),
                donMaterialRequestDto.getPhoneNumber(), donMaterialRequestDto.getComment());

        final EmailNotification emailNotification = new EmailNotification();
        emailNotification.setEmailSender(emailSalem);
        emailNotification.setEmailRecipient(donMaterialRequestDto.getEmail());
        emailNotification.setCreationDate(LocalDateTime.now());

        final String subject = MessageInformation.REMERCIMENT;
        final String mesageSend = MessageInformation.formateDonThankYouMessage(message);
        emailNotification.setSubject(subject);
        emailNotification.setMessage(mesageSend);
        emailNotification.setName(name);

        final List<Notification> notifications = new ArrayList<>();
        notifications.add(emailNotification);

        this.notificationSenderService.send(notifications);
        return new DonDto();
    }

    private int convertToCent(final int amount) {
        return amount * 100;
    }

    private void validateCharge(final Charge charge) throws StrikeException {
        if (charge.getId() == null) {
            final String message = "An error occurred while trying to create a charge.";
            throw new StrikeException(message);
        }
    }

    private DonDto createDonAccountNotExist(final DonRequestDto donRequestDto)
            throws InvalidDonTypeException, InvalidAccountTypeException {

        final Don don = this.donFactory.create(donRequestDto);

        final String firstName = donRequestDto.getFirstName();
        final String lastName = donRequestDto.getLastName();
        final String password = PASSWORD;
        final String phoneNumber = donRequestDto.getPhoneNumber();
        final String roleSubscriber = ERole.ROLE_SUBSCRIBER.toString();
        final String email = donRequestDto.getEmail();

        final AccountRequestDto accountRequestDto = new AccountRequestDto(firstName, lastName, password, email,
                phoneNumber, roleSubscriber);
        final Account accountCreate = this.accountFactory.create(accountRequestDto);
        don.setAccount(accountCreate);

        this.accountRepository.save(accountCreate);
        final Don donSave = this.donRepository.save(don);

        return this.donAssembler.create(donSave);

    }

}