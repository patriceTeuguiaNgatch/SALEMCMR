package org.salem.service.assemler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.salem.domain.account.Account;
import org.salem.domain.account.Role;
import org.salem.domain.don.Address;
import org.salem.domain.don.Don;
import org.salem.domain.don.Edon;
import org.salem.service.dto.AccountDonDto;
import org.salem.service.dto.AccountDto;
import org.salem.service.dto.AddressDto;
import org.salem.service.dto.NameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountAssembler {

    @Autowired
    private final NameAssembler nameAssembler;

    @Autowired
    private final AddressAssembler addressAssembler;

    public AccountAssembler(final NameAssembler nameAssembler, final AddressAssembler addressAssembler) {
        this.nameAssembler = nameAssembler;
        this.addressAssembler = addressAssembler;
    }

    public AccountDto create(Account account) {

        AccountDto accountDto = new AccountDto();
        Long accountId = account.getAccountId();
        accountDto.setAccountId(accountId.toString());

        NameDto nameDto = this.nameAssembler.create(account.getName());
        accountDto.setNameDto(nameDto);

        accountDto.setEmail(account.getEmail());
        accountDto.setPassword(account.getPassword());

        Set<Don> dons = account.getDons();
        Set<AccountDonDto> accountDonDtos = this.createList(dons);
        accountDto.setAccountDonDtos(accountDonDtos);

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

    private AccountDonDto create(final Don don) {

        AccountDonDto accountDonDto = new AccountDonDto();
        Long dondId = don.getDonId();
        accountDonDto.setDonId(dondId.toString());

        Address address = don.getAddress();
        AddressDto addressDto = this.addressAssembler.create(address);
        accountDonDto.setAddressDto(addressDto);

        accountDonDto.setKind(don.getKind());
        accountDonDto.setComment(don.getComment());
        accountDonDto.setIsConfidential(don.getIsConfidential());
        Edon edon = don.getEDon();
        accountDonDto.setEdon(edon.toString());

        return accountDonDto;
    }

    private Set<AccountDonDto> createList(Set<Don> dons) {

        Set<AccountDonDto> donListDtos = new HashSet<>();
        for (Don don : dons) {
            AccountDonDto accountDonDto = this.create(don);
            donListDtos.add(accountDonDto);
        }

        return donListDtos;
    }
}