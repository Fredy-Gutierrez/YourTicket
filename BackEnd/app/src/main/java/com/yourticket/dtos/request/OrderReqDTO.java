package com.yourticket.dtos.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
public class OrderReqDTO {
    private int orderID;

    @NotBlank(message = "El metodo de pago es requerido")
    @Size(min = 2, max = 40, message = "El metodo de pago debe contener al menos {min} letras y menos de {max}")
    private String paymentMethod;

    private String userName;

    private LocalDateTime orderDate;

    private String status;

    @Positive
    @Min(value = 1, message = "El id del asiento debe ser mayor a 0")
    private int seatID;

    @Positive
    @Min(value = 1, message = "El id del usuario debe ser mayor a 0")
    private int userID;
}
