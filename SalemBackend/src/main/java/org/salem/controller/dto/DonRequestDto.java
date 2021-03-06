package org.salem.controller.dto;

public class DonRequestDto {

    private String firstName;

    private String lastName;

    private String email;

    private String value;

    private String roadNumber;

    private String town;

    private String zipCode;

    private String phoneNumber;

    private String kind;

    private String comment;

    private boolean isConfidential;

    private String edon;

    public DonRequestDto() {
    }

    public DonRequestDto(String value, String firstName, String lastName, String email, String roadNumber, String town,
            String zipCode, String phoneNumber, String kind, String comment, boolean isConfidential, String edon) {
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