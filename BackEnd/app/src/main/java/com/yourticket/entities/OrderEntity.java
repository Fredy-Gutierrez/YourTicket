package com.yourticket.entities;

import java.math.BigDecimal;
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
public class OrderEntity {
    private int orderID;
    private String paymentMethod;
    private LocalDateTime orderDate;
    private String status;
    private int seatID;
    private int userID;

    private String eventName;
    private String information;
    private String localization;
    private LocalDateTime eventDay;
    private String zoneName;
    private BigDecimal ticketPrice;
    private String rowName;
    private int seatNumber;
}
