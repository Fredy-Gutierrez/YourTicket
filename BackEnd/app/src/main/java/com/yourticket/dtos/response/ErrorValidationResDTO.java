package com.yourticket.dtos.response;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fredd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorValidationResDTO {
    int statusCode;
    String errorMessage;
    Map<String, String> errors;
}
