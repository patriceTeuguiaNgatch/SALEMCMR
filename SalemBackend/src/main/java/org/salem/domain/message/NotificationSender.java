package org.salem.domain.message;

public interface NotificationSender<Notification> {

    public Class<Notification> appliesTo();

    public void send(Notification notification) throws Exception;

}