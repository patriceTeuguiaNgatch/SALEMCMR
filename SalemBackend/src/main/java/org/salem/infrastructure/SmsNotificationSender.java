package org.salem.infrastructure;

import java.util.logging.Logger;

import org.salem.domain.message.NotificationSender;
import org.salem.domain.message.SmsNotification;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationSender implements NotificationSender<SmsNotification> {

    private static final Logger LOGGER = Logger.getLogger(SmsNotificationSender.class.getName());

    public SmsNotificationSender() {
    }

    @Override
    public Class<SmsNotification> appliesTo() {
        return SmsNotification.class;
    }

    @Override
    public void send(SmsNotification smsNotification) throws Exception {

        LOGGER.info("Send sms notification to : " + smsNotification.getName().toString() + " : " + LOGGER.getName());

        // TODO implement logic java send sms
    }

}