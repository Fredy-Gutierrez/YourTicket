package com.yourticket.dtos.request;

import jakarta.validation.constraints.Min;
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
public class SeatsReqDTO {
    private int seatID;
    
    @Min(value = 1, message = "El numero de asiento debe ser mayor a 0")
    private int seatNumber;
    private boolean available;
    private int rowID;
}
