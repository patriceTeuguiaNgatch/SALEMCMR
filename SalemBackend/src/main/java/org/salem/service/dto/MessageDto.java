package org.salem.service.dto;

public class MessageDto {

    private String messageId;

    private NameDto nameDto;

    private String email;

    private String phoneNumber;

    private String comment;

    public MessageDto() {
    }

    public MessageDto(String messageId, NameDto nameDto, String email, String phoneNumber, String comment) {
        this.messageId = messageId;
        this.nameDto = nameDto;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public NameDto getNameDto() {
        return this.nameDto;
    }

    public void setNameDto(NameDto nameDto) {
        this.nameDto = nameDto;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "{" + " messageId='" + getMessageId() + "'" + ", nameDto='" + getNameDto() + "'" + ", email='"
                + getEmail() + "'" + ", phoneNumber='" + getPhoneNumber() + "'" + ", comment='" + getComment() + "'"
                + "}";
    }

}