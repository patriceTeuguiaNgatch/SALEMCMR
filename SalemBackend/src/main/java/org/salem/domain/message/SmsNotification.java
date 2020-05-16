package org.salem.domain.message;

import java.time.LocalDateTime;
import java.util.Objects;

import org.salem.domain.account.Name;

public class SmsNotification extends Notification {

    private static final long serialVersionUID = 1L;

    private String phoneNumber;

    public SmsNotification() {
        super();
    }

    public SmsNotification(Name name, LocalDateTime creationDate, String subject, String message, String phoneNumber) {
        super(name, creationDate, subject, message);
        this.phoneNumber = phoneNumber;
    }

    public SmsNotification(Long notifidationId, Name name, LocalDateTime creationDate, String subject, String message,
            String phoneNumber) {
        super(notifidationId, name, creationDate, subject, message);
        this.phoneNumber = phoneNumber;
    }

    public SmsNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SmsNotification)) {
            return false;
        }
        SmsNotification smsNotification = (SmsNotification) o;
        return Objects.equals(phoneNumber, smsNotification.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(phoneNumber);
    }

}