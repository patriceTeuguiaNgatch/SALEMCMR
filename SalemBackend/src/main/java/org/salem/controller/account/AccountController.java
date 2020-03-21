package org.salem.controller.account;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.salem.controller.account.dto.AccountRequestDto;
import org.salem.service.account.AccountService;
import org.salem.service.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/account")
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

    @PostMapping(path = "/subscriber/create", produces = "application/json", consumes = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createAccountSubscriber(@RequestBody final AccountRequestDto accountRequestDto)
            throws Exception {

        LOGGER.info("Create the account : " + accountRequestDto.getFirstName() + " : " + LOGGER.getName());

        final Long accountId = accountService.createAccount(accountRequestDto);

        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{accountId}")
                .buildAndExpand(accountId).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/collection", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AccountDto>> findAllAccount() throws Exception {

        LOGGER.info("Find all accounts: " + LOGGER.getName());

        final List<AccountDto> accountDtos = accountService.findAll();

        return ResponseEntity.accepted().body(accountDtos);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AccountDto> findAccountById(@PathVariable(value = "id") final String accountId)
            throws Exception {

        LOGGER.info("Create the account : " + accountId + " : " + LOGGER.getName());

        final AccountDto accountDto = accountService.findAccountById(accountId);

        return ResponseEntity.accepted().body(accountDto);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AccountDto> updateAccount(@PathVariable(value = "id") final String accountId,
            @RequestBody final AccountRequestDto accountRequestDto) throws Exception {

        LOGGER.info("Update the account : " + accountId + " : " + LOGGER.getName());

        final AccountDto accountDto = accountService.updateAccount(accountId, accountRequestDto);

        return ResponseEntity.accepted().body(accountDto);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") String accountId) throws Exception {

        LOGGER.info("Delete the account : " + accountId + " : " + LOGGER.getName());

        final Map<String, Boolean> response = accountService.deleteAccount(accountId);

        return response;
    }

}