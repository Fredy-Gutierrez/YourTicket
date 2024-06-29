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
public class RowsResDTO {
    private int rowID;
    private String rowName;
    private int zoneID;
}
