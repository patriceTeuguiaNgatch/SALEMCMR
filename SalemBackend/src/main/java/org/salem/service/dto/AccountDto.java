package org.salem.service.dto;

import java.util.Set;

public class AccountDto {

    private String accountId;

    private NameDto namedDto;

    private String password;

    private String email;

    private Set<String> roles;

    private Set<AccountDonDto> accountDonDtos;

    public AccountDto() {
    }

    public AccountDto(NameDto namedDto, String password, String email, Set<String> roles,
            Set<AccountDonDto> accountDonDtos) {
        this.namedDto = namedDto;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.accountDonDtos = accountDonDtos;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public NameDto getNameDto() {
        return this.namedDto;
    }

    public void setNameDto(NameDto nameDto) {
        this.namedDto = nameDto;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<AccountDonDto> getAccountDonDtos() {
        return this.accountDonDtos;
    }

    public void setAccountDonDtos(Set<AccountDonDto> accountDonDtos) {
        this.accountDonDtos = accountDonDtos;
    }

}