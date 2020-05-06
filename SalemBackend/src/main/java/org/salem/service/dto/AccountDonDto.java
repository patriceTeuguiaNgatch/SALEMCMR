package org.salem.service.dto;

public class AccountDonDto {

    private String donId;

    private AddressDto addressDto;

    private String kind;

    private String comment;

    private boolean isConfidential;

    private String edon;

    public AccountDonDto() {
    }

    public AccountDonDto(String donId, String email, AddressDto addressDto, String kind, String comment,
            boolean isConfidential) {
        this.donId = donId;
        this.addressDto = addressDto;
        this.kind = kind;
        this.comment = comment;
        this.isConfidential = isConfidential;
    }

    public String getDonId() {
        return this.donId;
    }

    public void setDonId(String donId) {
        this.donId = donId;
    }

    public AddressDto getAddressDto() {
        return this.addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
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

}