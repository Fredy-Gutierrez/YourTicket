package com.yourticket.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatInformationEntity {
    private int eventID;
    private String eventName;
    private String information;
    private String localization;
    private LocalDateTime eventDay;
    private String status;
    private int userID;
    private int zoneID;
    private String zoneName;
    private BigDecimal ticketPrice;
    private int rowID;
    private String rowName;
    private int seatID;
    private int seatNumber;
    private boolean available;
}
