package org.salem.controller.transaction;

import java.util.Date;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.salem.controller.dto.DonFinancialRequestDto;
import org.salem.controller.dto.ResponseDto;
import org.salem.controller.exception.ErrorDetail;
import org.salem.service.transaction.FinancialTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping(path = "/financial")
@Validated
public class FinancialTransactionController {

    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    @Autowired
    private final FinancialTransactionService financialTransactionService;

    public FinancialTransactionController(final FinancialTransactionService financialTransactionService) {
        this.financialTransactionService = financialTransactionService;
    }

    private static final Logger LOGGER = Logger.getLogger(FinancialTransactionController.class.getName());

    @PostMapping(path = "/subscription/create", produces = "application/json", consumes = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDto> createSubscription(String email, String token, String plan, String coupon) {

        LOGGER.info("Create subscription : " + email + " : " + LOGGER.getName());

        // validate data
        if (token == null || plan.isEmpty()) {
            ErrorDetail errorDetail = new ErrorDetail(new Date(), "false",
                    "Stripe payment token is missing. Please, try again later.");
            final ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetail);

            return ResponseEntity.accepted().body(responseDto);
        }

        // create customer first
        String customerId = financialTransactionService.createCustomer(email, token);

        if (customerId == null) {
            ErrorDetail errorDetail = new ErrorDetail(new Date(), "false",
                    "An error occurred while trying to create a customer.");
            final ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetail);

            return ResponseEntity.accepted().body(responseDto);

        }

        // create subscription
        String subscriptionId = financialTransactionService.createSubscription(customerId, plan, coupon);
        if (subscriptionId == null) {

            ErrorDetail errorDetail = new ErrorDetail(new Date(), "false",
                    "An error occurred while trying to create a subscription.");
            final ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetail);

            return ResponseEntity.accepted().body(responseDto);
        }

        // Ideally you should store customerId and subscriptionId along with customer
        // object here.
        // These values are required to update or cancel the subscription at later
        // stage.

        ErrorDetail errorDetail = new ErrorDetail(new Date(), subscriptionId, "Success! Your subscription id is ");
        final ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetail);

        return ResponseEntity.accepted().body(responseDto);

    }

    // @PostMapping("/cancel-subscription")
    // public @ResponseBody Response cancelSubscription(String subscriptionId) {
    // boolean status = stripeService.cancelSubscription(subscriptionId);
    // if (!status) {
    // return new Response(false, "Failed to cancel the subscription. Please, try
    // later.");
    // }
    // return new Response(true, "Subscription cancelled successfully.");
    // }

    // @PostMapping("/coupon-validator")
    // public @ResponseBody Response couponValidator(String code) {
    // Coupon coupon = stripeService.retrieveCoupon(code);
    // if (coupon != null && coupon.getValid()) {
    // String details = (coupon.getPercentOff() == null ? "$" +
    // (coupon.getAmountOff() / 100)
    // : coupon.getPercentOff() + "%") + " OFF " + coupon.getDuration();
    // return new Response(true, details);
    // } else {
    // return new Response(false, "This coupon code is not available. This may be
    // because it has expired or has "
    // + "already been applied to your account.");
    // }
    // }

    @PostMapping(path = "/charge", produces = "application/json", consumes = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDto> createCharge(
            @RequestBody final @Valid DonFinancialRequestDto donFinancialRequestDto) {
        String email = donFinancialRequestDto.getEmail();
        String token = donFinancialRequestDto.getToken();
        // validate data
        if (token == null) {

            ErrorDetail errorDetail = new ErrorDetail(new Date(), "false",
                    "Stripe payment token is missing. Please, try again later.");
            final ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetail);

            return ResponseEntity.accepted().body(responseDto);

            ///
        }

        // create charge
        String chargeId = financialTransactionService.createCharge(email, token, 999); // $9.99 USD
        if (chargeId == null) {

            ErrorDetail errorDetail = new ErrorDetail(new Date(), "false",
                    "An error occurred while trying to create a charge.");
            final ResponseDto responseDto = new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.toString(), null,
                    errorDetail);

            return ResponseEntity.accepted().body(responseDto);

            ////
        }

        // You may want to store charge id along with order information

        ErrorDetail errorDetail = new ErrorDetail(new Date(), chargeId, "Success! Your charge id is ");
        final ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetail);

        return ResponseEntity.accepted().body(responseDto);

        ////
    }

}