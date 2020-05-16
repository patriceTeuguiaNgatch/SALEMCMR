package org.salem.service.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.salem.domain.message.Notification;
import org.salem.domain.message.NotificationSender;
import org.salem.infrastructure.EmailNotificationSender;
import org.salem.infrastructure.SmsNotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderService {

    @Autowired
    private EmailNotificationSender emailNotificationSender;

    private List<NotificationSender> notificationSenders;

    private Map<Class<? extends Notification>, NotificationSender> notificationSenderMap;

    public NotificationSenderService(EmailNotificationSender emailNotificationSender) {
        this.emailNotificationSender = emailNotificationSender;
        this.initiliazeNotificationSender();
        this.initiliazeNotificationSenderMap();
    }

    private static final Logger LOGGER = Logger.getLogger(NotificationSenderService.class.getName());

    @SuppressWarnings("unchecked")
    public void send(final List<Notification> notifications) throws Exception {

        LOGGER.info("Send notification  : " + LOGGER.getName());

        for (final Notification notification : notifications) {
            notificationSenderMap.get(notification.getClass()).send(notification);
        }
    }

    private void initiliazeNotificationSender() {
        this.notificationSenders = new ArrayList<>();
        this.notificationSenders.add(this.emailNotificationSender);
        this.notificationSenders.add(new SmsNotificationSender());
    }

    @SuppressWarnings("unchecked")
    private void initiliazeNotificationSenderMap() {
        this.notificationSenderMap = new HashMap<>();
        for (final NotificationSender notificationSender : notificationSenders) {
            notificationSenderMap.put(notificationSender.appliesTo(), notificationSender);
        }
    }

}