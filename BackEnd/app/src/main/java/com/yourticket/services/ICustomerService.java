package com.yourticket.services;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.dtos.response.CustomerResDTO;

/**
 *
 * @author fredd
 */
public interface ICustomerService {
    public CustomerResDTO getCustomer(int customerId);
    public CustomerResDTO getCustomerByUser(int userId);
    public CustomerResDTO createCustomer(CustomerReqDTO customer);
    public CustomerResDTO updateCustomer(CustomerReqDTO customer);
}
