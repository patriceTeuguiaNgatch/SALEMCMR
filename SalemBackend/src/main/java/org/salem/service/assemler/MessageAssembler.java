package org.salem.service.assemler;

import org.salem.domain.account.Name;
import org.salem.domain.message.Message;
import org.salem.service.dto.MessageDto;
import org.salem.service.dto.NameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageAssembler {

    @Autowired
    private final NameAssembler nameAssembler;

    public MessageAssembler(NameAssembler nameAssembler) {
        this.nameAssembler = nameAssembler;
    }

    public MessageDto create(final Message message) {
        final MessageDto messageDto = new MessageDto();
        messageDto.setMessageId(message.getMessageId().toString());
        final NameDto nameDto = this.nameAssembler.create(message.getName());
        messageDto.setNameDto(nameDto);
        messageDto.setEmail(message.getEmail());
        messageDto.setPhoneNumber(message.getPhoneNumber());
        messageDto.setComment(message.getComment());

        return messageDto;
    }

    public Message create(final MessageDto messageDto) {
        final Message message = new Message();
        final Name name = this.nameAssembler.create(messageDto.getNameDto());
        message.setName(name);
        message.setEmail(messageDto.getEmail());
        message.setPhoneNumber(messageDto.getPhoneNumber());
        message.setComment(messageDto.getComment());

        return message;
    }
}