package com.yourticket.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class EventResDTO {
    private int eventID;
    private String eventName;
    private String information;
    private String localization;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime eventDay;
    private String status;
    private int userID;
}
