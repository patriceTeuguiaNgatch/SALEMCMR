package org.salem.service.dto;

public class DonDto {

    private String donId;

    private AddressDto addressDto;

    private String king;

    private String comment;

    private boolean isConfidential;

    private AccountDto accountDto;

    private String edon;

    public DonDto() {
    }

    public DonDto(String donId, String email, AddressDto addressDto, String king, String comment,
            boolean isConfidential, AccountDto accountDto) {
        this.donId = donId;
        this.addressDto = addressDto;
        this.king = king;
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

    public AccountDto getAccountDto() {
        return this.accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public String getEdon() {
        return this.edon;
    }

    public void setEdon(String edon) {
        this.edon = edon;
    }

}