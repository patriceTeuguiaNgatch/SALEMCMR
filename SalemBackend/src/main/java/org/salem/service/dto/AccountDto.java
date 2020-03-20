package org.salem.service.dto;

import java.util.Set;

public class AccountDto {

    private String accountId;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String telephoneNumber;

    private Set<String> roles;

    public AccountDto() {
    }

    public AccountDto(String firstName, String lastName, String password, String email, String telephoneNumber,
            Set<String> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.roles = roles;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "{" + " firstName='" + getFirstName() + "'" + ", lastName='" + getLastName() + "'" + ", password='"
                + getPassword() + "'" + ", email='" + getEmail() + "'" + ", telephoneNumber='" + getTelephoneNumber()
                + "'" + ", roles='" + getRoles() + "'" + "}";
    }

}