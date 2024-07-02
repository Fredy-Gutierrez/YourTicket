package com.yourticket.repositories;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.entities.CustomerEntity;

/**
 *
 * @author fredd
 */
public interface ICustomerRepository {
    public CustomerEntity getCustomer(int customerId);
    public CustomerEntity getCustomerByUser(int userId);
    public int createCustomer(CustomerReqDTO customer);
    public boolean updateCustomer(CustomerReqDTO customer);
}
