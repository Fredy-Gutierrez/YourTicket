package com.yourticket.dtos.request;

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
public class SellerReqDTO {
    private int sellerID;
    private String name;
    private String information;
    private String rfc;
    private String country;
    private String address;
    private String email;
    private String phone;
    private int userID;
}
