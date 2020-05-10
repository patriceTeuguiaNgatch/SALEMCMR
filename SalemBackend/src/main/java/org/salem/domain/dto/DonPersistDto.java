package org.salem.domain.dto;

import java.util.Objects;

import org.salem.domain.don.Edon;

public class DonPersistDto {

    private Long donId;

    private String value;

    private String roadNumber;

    private String town;

    private String zipCode;

    private String kind;

    private String phoneNumber;

    private String comment;

    private boolean isConfidential;

    private Edon eDon;

    private Long accountId;

    private String email;

    private String firstName;

    private String lastName;

    public DonPersistDto() {
    }

    public DonPersistDto(Long donId, String value, String roadNumber, String town, String zipCode, String kind,
            String phoneNumber, String comment, boolean isConfidential, Edon eDon, Long accountId, String email,
            String firstName, String lastName) {
        this.donId = donId;
        this.value = value;
        this.roadNumber = roadNumber;
        this.town = town;
        this.zipCode = zipCode;
        this.kind = kind;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.isConfidential = isConfidential;
        this.eDon = eDon;
        this.accountId = accountId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getDonId() {
        return this.donId;
    }

    public void setDonId(Long donId) {
        this.donId = donId;
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

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Edon getEDon() {
        return this.eDon;
    }

    public void setEDon(Edon eDon) {
        this.eDon = eDon;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DonPersistDto)) {
            return false;
        }
        DonPersistDto donPersistDto = (DonPersistDto) o;
        return Objects.equals(donId, donPersistDto.donId) && Objects.equals(roadNumber, donPersistDto.roadNumber)
                && Objects.equals(town, donPersistDto.town) && Objects.equals(zipCode, donPersistDto.zipCode)
                && Objects.equals(kind, donPersistDto.kind) && Objects.equals(phoneNumber, donPersistDto.phoneNumber)
                && Objects.equals(comment, donPersistDto.comment) && isConfidential == donPersistDto.isConfidential
                && Objects.equals(eDon, donPersistDto.eDon) && Objects.equals(accountId, donPersistDto.accountId)
                && Objects.equals(email, donPersistDto.email) && Objects.equals(firstName, donPersistDto.firstName)
                && Objects.equals(lastName, donPersistDto.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donId, roadNumber, town, zipCode, kind, phoneNumber, comment, isConfidential, eDon,
                accountId, email, firstName, lastName);
    }

}