package org.salem.service.message;

import java.util.logging.Logger;

import org.salem.controller.dto.MessageRequestDto;
import org.salem.domain.message.Message;
import org.salem.domain.message.MessageRepository;
import org.salem.service.assemler.MessageAssembler;
import org.salem.service.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private final MessageAssembler messageAssembler;
    @Autowired
    private final MessageRepository messageRepository;

    public MessageService(final MessageAssembler messageAssembler, final MessageRepository messageRepository) {
        this.messageAssembler = messageAssembler;
        this.messageRepository = messageRepository;
    }

    private static final Logger LOGGER = Logger.getLogger(MessageService.class.getName());

    public MessageDto createMessage(final MessageRequestDto messageRequestDto) {

        LOGGER.info("Create the message : " + messageRequestDto.getEmail() + " : " + LOGGER.getName());

        final Message message = new Message(messageRequestDto.getFirstName(), messageRequestDto.getLastName(),
                messageRequestDto.getEmail(), messageRequestDto.getPhoneNumber(), messageRequestDto.getComment());
        final Message messageSave = this.messageRepository.save(message);
        final MessageDto messageDto = this.messageAssembler.create(messageSave);
        return messageDto;
    }

}