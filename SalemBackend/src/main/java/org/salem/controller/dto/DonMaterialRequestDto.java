package org.salem.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.salem.controller.exception.DonPreference;

public class DonMaterialRequestDto {

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

    private String value;

    @Size(max = 255)
    private String roadNumber;

    @Size(max = 30)
    private String town;

    @Size(max = 10)
    private String zipCode;

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

    public DonMaterialRequestDto() {
    }

    public DonMaterialRequestDto(String value, String firstName, String lastName, String email, String roadNumber,
            String town, String zipCode, String phoneNumber, String kind, String comment, boolean isConfidential,
            String edon) {
        this.value = value;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roadNumber = roadNumber;
        this.town = town;
        this.zipCode = zipCode;
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

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public void setKind(String king) {
        this.kind = king;
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

}