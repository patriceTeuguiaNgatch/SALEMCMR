package org.salem.domain.message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.salem.domain.account.Name;

public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long notifidationId;

    private Name name;

    private LocalDateTime creationDate;

    private String subject;

    private String message;

    public Notification() {
    }

    public Notification(final Name name, final LocalDateTime creationDate, final String subject, final String message) {
        this.name = name;
        this.creationDate = creationDate;
        this.subject = subject;
        this.message = message;
    }

    public Notification(final Long notifidationId, final Name name, final LocalDateTime creationDate,
            final String subject, final String message) {
        this.notifidationId = notifidationId;
        this.name = name;
        this.creationDate = creationDate;
        this.subject = subject;
        this.message = message;
    }

    public Long getNotifidationId() {
        return this.notifidationId;
    }

    public void setNotifidationId(final Long notifidationId) {
        this.notifidationId = notifidationId;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(final Name name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(final LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Notification)) {
            return false;
        }
        final Notification notification = (Notification) o;
        return Objects.equals(notifidationId, notification.notifidationId) && Objects.equals(name, notification.name)
                && Objects.equals(creationDate, notification.creationDate)
                && Objects.equals(subject, notification.subject) && Objects.equals(message, notification.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notifidationId, name, creationDate, subject, message);
    }

}