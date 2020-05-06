package org.salem.service.dto;

public class DonAccountDto {

    private String accountId;

    private NameDto namedDto;

    private String email;

    public DonAccountDto() {
    }

    public DonAccountDto(NameDto namedDto, String email) {
        this.namedDto = namedDto;
        this.email = email;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public NameDto getNameDto() {
        return this.namedDto;
    }

    public void setNameDto(NameDto nameDto) {
        this.namedDto = nameDto;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}