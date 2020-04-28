package org.salem.controller.account.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageRequestDto {

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

    @Size(max = 15)
    private String phoneNumber;

    @NotNull(message = "Comment is required")
    @Size(min = 6, max = 200)
    private String comment;

    public MessageRequestDto() {

    }

    public MessageRequestDto(String firstName, String lastName, String email, String phoneNumber, String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = message;
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

}