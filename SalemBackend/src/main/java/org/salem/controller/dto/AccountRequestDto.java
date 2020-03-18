package org.salem.controller.dto;

public class AccountRequestDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String role;

    public AccountRequestDto() {
    }

    public AccountRequestDto(String email, String password, String firstName, String lastName, String telephoneNumber,
            String role) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AccountRequestDto email(String email) {
        this.email = email;
        return this;
    }

    public AccountRequestDto password(String password) {
        this.password = password;
        return this;
    }

    public AccountRequestDto firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AccountRequestDto lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccountRequestDto telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public AccountRequestDto role(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " email='" + getEmail() + "'" + ", password='" + getPassword() + "'" + ", firstName='"
                + getFirstName() + "'" + ", lastName='" + getLastName() + "'" + ", telephoneNumber='"
                + getTelephoneNumber() + "'" + ", role='" + getRole() + "'" + "}";
    }

}