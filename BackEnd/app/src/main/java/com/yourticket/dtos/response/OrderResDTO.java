package com.yourticket.dtos.response;

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
public class OrderResDTO {
    private int orderID;
    private String paymentMethod;
    private LocalDateTime orderDate;
    private int seatID;
    private int userID;
}
