package org.salem.controller.account.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.salem.controller.exception.RolePreference;

public class AccountRequestDto {

    @NotNull(message = "Email is required")
    @Size(max = 30)
    @Email
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 6, max = 20)
    private String password;

    @NotNull(message = "First name is required")
    @Size(min = 1, max = 30)
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, max = 30)
    private String lastName;

    @Size(max = 15)
    private String phoneNumber;

    @NotNull(message = "Role is required")
    @RolePreference
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

}