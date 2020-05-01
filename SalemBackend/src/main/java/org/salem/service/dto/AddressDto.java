package org.salem.service.dto;

public class AddressDto {

    private String roadNumber;

    private String town;

    private String zipCode;

    private String phoneNumber;

    public AddressDto() {
    }

    public AddressDto(String roadNumber, String town, String zipCode, String phoneNumber) {
        this.roadNumber = roadNumber;
        this.town = town;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
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

}