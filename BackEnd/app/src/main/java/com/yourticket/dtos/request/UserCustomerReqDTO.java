package com.yourticket.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
public class UserCustomerReqDTO {
    
    @NotNull
    @Valid
    private UserReqDTO user;
    
    @NotNull
    @Valid
    private CustomerReqDTO customer;
}
