package org.salem.domain.message;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.salem.domain.account.Name;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "messageId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;

    @Embedded
    private Name name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "comment", nullable = false)
    private String comment;

    public Message() {
    }

    public Message(Name name, String email, String phoneNumber, String comment) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    public Long getMessageId() {
        return this.messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
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
        if (!(o instanceof Message)) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId) && Objects.equals(name, message.name)
                && Objects.equals(email, message.email) && Objects.equals(phoneNumber, message.phoneNumber)
                && Objects.equals(comment, message.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, name, email, phoneNumber, comment);
    }

    @Override
    public String toString() {
        return "{" + " messageId='" + getMessageId() + "'" + ", name='" + getName() + "'" + ", email='" + getEmail()
                + "'" + ", phoneNumber='" + getPhoneNumber() + "'" + ", comment='" + getComment() + "'" + "}";
    }

}