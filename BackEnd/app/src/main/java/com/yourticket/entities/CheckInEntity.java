package com.yourticket.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckInEntity {
    int ckeckID;
    LocalDateTime checkDate;
    String teticket;
    int orderID;
}
