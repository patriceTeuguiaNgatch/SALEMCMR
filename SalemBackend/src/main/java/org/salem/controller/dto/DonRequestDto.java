package org.salem.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.salem.controller.exception.DonPreference;

public class DonRequestDto {

    @NotNull(message = "First name is required")
    @Size(min = 1, max = 30)
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, max = 30)
    private String lastName;

    @NotNull(message = "Email is required")
    @Size(max = 30)
    @Email
    private String email;

    @Size(max = 255)
    private String roadNumber;

    @Size(max = 30)
    private String town;

    @Size(max = 10)
    private String zipCode;

    @Size(max = 20)
    private String phoneNumber;

    @Size(max = 200)
    private String king;

    @Size(max = 100)
    private String comment;

    @NotNull(message = "First name is required")
    private boolean isConfidential;

    @NotNull(message = "Don type is required")
    @DonPreference
    private String eDon;

    public DonRequestDto() {
    }

    public DonRequestDto(String firstName, String lastName, String email, String roadNumber, String town,
            String zipCode, String phoneNumber, String king, String comment, boolean isConfidential) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roadNumber = roadNumber;
        this.town = town;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.king = king;
        this.comment = comment;
        this.isConfidential = isConfidential;
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

    public String getKing() {
        return this.king;
    }

    public void setKing(String king) {
        this.king = king;
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

    public String getEDon() {
        return this.eDon;
    }

    public void setEDon(String eDon) {
        this.eDon = eDon;
    }
}