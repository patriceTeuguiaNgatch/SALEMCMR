package org.salem.service.dto;

import java.util.Objects;

public class MessageDto {

    private String messageId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String comment;

    public MessageDto() {
    }

    public MessageDto(String messageId, String firstName, String lastName, String email, String phoneNumber,
            String comment) {
        this.messageId = messageId;
        this.firstName = firstName;
        this.lastName = lastName;
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MessageDto)) {
            return false;
        }
        MessageDto messageDto = (MessageDto) o;
        return Objects.equals(messageId, messageDto.messageId) && Objects.equals(firstName, messageDto.firstName)
                && Objects.equals(lastName, messageDto.lastName) && Objects.equals(email, messageDto.email)
                && Objects.equals(phoneNumber, messageDto.phoneNumber) && Objects.equals(comment, messageDto.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, firstName, lastName, email, phoneNumber, comment);
    }

    @Override
    public String toString() {
        return "{" + " messageId='" + getMessageId() + "'" + ", firstName='" + getFirstName() + "'" + ", lastName='"
                + getLastName() + "'" + ", email='" + getEmail() + "'" + ", phoneNumber='" + getPhoneNumber() + "'"
                + ", comment='" + getComment() + "'" + "}";
    }

}