package com.wedogift.backend.controllers;

import com.wedogift.backend.exceptions.CompanyNonFoundException;
import com.wedogift.backend.exceptions.ErrorDto;
import com.wedogift.backend.exceptions.NotEnoughBalanceException;
import com.wedogift.backend.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice()
public class GlobalExeptionHandler {
    @ExceptionHandler({CompanyNonFoundException.class, UserNotFoundException.class})
    public ResponseEntity<ErrorDto> handleFunctionalMessageException(CompanyNonFoundException ex) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDto.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND.value()).build() );
    }
    @ExceptionHandler({NotEnoughBalanceException.class})
    public ResponseEntity<ErrorDto> handleFunctionalMessageException(NotEnoughBalanceException ex) {
        return  ResponseEntity.badRequest().body(ErrorDto.builder().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST.value()).build() );
    }


    // Default handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        return  ResponseEntity.internalServerError().body(ErrorDto.builder().message(ex.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build() );
    }
}
