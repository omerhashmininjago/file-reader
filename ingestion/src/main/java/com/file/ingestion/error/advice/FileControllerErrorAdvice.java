package com.file.ingestion.error.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FileControllerErrorAdvice {

    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(){

    }
}
