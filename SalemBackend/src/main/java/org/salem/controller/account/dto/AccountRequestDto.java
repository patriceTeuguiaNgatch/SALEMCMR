package org.salem.controller.account.dto;

public class AccountRequestDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;

    public AccountRequestDto() {
    }

    public AccountRequestDto(String firstName, String lastName, String password, String email, String phoneNumber,
            String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public AccountRequestDto telephoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public AccountRequestDto role(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " email='" + getEmail() + "'" + ", password='" + getPassword() + "'" + ", firstName='"
                + getFirstName() + "'" + ", lastName='" + getLastName() + "'" + ", phoneNumber='" + getPhoneNumber()
                + "'" + ", role='" + getRole() + "'" + "}";
    }

}