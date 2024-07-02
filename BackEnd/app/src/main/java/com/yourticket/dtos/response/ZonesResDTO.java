package com.yourticket.dtos.response;

import java.math.BigDecimal;
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
public class ZonesResDTO {
    private int zoneID;
    private String zoneName;
    private BigDecimal ticketPrice;
    private int eventID;
}
