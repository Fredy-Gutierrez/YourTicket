package com.yourticket.dtos.request;

import java.time.LocalDateTime;
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
    private String paymentMethod;
    private LocalDateTime orderDate;
    private String status;
    private int seatID;
    private int userID;
}
