package com.yetgim.spring_intro.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException exception){
        return exception.getMessage();
    }
}
