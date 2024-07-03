package com.yourticket.exceptions;

import lombok.Getter;

/**
 *
 * @author fredd
 */
public class FildValidationException extends Exception {
    
    @Getter
    private String fildName;

    public FildValidationException(String fildName, String message) {
        super(message);
        this.fildName = fildName;
    }
}
