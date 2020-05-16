package org.salem.controller.account;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.salem.controller.dto.AccountRequestDto;
import org.salem.controller.dto.AccountSignInDto;
import org.salem.controller.dto.ResponseDto;
import org.salem.controller.exception.ErrorDetail;
import org.salem.domain.exception.AccountAlreadyExistException;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.salem.domain.exception.ResourceNotFoundException;
import org.salem.service.account.AccountService;
import org.salem.service.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

@RestController
@RequestMapping(path = "/account")
@Validated
public class AccountController {

    @Autowired
    private final AccountService accountService;

    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    private static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());

    @PostMapping(path = "/subscriber/create", produces = "application/json", consumes = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDto> createAccountSubscriber(
            @RequestBody final @Valid AccountRequestDto accountRequestDto)
            throws InvalidAccountTypeException, AccountAlreadyExistException, Exception {

        LOGGER.info("Create the account : " + accountRequestDto.getFirstName() + " : " + LOGGER.getName());

        final AccountDto accountDto = accountService.createAccount(accountRequestDto);
        final ResponseDto responseDto = new ResponseDto(HttpStatus.CREATED.toString(), accountDto, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }

    @GetMapping(path = "/collection", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDto> findAllAccount() {

        LOGGER.info("Find all accounts: " + LOGGER.getName());

        final List<AccountDto> accountDtos = accountService.findAll();
        final ResponseDto responseDto = new ResponseDto(HttpStatus.OK.toString(), accountDtos, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public ResponseEntity<ResponseDto> findAccountById(@PathVariable(value = "id") @Positive final Long accountId)
            throws ResourceNotFoundException {

        LOGGER.info("Find the account : " + accountId + " : " + LOGGER.getName());

        final AccountDto accountDto = accountService.findAccountById(accountId);
        final ResponseDto responseDto = new ResponseDto(HttpStatus.OK.toString(), accountDto, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }

    @GetMapping(path = "/email/{email}", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public ResponseEntity<ResponseDto> findAccountByEamil(
            @PathVariable(value = "email") @NotNull(message = "Last name is required") @Size(max = 30) final String email)
            throws ResourceNotFoundException, AccountAlreadyExistException {

        LOGGER.info("Find the account by email  : " + email + " : " + LOGGER.getName());

        final AccountDto accountDto = accountService.findAccountByEmail(email);
        final ResponseDto responseDto = new ResponseDto(HttpStatus.OK.toString(), accountDto, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }

    @PostMapping(path = "/signIn", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public ResponseEntity<ResponseDto> singInAccount(@RequestBody final @Valid AccountSignInDto accountSignDto)
            throws ResourceNotFoundException, AccountAlreadyExistException {

        String email = accountSignDto.getEmail();
        LOGGER.info("Sign in the account by email  : " + email + " : " + LOGGER.getName());

        final AccountDto accountDto = accountService.singInAccount(accountSignDto);
        final ResponseDto responseDto = new ResponseDto(HttpStatus.OK.toString(), accountDto, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public ResponseEntity<ResponseDto> updateAccount(@PathVariable(value = "id") @Positive final Long accountId,
            @RequestBody final @Valid AccountRequestDto accountRequestDto) throws ResourceNotFoundException {

        LOGGER.info("Update the account : " + accountId + " : " + LOGGER.getName());

        final AccountDto accountDto = accountService.updateAccount(accountId, accountRequestDto);
        final ResponseDto responseDto = new ResponseDto(HttpStatus.OK.toString(), accountDto, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDto> deleteAccount(@PathVariable(value = "id") @Positive final Long accountId)
            throws ResourceNotFoundException {

        LOGGER.info("Delete the account : " + accountId + " : " + LOGGER.getName());

        final AccountDto accountDto = accountService.deleteAccount(accountId);
        final ResponseDto responseDto = new ResponseDto(HttpStatus.OK.toString(), accountDto, new ErrorDetail());

        return ResponseEntity.accepted().body(responseDto);
    }

}
