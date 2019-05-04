package com.vladyka.souvenir_shop.api.advice;

import com.vladyka.souvenir_shop.api.dto.ExceptionResponse;
import com.vladyka.souvenir_shop.api.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage()));
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity handleInvalidDateException(InvalidDateException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(),e.getMessage()));
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity handleInvalidPriceException(InvalidPriceException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(),e.getMessage()));
    }

    @ExceptionHandler(InvalidCurrencyException.class)
    public ResponseEntity handleInvalidCurrencyException(InvalidCurrencyException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(),e.getMessage()));
    }

    @ExceptionHandler(InvalidProductNameException.class)
    public ResponseEntity handleInvalidProductNameException(InvalidProductNameException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(),e.getMessage()));
    }

    @ExceptionHandler(InvalidYearException.class)
    public ResponseEntity handleInvalidYearException(InvalidYearException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(),e.getMessage()));
    }
}