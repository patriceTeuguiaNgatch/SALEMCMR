package org.salem.service.message;

import java.util.List;

import org.salem.domain.message.Notification;
import org.salem.service.account.AccountService;

public abstract class NotificationServiceObserver {

    protected AccountService accountService;

    public abstract void send(final List<Notification> notifications) throws Exception;

}