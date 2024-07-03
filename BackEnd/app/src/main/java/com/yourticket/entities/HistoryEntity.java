package com.yourticket.entities;

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
public class HistoryEntity {
    private int historyID;
    private String paymentMethod;
    private LocalDateTime eventDate;
    private String status;
    private int seatNumber;
    private String rowName;
    private String zoneName;
    private String eventName;
    private String location;
    private int userID;
}
