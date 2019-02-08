package com.file.ingestion.error.advice;

import com.file.ingestion.error.exception.TransactionTypeInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class FileControllerErrorAdvice {

    @ExceptionHandler(value = {ClassNotFoundException.class, IOException.class})
    public ResponseEntity exceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = TransactionTypeInvalidException.class)
    public ResponseEntity exceptionHandler(TransactionTypeInvalidException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
