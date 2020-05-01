package org.salem.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountSignInDto {

    @NotNull(message = "Email is required")
    @Size(max = 30)
    @Email
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 6, max = 255)
    private String password;

    public AccountSignInDto() {
    }

    public AccountSignInDto(String password, String email) {

        this.password = password;
        this.email = email;
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
}