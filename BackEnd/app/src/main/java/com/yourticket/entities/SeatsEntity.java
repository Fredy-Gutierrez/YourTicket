package com.yourticket.entities;

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
public class SeatsEntity {
    private int seatID;
    private int seatNumber;
    private boolean available;
    private int rowID;
}
