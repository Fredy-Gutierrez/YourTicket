package com.yourticket.dtos.request;

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
public class SeatsReqDTO {
    private int seatID;
    private int seatNumber;
    private boolean available;
    private int rowID;
}
