package org.salem.controller;

import java.net.URI;
import java.util.logging.Logger;

import org.salem.controller.dto.AccountRequestDto;
import org.salem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    @Autowired
    private final AccountService accountService;
    @Autowired
    private final AccountValidator accountValidator;

    public AccountController(final AccountService accountService, final AccountValidator accountValidator) {
        this.accountService = accountService;
        this.accountValidator = accountValidator;
    }

    private static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());

    @PostMapping(path = "/volunteer/create", produces = "application/json", consumes = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createAccountVolunteer(@RequestBody final AccountRequestDto accountRequestDto)
            throws Exception {

        LOGGER.info("Create the account : " + accountRequestDto.getFirstName() + " : " + LOGGER.getName());

        final String accountId = accountRequestDto.getEmail();
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{accountId}")
                .buildAndExpand(accountId).toUri();
        return ResponseEntity.created(location).build();
    }

}