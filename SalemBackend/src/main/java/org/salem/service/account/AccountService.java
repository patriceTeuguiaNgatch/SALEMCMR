package org.salem.service.account;

import java.util.List;
import java.util.logging.Logger;

import org.salem.controller.dto.AccountRequestDto;
import org.salem.controller.dto.AccountSignInDto;
import org.salem.domain.account.Account;
import org.salem.domain.account.AccountRepository;
import org.salem.domain.don.Name;
import org.salem.domain.exception.AccountAlreadyExistException;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.salem.domain.exception.ResourceNotFoundException;
import org.salem.service.assemler.AccountAssembler;
import org.salem.service.assemler.NameAssembler;
import org.salem.service.dto.AccountDto;
import org.salem.service.dto.NameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private final AccountFactory accountFactory;

    @Autowired
    private final AccountAssembler accountAssembler;

    @Autowired
    private final NameAssembler nameAssembler;

    @Autowired
    private final AccountRepository accountRepository;

    @Value("${secret.crypto.aes}")
    private String secretCryptography;

    public AccountService(final AccountFactory accountFactory, final AccountAssembler accountAssembler,
            final NameAssembler nameAssembler, final AccountRepository accountRepository) {
        this.accountFactory = accountFactory;
        this.accountAssembler = accountAssembler;
        this.nameAssembler = nameAssembler;
        this.accountRepository = accountRepository;
        // this.donService = donService;
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
        account.encryptPassword(secretCryptography);
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
        if (accountFind != null && accountFind.hasEmail(email)
                && accountFind.hasPassword(password, secretCryptography)) {
            return this.accountAssembler.create(accountFind);

        } else {
            throw new ResourceNotFoundException(
                    "Account not found for this email : " + email + " and this password : " + password);
        }
    }

}
