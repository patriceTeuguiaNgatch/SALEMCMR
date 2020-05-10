package org.salem.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.salem.controller.exception.DonPreference;

public class DonFinancialRequestDto {

    @NotNull(message = "First name is required")
    @Size(min = 1, max = 30)
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, max = 30)
    private String lastName;

    @NotNull(message = "Email is required")
    @Size(max = 100)
    @Email
    private String email;

    @NotNull(message = "Stripe payment token is required")
    @Size(min = 1)
    private String token;

    @NotNull(message = "value is required")
    @Size(min = 1, max = 100)
    private String value;

    @NotNull(message = "Currency is required")
    @Size(min = 1, max = 5)
    private String currency;

    @Size(max = 20)
    private String phoneNumber;

    @Size(max = 200)
    private String kind;

    @Size(max = 100)
    private String comment;

    private boolean isConfidential;

    @NotNull(message = "Don type is required")
    @DonPreference
    private String edon;

    public DonFinancialRequestDto() {
    }

    public DonFinancialRequestDto(String firstName, String lastName, String email, String value, String currency,
            String token, String phoneNumber, String kind, String comment, boolean isConfidential, String edon) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.value = value;
        this.currency = currency;
        this.token = token;
        this.phoneNumber = phoneNumber;
        this.kind = kind;
        this.comment = comment;
        this.isConfidential = isConfidential;
        this.edon = edon;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isIsConfidential() {
        return this.isConfidential;
    }

    public boolean getIsConfidential() {
        return this.isConfidential;
    }

    public void setIsConfidential(boolean isConfidential) {
        this.isConfidential = isConfidential;
    }

    public String getEdon() {
        return this.edon;
    }

    public void setEdon(String edon) {
        this.edon = edon;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}