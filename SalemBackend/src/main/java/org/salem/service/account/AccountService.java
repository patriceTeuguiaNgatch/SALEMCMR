package org.salem.service.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.salem.controller.account.dto.AccountRequestDto;
import org.salem.domain.account.Account;
import org.salem.domain.account.AccountRepository;
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

    public Long createAccount(final AccountRequestDto accountRequestDto) throws Exception {

        LOGGER.info("Create the account : " + accountRequestDto.getFirstName() + " : " + LOGGER.getName());

        final Account account = this.accountFactory.create(accountRequestDto.getFirstName(),
                accountRequestDto.getLastName(), accountRequestDto.getPassword(), accountRequestDto.getEmail(),
                accountRequestDto.getPhoneNumber(), accountRequestDto.getRole());
        final Account accountSave = accountRepository.save(account);

        return accountSave.getAccountId();
    }

    public AccountDto findAccountById(final String accountId) throws Exception {

        LOGGER.info("Find account by Id : " + accountId + " : " + LOGGER.getName());

        final Long accountIdLong = this.convertStringToLong(accountId);

        final Account account = accountRepository.findById(accountIdLong)

                .orElseThrow(() -> new Exception("Account not found for this id : " + accountId));
        final AccountDto accountDto = accountAssembler.create(account);

        return accountDto;
    }

    public AccountDto updateAccount(final String accountId, final AccountRequestDto accountRequestDto)
            throws Exception {

        LOGGER.info("Update account by Id : " + accountId + " and name : " + accountRequestDto.getFirstName() + " : "
                + LOGGER.getName());

        final Long accountIdLong = this.convertStringToLong(accountId);

        final Account account = accountRepository.findById(accountIdLong)

                .orElseThrow(() -> new Exception("Account not found for this id : " + accountId));
        account.setFirstName(accountRequestDto.getFirstName());
        account.setLastName(accountRequestDto.getLastName());
        account.setPassword(accountRequestDto.getPassword());
        account.setEmail(accountRequestDto.getEmail());
        account.setPhoneNumber(accountRequestDto.getPhoneNumber());
        final Account accountUpdate = accountRepository.save(account);
        final AccountDto accountDtoUpdate = accountAssembler.create(accountUpdate);

        return accountDtoUpdate;
    }

    public Map<String, Boolean> deleteAccount(final String accountId) throws Exception {

        LOGGER.info("Delete account by Id : " + accountId + " " + LOGGER.getName());

        final Long accountIdLong = this.convertStringToLong(accountId);

        final Account account = accountRepository.findById(accountIdLong)
                .orElseThrow(() -> new Exception("Account not found for this id : " + accountId));

        accountRepository.delete(account);
        final Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }

    private Long convertStringToLong(final String chaine) throws Exception {
        return Long.parseLong(chaine);
    }
}