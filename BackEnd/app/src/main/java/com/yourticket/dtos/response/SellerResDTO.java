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
public class SellerResDTO {
    private int sellerID;
    private String name;
    private String information;
    private String rfc;
    private String country;
    private String address;
    private String email;
    private String phone;
}
