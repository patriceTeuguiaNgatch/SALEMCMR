package org.salem.controller.message;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.salem.controller.account.dto.MessageRequestDto;
import org.salem.controller.account.dto.ResponseDto;
import org.salem.controller.exception.ErrorDetail;
import org.salem.service.dto.MessageDto;
import org.salem.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "message")
@Validated
public class MessageController {

    @Autowired
    private final MessageService messageService;

    public MessageController(final MessageService messageService) {
        this.messageService = messageService;
    }

    private static final Logger LOGGER = Logger.getLogger(MessageController.class.getName());

    @PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDto> createMessage(@RequestBody final @Valid MessageRequestDto messageRequestDto)
            throws Exception {

        LOGGER.info("Create the message : " + messageRequestDto.getEmail() + " : " + LOGGER.getName());

        final MessageDto messageDto = messageService.createMessage(messageRequestDto);
        final ResponseDto responseDto = new ResponseDto(HttpStatus.CREATED.toString(), messageDto, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }

}