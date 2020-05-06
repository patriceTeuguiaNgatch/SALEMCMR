package org.salem.service.account;

import java.util.List;
import java.util.logging.Logger;

import org.salem.controller.dto.AccountRequestDto;
import org.salem.controller.dto.AccountSignInDto;
import org.salem.controller.dto.DonRequestDto;
import org.salem.domain.account.Account;
import org.salem.domain.account.AccountRepository;
import org.salem.domain.account.ERole;
import org.salem.domain.don.Don;
import org.salem.domain.don.Name;
import org.salem.domain.exception.AccountAlreadyExistException;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.salem.domain.exception.InvalidDonTypeException;
import org.salem.domain.exception.ResourceNotFoundException;
import org.salem.service.assemler.AccountAssembler;
import org.salem.service.assemler.NameAssembler;
import org.salem.service.don.DonService;
import org.salem.service.dto.AccountDto;
import org.salem.service.dto.DonDto;
import org.salem.service.dto.NameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private final DonService donService;

    @Autowired
    private final AccountFactory accountFactory;

    @Autowired
    private final AccountAssembler accountAssembler;

    @Autowired
    private final NameAssembler nameAssembler;

    @Autowired
    private final AccountRepository accountRepository;

    private final static String secret = "melas@2010";

    public AccountService(final AccountFactory accountFactory, final AccountAssembler accountAssembler,
            final NameAssembler nameAssembler, final AccountRepository accountRepository, final DonService donService) {
        this.accountFactory = accountFactory;
        this.accountAssembler = accountAssembler;
        this.nameAssembler = nameAssembler;
        this.accountRepository = accountRepository;
        this.donService = donService;
    }

    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    public List<AccountDto> findAll() {

        LOGGER.info("Find all accounts " + LOGGER.getName());

        final List<Account> accounts = accountRepository.findAll();
        final List<AccountDto> accountListDtos = this.accountAssembler.createList(accounts);

        return accountListDtos;
    }

    public AccountDto createAccount(final AccountRequestDto accountRequestDto)
            throws InvalidAccountTypeException, AccountAlreadyExistException {

        LOGGER.info("Create the account : " + accountRequestDto.getFirstName() + " : " + LOGGER.getName());

        final String email = accountRequestDto.getEmail();
        final Account accountFind = this.accountRepository.findByEmail(email);
        if (accountFind != null && accountFind.hasEmail(email)) {
            throw new AccountAlreadyExistException("Account already exist for this email : " + email);
        }

        final Account account = this.accountFactory.create(accountRequestDto);
        account.encryptPassword(secret);
        final Account accountSave = this.accountRepository.save(account);
        final AccountDto accountDto = this.accountAssembler.create(accountSave);

        return accountDto;
    }

    public AccountDto findAccountById(final Long accountId) throws ResourceNotFoundException {

        LOGGER.info("Find account by Id : " + accountId + " : " + LOGGER.getName());

        final Account account = accountRepository.findById(accountId)

                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id : " + accountId));
        final AccountDto accountDto = accountAssembler.create(account);

        return accountDto;
    }

    public AccountDto updateAccount(final Long accountId, final AccountRequestDto accountRequestDto)
            throws ResourceNotFoundException {

        LOGGER.info("Update account by Id : " + accountId + " and name : " + accountRequestDto.getFirstName() + " : "
                + LOGGER.getName());

        final Account account = accountRepository.findById(accountId)

                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id : " + accountId));

        final NameDto nameDto = new NameDto(accountRequestDto.getFirstName(), accountRequestDto.getLastName());
        final Name name = this.nameAssembler.create(nameDto);

        account.setName(name);
        account.setPassword(accountRequestDto.getPassword());
        account.setEmail(accountRequestDto.getEmail());
        final Account accountUpdate = accountRepository.save(account);
        final AccountDto accountDtoUpdate = accountAssembler.create(accountUpdate);

        return accountDtoUpdate;
    }

    public AccountDto deleteAccount(final Long accountId) throws ResourceNotFoundException {

        LOGGER.info("Delete account by Id : " + accountId + " " + LOGGER.getName());

        final Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id : " + accountId));

        accountRepository.delete(account);
        final AccountDto accountDtoDelete = accountAssembler.create(account);

        return accountDtoDelete;
    }

    public AccountDto findAccountByEmail(final String email) throws ResourceNotFoundException {

        LOGGER.info("Find account by email : " + email + " : " + LOGGER.getName());

        final Account account = accountRepository.findByEmail(email);
        if (account == null || !account.hasEmail(email)) {
            throw new ResourceNotFoundException("Account not found for this email : " + email);
        }
        final AccountDto accountDto = accountAssembler.create(account);

        return accountDto;
    }

    public AccountDto singInAccount(final AccountSignInDto accountSignDto) throws ResourceNotFoundException {

        final String email = accountSignDto.getEmail();
        final String password = accountSignDto.getPassword();
        LOGGER.info("Sign in account by email : " + email + " : " + LOGGER.getName());

        final Account accountFind = accountRepository.findByEmail(email);
        if (accountFind != null && accountFind.hasEmail(email) && accountFind.hasPassword(password, secret)) {
            return this.accountAssembler.create(accountFind);

        } else {
            throw new ResourceNotFoundException(
                    "Account not found for this email : " + email + " and this password : " + password);
        }
    }

    public DonDto createDon(final DonRequestDto donRequestDto)
            throws InvalidAccountTypeException, InvalidDonTypeException {

        final String email = donRequestDto.getEmail();

        LOGGER.info("Create don : " + email + " : " + LOGGER.getName());
        DonDto donDto = new DonDto();

        final Account accountFind = this.accountRepository.findByEmail(email);
        if (accountFind != null && accountFind.hasEmail(email)) {
            final Don don = this.donService.Create(donRequestDto);
            don.setAccount(accountFind);
            final Don donSave = donService.save(don);
            this.accountRepository.save(accountFind);
            donDto = this.donService.Create(donSave);
        } else {
            donDto = this.createDonAccountNotExist(donRequestDto);
        }

        return donDto;
    }

    private DonDto createDonAccountNotExist(final DonRequestDto donRequestDto)
            throws InvalidDonTypeException, InvalidAccountTypeException {

        final Don don = this.donService.Create(donRequestDto);

        final String firstName = donRequestDto.getFirstName();
        final String lastName = donRequestDto.getLastName();
        final String password = "password";
        final String phoneNumber = donRequestDto.getPhoneNumber();
        final String roleSubscriber = ERole.ROLE_SUBSCRIBER.toString();
        final String email = donRequestDto.getEmail();

        final AccountRequestDto accountRequestDto = new AccountRequestDto(firstName, lastName, password, email,
                phoneNumber, roleSubscriber);
        final Account accountCreate = this.accountFactory.create(accountRequestDto);
        don.setAccount(accountCreate);

        this.accountRepository.save(accountCreate);
        final Don donSave = this.donService.save(don);

        return this.donService.Create(donSave);

    }
}
