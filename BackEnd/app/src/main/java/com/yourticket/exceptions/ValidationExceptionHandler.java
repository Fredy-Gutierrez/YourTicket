package com.yourticket.exceptions;

import com.yourticket.dtos.response.ErrorValidationResDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.hibernate.validator.internal.engine.path.PathImpl;
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
    public ResponseEntity<Object> handlerValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = "Error de validacion";
        int errorStatus = HttpStatus.BAD_REQUEST.value();
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String messageError = error.getDefaultMessage();

            errors.put(field, messageError);
        });

        return new ResponseEntity<>(new ErrorValidationResDTO(errorStatus, errorMessage, errors),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorValidationResDTO> handleList(ConstraintViolationException constraintViolationException) {
        String errorMessage = "Error de validacion";
        int errorStatus = HttpStatus.BAD_REQUEST.value();
        Map<String, String> errors = new HashMap<>();

        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        if (violations.isEmpty())
            errors.put("Error Data", errorMessage);
        else {
            violations.forEach(violation -> {
                errors.put(((PathImpl) violation.getPropertyPath()).getLeafNode().getName(), violation.getMessage());
            });
        }

        return new ResponseEntity<>(new ErrorValidationResDTO(errorStatus, errorMessage, errors),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FildValidationException.class)
    public ResponseEntity<ErrorValidationResDTO> handleList(FildValidationException fildException) {
        String errorMessage = "Error de validacion";
        int errorStatus = HttpStatus.BAD_REQUEST.value();
        Map<String, String> errors = new HashMap<>();

        errors.put(fildException.getFildName(), fildException.getMessage());

        return new ResponseEntity<>(new ErrorValidationResDTO(errorStatus, errorMessage, errors),
                HttpStatus.BAD_REQUEST);
    }

}
