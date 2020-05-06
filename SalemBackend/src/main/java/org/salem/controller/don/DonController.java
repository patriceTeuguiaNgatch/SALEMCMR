package org.salem.controller.don;

import java.util.List;
import java.util.logging.Logger;

import org.salem.controller.dto.ResponseDto;
import org.salem.controller.exception.ErrorDetail;
import org.salem.service.don.DonService;
import org.salem.service.dto.DonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(path = "/don")
@Validated
public class DonController {

    @Autowired
    private final DonService donService;

    public DonController(final DonService donService) {
        this.donService = donService;
    }

    private static final Logger LOGGER = Logger.getLogger(DonController.class.getName());

    @GetMapping(path = "/collection", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDto> createAccountSubscriber() throws Exception {

        LOGGER.info("Find all don : " + LOGGER.getName());

        final List<DonDto> donDtos = donService.findAllDon();
        final ResponseDto responseDto = new ResponseDto(HttpStatus.CREATED.toString(), donDtos, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }
}