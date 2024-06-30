package com.yourticket.services;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.dtos.response.CustomerResDTO;

/**
 *
 * @author fredd
 */
public interface ICustomerService {
    public CustomerResDTO createCustomer(CustomerReqDTO customer);
    public CustomerResDTO getCustomer(int customerId);
    public CustomerResDTO updateCustomer(CustomerReqDTO customer);
}
