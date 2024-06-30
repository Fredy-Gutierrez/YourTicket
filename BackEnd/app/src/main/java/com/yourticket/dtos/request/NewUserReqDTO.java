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
public class NewUserReqDTO {
    private UserReqDTO user;
    private CustomerReqDTO customer;
    private SellerReqDTO seller;
}
