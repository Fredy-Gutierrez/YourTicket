package com.yourticket.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class RowsReqDTO {
    private int rowID;
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 10, message = "El nombre debe contener al menos {min} letras y menos de {max}")
    private String rowName;
    private int zoneID;
}
