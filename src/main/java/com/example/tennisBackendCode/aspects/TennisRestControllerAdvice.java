package com.example.tennisBackendCode.aspects;

import java.util.Arrays;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TennisRestControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public String printException(RuntimeException e) {
        return e.getMessage()+"{ENDMESSAGE}"+Arrays.toString(e.getStackTrace());
    }
}
