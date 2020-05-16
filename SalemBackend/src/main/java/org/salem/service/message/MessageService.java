package org.salem.service.message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.salem.controller.dto.MessageRequestDto;
import org.salem.domain.account.Name;
import org.salem.domain.message.EmailNotification;
import org.salem.domain.message.Message;
import org.salem.domain.message.MessageInformation;
import org.salem.domain.message.MessageRepository;
import org.salem.domain.message.Notification;
import org.salem.service.assemler.MessageAssembler;
import org.salem.service.assemler.NameAssembler;
import org.salem.service.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private final MessageAssembler messageAssembler;

    @Autowired
    private final NameAssembler nameAssembler;

    @Autowired
    private final MessageRepository messageRepository;

    @Autowired
    private final NotificationSenderService notificationSenderService;

    @Value("${spring.mail.username}")
    private String emailSalem;

    public MessageService(final MessageAssembler messageAssembler, final NameAssembler nameAssembler,
            final MessageRepository messageRepository, final NotificationSenderService notificationSenderService) {
        this.messageAssembler = messageAssembler;
        this.nameAssembler = nameAssembler;
        this.messageRepository = messageRepository;
        this.notificationSenderService = notificationSenderService;
    }

    private static final Logger LOGGER = Logger.getLogger(MessageService.class.getName());

    public MessageDto createMessage(final MessageRequestDto messageRequestDto) throws Exception {

        LOGGER.info("Create the message : " + messageRequestDto.getEmail() + " : " + LOGGER.getName());

        Name name = this.nameAssembler.createName(messageRequestDto.getFirstName(), messageRequestDto.getLastName());
        final Message message = new Message(name, messageRequestDto.getEmail(), messageRequestDto.getPhoneNumber(),
                messageRequestDto.getComment());
        final Message messageSave = this.messageRepository.save(message);
        final MessageDto messageDto = this.messageAssembler.create(messageSave);

        return messageDto;
    }

    public MessageDto createMessageConfirmation(final MessageRequestDto messageRequestDto) throws Exception {

        LOGGER.info("Create the message confirmation : " + messageRequestDto.getEmail() + " : " + LOGGER.getName());

        Name name = this.nameAssembler.createName(messageRequestDto.getFirstName(), messageRequestDto.getLastName());
        final Message message = new Message(name, messageRequestDto.getEmail(), messageRequestDto.getPhoneNumber(),
                messageRequestDto.getComment());

        final EmailNotification emailNotification = new EmailNotification();
        emailNotification.setEmailSender(message.getEmail());
        emailNotification.setEmailRecipient(emailSalem);
        emailNotification.setCreationDate(LocalDateTime.now());

        String subject = MessageInformation.DEMANDE_INFORMATION;
        String mesageSend = MessageInformation.formateRequestInformation(message);
        emailNotification.setSubject(subject);
        emailNotification.setMessage(mesageSend);
        emailNotification.setName(name);

        final List<Notification> notifications = new ArrayList<>();
        notifications.add(emailNotification);

        this.notificationSenderService.send(notifications);

        return new MessageDto();
    }

}