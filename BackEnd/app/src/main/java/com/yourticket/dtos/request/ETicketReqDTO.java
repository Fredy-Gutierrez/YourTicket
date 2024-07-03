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
public class ETicketReqDTO {
    @NotBlank(message = "El eticket es requerido")
    @Size(min = 2, message = "El eticket debe contener al menos {min} letras")
    private String eTicket;
    private int orderId;
}
