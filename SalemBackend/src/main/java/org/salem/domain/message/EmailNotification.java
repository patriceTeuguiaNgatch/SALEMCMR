package org.salem.domain.message;

import java.time.LocalDateTime;
import java.util.Objects;

import org.salem.domain.account.Name;

public class EmailNotification extends Notification {

    private static final long serialVersionUID = 1L;

    private String emailRecipient;

    private String emailSender;

    public EmailNotification() {
        super();
    }

    public EmailNotification(Name name, LocalDateTime creationDate, String subject, String message, String emailSender,
            String emailRecipient) {
        super(name, creationDate, subject, message);
        this.emailSender = emailSender;
        this.emailRecipient = emailRecipient;
    }

    public EmailNotification(Long notifidationId, Name name, LocalDateTime creationDate, String subject, String message,
            String email) {
        super(notifidationId, name, creationDate, subject, message);
        this.emailSender = email;
    }

    public EmailNotification(String email) {
        this.emailSender = email;
    }

    public String getEmailSender() {
        return this.emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public String getEmailRecipient() {
        return this.emailRecipient;
    }

    public void setEmailRecipient(String emailRecipient) {
        this.emailRecipient = emailRecipient;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmailNotification)) {
            return false;
        }
        EmailNotification emailNotification = (EmailNotification) o;
        return Objects.equals(emailRecipient, emailNotification.emailRecipient)
                && Objects.equals(emailSender, emailNotification.emailSender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailRecipient, emailSender);
    }

}