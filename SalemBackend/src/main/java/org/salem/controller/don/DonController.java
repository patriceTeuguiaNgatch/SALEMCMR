// package org.salem.controller.don;

// import java.util.logging.Logger;

// import javax.validation.Valid;

// import org.salem.controller.dto.DonRequestDto;
// import org.salem.controller.dto.ResponseDto;
// import org.salem.controller.exception.ErrorDetail;
// import org.salem.service.don.DonService;
// import org.salem.service.dto.DonDto;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.http.HttpStatus;

// @Controller
// @RequestMapping(path = "/don")
// @Validated
// public class DonController {

// @Autowired
// private final DonService donService;

// public DonController(final DonService donService) {
// this.donService = donService;
// }

// private static final Logger LOGGER =
// Logger.getLogger(DonController.class.getName());

// @PostMapping(path = "/material", produces = "application/json", consumes =
// "application/json")
// @ResponseBody
// @ResponseStatus(HttpStatus.CREATED)
// public ResponseEntity<ResponseDto> createAccountSubscriber(@RequestBody final
// @Valid DonRequestDto donRequestDto)
// throws Exception {

// LOGGER.info("Create the don : " + donRequestDto.getFirstName() + " : " +
// LOGGER.getName());

// final DonDto donDto = donService.createDon(donRequestDto);
// final ResponseDto responseDto = new
// ResponseDto(HttpStatus.CREATED.toString(), donDto, new ErrorDetail());

// return ResponseEntity.accepted().body(responseDto);
// }

// }