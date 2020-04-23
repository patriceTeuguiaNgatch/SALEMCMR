package org.salem.service.account;

import java.util.List;
import java.util.logging.Logger;

import org.salem.controller.account.dto.AccountRequestDto;
import org.salem.domain.account.Account;
import org.salem.domain.account.AccountRepository;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.salem.domain.exception.ResourceNotFoundException;
import org.salem.service.assemler.AccountAssembler;
import org.salem.service.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private final AccountFactory accountFactory;
    @Autowired
    private final AccountAssembler accountAssembler;
    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(final AccountFactory accountFactory, final AccountAssembler accountAssembler,
            final AccountRepository accountRepository) {
        this.accountFactory = accountFactory;
        this.accountAssembler = accountAssembler;
        this.accountRepository = accountRepository;
    }

    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    public List<AccountDto> findAll() {

        LOGGER.info("Find all accounts " + LOGGER.getName());

        final List<Account> accounts = accountRepository.findAll();
        final List<AccountDto> accountListDtos = this.accountAssembler.createList(accounts);

        return accountListDtos;
    }

    public AccountDto createAccount(final AccountRequestDto accountRequestDto) throws InvalidAccountTypeException {

        LOGGER.info("Create the account : " + accountRequestDto.getFirstName() + " : " + LOGGER.getName());

        final Account account = this.accountFactory.create(accountRequestDto.getFirstName(),
                accountRequestDto.getLastName(), accountRequestDto.getPassword(), accountRequestDto.getEmail(),
                accountRequestDto.getPhoneNumber(), accountRequestDto.getRole());
        final Account accountSave = accountRepository.save(account);
        AccountDto accountDto = accountAssembler.create(accountSave);

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
        account.setFirstName(accountRequestDto.getFirstName());
        account.setLastName(accountRequestDto.getLastName());
        account.setPassword(accountRequestDto.getPassword());
        account.setEmail(accountRequestDto.getEmail());
        account.setPhoneNumber(accountRequestDto.getPhoneNumber());
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

}