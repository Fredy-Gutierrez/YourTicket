package com.yourticket.entities;

import java.time.LocalDateTime;
import java.util.Date;
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
public class OrderEntity {
    private int orderID;
    private String paymentMethod;
    private LocalDateTime orderDate;
    private String status;
    private int seatID;
    private int userID;
}
