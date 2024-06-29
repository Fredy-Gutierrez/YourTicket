package com.yourticket.dtos.response;

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
public class SeatsResDTO {
    private int seatID;
    private int seatNumber;
    private boolean available;
    private int rowID;
}
