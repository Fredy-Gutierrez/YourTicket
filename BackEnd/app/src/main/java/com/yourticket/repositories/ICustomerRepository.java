package com.yourticket.repositories;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.entities.CustomerEntity;

/**
 *
 * @author fredd
 */
public interface ICustomerRepository {
    public int createCustomer(CustomerReqDTO customer);
    public CustomerEntity getCustomer(int customerId);
    public boolean updateCustomer(CustomerReqDTO customer);
}
