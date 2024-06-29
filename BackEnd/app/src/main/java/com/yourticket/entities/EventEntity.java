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
public class EventEntity {
    private int eventID;
    private String eventName;
    private String information;
    private String localization;
    private LocalDateTime eventDay;
    private String status;
    private int userID;
}
