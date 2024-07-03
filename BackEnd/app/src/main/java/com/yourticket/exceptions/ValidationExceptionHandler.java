/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.exceptions;

import com.yourticket.dtos.response.ErrorValidationResDTO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author fredd
 */
@ControllerAdvice
public class ValidationExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerValidationException(MethodArgumentNotValidException ex){
        
        String errorMessage = "Error de validacion";
        int errorStatus = HttpStatus.BAD_REQUEST.value();
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String messageError = error.getDefaultMessage();
            
            errors.put(field, messageError);
        });
        
        return new ResponseEntity<>(new ErrorValidationResDTO(errorStatus, errorMessage, errors), HttpStatus.BAD_REQUEST);
    }
    
}
