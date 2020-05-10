package org.salem.service.dto;

public class DonDto {

    private String donId;

    private String value;

    private AddressDto addressDto;

    private String kind;

    private String comment;

    private boolean isConfidential;

    private DonAccountDto donAccountDto;

    private String edon;

    public DonDto() {
    }

    public DonDto(String donId, String value, String email, AddressDto addressDto, String kind, String comment,
            boolean isConfidential, DonAccountDto donAccountDto) {
        this.donId = donId;
        this.value = value;
        this.addressDto = addressDto;
        this.kind = kind;
        this.comment = comment;
        this.isConfidential = isConfidential;
        this.donAccountDto = donAccountDto;
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

    public String getKing() {
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

    public DonAccountDto getDonAccountDto() {
        return this.donAccountDto;
    }

    public void setDonAccountDto(DonAccountDto donAccountDto) {
        this.donAccountDto = donAccountDto;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}