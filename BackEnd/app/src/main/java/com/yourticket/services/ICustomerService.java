package com.yourticket.services;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.dtos.response.CustomerResDTO;
import com.yourticket.exceptions.FildValidationException;

/**
 *
 * @author fredd
 */
public interface ICustomerService {
    public CustomerResDTO getCustomer(int customerId);
    public CustomerResDTO getCustomerByUser(int userId);
    public CustomerResDTO createCustomer(CustomerReqDTO customer) throws FildValidationException;
    public CustomerResDTO updateCustomer(CustomerReqDTO customer) throws FildValidationException;
}
