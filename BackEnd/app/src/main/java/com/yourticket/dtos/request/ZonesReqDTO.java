package com.yourticket.dtos.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
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
public class ZonesReqDTO {
    private int zoneID;
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 20, message = "El nombre debe contener al menos {min} letras y menos de {max}")
    private String zoneName;
    
    @Positive(message = "El precio debe ser mayor a 1.00")
    @DecimalMin(value = "1.00", message = "El precio debe ser meyor que 1.00")
    @DecimalMax(value = "999999.99", message = "El precio debe ser menor que {value}")
    private BigDecimal ticketPrice;
    
    private int eventID;
}
