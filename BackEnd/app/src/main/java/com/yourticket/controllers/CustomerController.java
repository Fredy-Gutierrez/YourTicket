package com.yourticket.controllers;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.dtos.response.CustomerResDTO;
import com.yourticket.exceptions.FildValidationException;
import com.yourticket.services.ICustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredd
 */
@Validated
@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    
    @GetMapping(value="get", produces = {"application/json"})
    public ResponseEntity<CustomerResDTO> getCustomer(
            @RequestParam(name="customerId") @Min(value = 1, message = "El customerId debe ser mayor a 0") int customerId) {
        
        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }
    
    @GetMapping(value="getbyuserid", produces = {"application/json"})
    public ResponseEntity<CustomerResDTO> getCustomerByUserId(
            @RequestParam(name="userId") @Min(value = 1, message = "El userId debe ser mayor a 0") int userId) {
        return new ResponseEntity<>(customerService.getCustomerByUser(userId), HttpStatus.OK);
    }
    
    @PutMapping(value = "update", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<CustomerResDTO> updateCustomer(
            @Valid @RequestBody CustomerReqDTO customer) throws FildValidationException {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }
}
