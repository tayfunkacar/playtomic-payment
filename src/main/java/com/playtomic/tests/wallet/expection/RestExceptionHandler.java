package com.playtomic.tests.wallet.expection;

import com.playtomic.tests.wallet.handler.StripeAmountTooSmallException;
import com.playtomic.tests.wallet.handler.StripeServiceException;
import com.playtomic.tests.wallet.model.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(StripeServiceException.class)
    public ResponseEntity<ResponseDto> stripeServiceException(StripeServiceException ex) {
        ResponseDto errorResponse = new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(StripeAmountTooSmallException.class)
    public ResponseEntity<ResponseDto> stripeAmountTooSmallException(StripeAmountTooSmallException ex) {
        ResponseDto errorResponse = new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
