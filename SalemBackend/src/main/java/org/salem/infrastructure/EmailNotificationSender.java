package org.salem.infrastructure;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.salem.domain.message.EmailNotification;
import org.salem.domain.message.NotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationSender implements NotificationSender<EmailNotification> {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${path.picture.logo}")
    String PATH_PICTURE_LOGO = "pictureLogo.png";

    public EmailNotificationSender() {
    }

    public EmailNotificationSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public Class<EmailNotification> appliesTo() {
        return EmailNotification.class;
    }

    private static final Logger LOGGER = Logger.getLogger(EmailNotificationSender.class.getName());

    @Override
    public void send(EmailNotification emailNotification) throws MessagingException, IOException {

        LOGGER.info("Send email notification to : " + emailNotification.getName().toString() + " : " + LOGGER.getName()
                + emailNotification.getCreationDate());
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(emailNotification.getEmailRecipient());
        mimeMessageHelper.setFrom(emailNotification.getEmailSender());
        mimeMessageHelper.setSubject(emailNotification.getSubject());
        // mimeMessageHelper.addAttachment("pictureLogo.png", new
        // ClassPathResource(PATH_PICTURE_LOGO));
        mimeMessageHelper.setText(emailNotification.getMessage(), true);

        javaMailSender.send(mimeMessage);
    }

}