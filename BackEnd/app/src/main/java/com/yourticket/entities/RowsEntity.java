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
public class RowsEntity {
    private int rowID;
    private String rowName;
    private int zoneID;
}
