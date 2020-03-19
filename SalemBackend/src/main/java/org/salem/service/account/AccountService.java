package org.salem.service.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.salem.controller.account.dto.AccountRequestDto;
import org.salem.domain.account.Account;
import org.salem.domain.account.AccountRepository;
import org.salem.domain.account.RolesRepository;
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
    @Autowired
    private final RolesRepository rolesRepository;

    public AccountService(final AccountFactory accountFactory, final AccountAssembler accountAssembler,
            final AccountRepository accountRepository, final RolesRepository rolesRepository) {
        this.accountFactory = accountFactory;
        this.accountAssembler = accountAssembler;
        this.accountRepository = accountRepository;
        this.rolesRepository = rolesRepository;
    }

    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    public List<AccountDto> findAll() {

        List<Account> accounts = accountRepository.findAll();
        final List<AccountDto> accountListDtos = this.accountAssembler.createList(accounts);

        return accountListDtos;
    }

    public Long createAccount(final AccountRequestDto accountRequestDto) throws Exception {

        LOGGER.info("Create the account : " + accountRequestDto.getFirstName() + " : " + LOGGER.getName());

        final Account account = this.accountFactory.create(accountRequestDto.getFirstName(),
                accountRequestDto.getLastName(), accountRequestDto.getPassword(), accountRequestDto.getEmail(),
                accountRequestDto.getTelephoneNumber(), accountRequestDto.getRole());
        Account accountSave = accountRepository.save(account);

        return accountSave.getAccountId();
    }

    public AccountDto findAccountById(Long accountId) throws Exception {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new Exception("Account not found for this id : " + Long.toString(accountId)));
        AccountDto accountDto = accountAssembler.create(account);

        return accountDto;
    }

    public AccountDto updateAccount(Long accountId, AccountRequestDto accountRequestDto) throws Exception {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new Exception("Account not found for this id : " + Long.toString(accountId)));
        account.setFirstName(accountRequestDto.getFirstName());
        account.setLastName(accountRequestDto.getLastName());
        account.setPassword(accountRequestDto.getPassword());
        account.setEmail(accountRequestDto.getPassword());
        account.setTelephoneNumber(accountRequestDto.getTelephoneNumber());
        Account accountUpdate = accountRepository.save(account);
        AccountDto accountDtoUpdate = accountAssembler.create(accountUpdate);

        return accountDtoUpdate;
    }

    public Map<String, Boolean> deleteAccount(Long accountId) throws Exception {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new Exception("Account not found for this id : " + Long.toString(accountId)));

        accountRepository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;
    }
}