package org.salem.service.assemler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.salem.domain.account.Account;
import org.salem.domain.account.Role;
import org.salem.service.dto.AccountDto;
import org.salem.service.dto.NameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountAssembler {

    @Autowired
    private final NameAssembler nameAssembler;

    public AccountAssembler(final NameAssembler nameAssembler) {
        this.nameAssembler = nameAssembler;
    }

    public AccountDto create(Account account) {

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(account.getAccountId().toString());

        NameDto nameDto = this.nameAssembler.create(account.getName());
        accountDto.setNameDto(nameDto);

        accountDto.setEmail(account.getEmail());
        accountDto.setPassword(account.getPassword());
        Set<String> roles = this.createListRole(account.getRoles());
        accountDto.setRoles(roles);

        return accountDto;
    }

    public List<AccountDto> createList(List<Account> accounts) {

        List<AccountDto> accountsListDtos = new ArrayList<>();
        for (Account account : accounts) {
            AccountDto accountDto = this.create(account);
            accountsListDtos.add(accountDto);
        }

        return accountsListDtos;
    }

    private Set<String> createListRole(Set<Role> roles) {

        Set<String> roleSet = new HashSet<>();
        for (Role role : roles)
            roleSet.add(role.getERole().toString());

        return roleSet;
    }
}