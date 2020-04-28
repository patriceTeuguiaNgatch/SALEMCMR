package org.salem.service.assemler;

import org.salem.domain.message.Message;
import org.salem.service.dto.MessageDto;
import org.springframework.stereotype.Component;

@Component
public class MessageAssembler {

    public MessageAssembler() {

    }

    public MessageDto create(final Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessageId(message.getMessageId().toString());
        messageDto.setFirstName(message.getFirstName());
        messageDto.setLastName(message.getLastName());
        messageDto.setEmail(message.getEmail());
        messageDto.setPhoneNumber(message.getPhoneNumber());
        messageDto.setComment(message.getComment());

        return messageDto;
    }

    public Message create(final MessageDto messageDto) {
        Message message = new Message();
        message.setFirstName(messageDto.getFirstName());
        message.setLastName(messageDto.getLastName());
        message.setEmail(messageDto.getEmail());
        message.setPhoneNumber(messageDto.getPhoneNumber());
        message.setComment(messageDto.getComment());

        return message;
    }
}