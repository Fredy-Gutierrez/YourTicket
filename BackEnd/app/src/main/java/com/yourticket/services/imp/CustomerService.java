package com.yourticket.services.imp;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.dtos.response.CustomerResDTO;
import com.yourticket.entities.CustomerEntity;
import com.yourticket.exceptions.FildValidationException;
import com.yourticket.repositories.ICustomerRepository;
import com.yourticket.services.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredd
 */
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    
    @Autowired
    private ModelMapper mapperDTO;

    @Override
    public CustomerResDTO getCustomer(int customerId) {
        CustomerEntity entity = customerRepository.getCustomer(customerId);
        if(entity == null)
            return null;
        return mapperDTO.map(entity, CustomerResDTO.class);
    }
    
    @Override
    public CustomerResDTO getCustomerByUser(int userId) {
        CustomerEntity entity = customerRepository.getCustomerByUser(userId);
        if(entity == null)
            return null;
        return mapperDTO.map(entity, CustomerResDTO.class);
    }

    @Override
    public CustomerResDTO createCustomer(CustomerReqDTO customer) throws FildValidationException {
        if(customer.getUserID() <= 0)
            throw new FildValidationException("userID", "El userID debe ser mayor a 0");
        
        int customerId = customerRepository.createCustomer(customer);
        if(customerId > 0)
            return getCustomer(customerId);
        return null;
    }

    @Override
    public CustomerResDTO updateCustomer(CustomerReqDTO customer) throws FildValidationException{
        if(customer.getCustomerID() <= 0)
            throw new FildValidationException("customerID", "El customerID debe ser mayor a 0");
        
        if(customerRepository.updateCustomer(customer))
            return mapperDTO.map(customer, CustomerResDTO.class);
        return null;
    }
    
}
