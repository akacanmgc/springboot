package com.akacan.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public void globalException(MethodArgumentNotValidException ex)
    {
        Map<String, List<String>> map = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fildName = error.getDefaultMessage();
        });
    }

}
