package com.yourticket.controllers;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.dtos.response.CustomerResDTO;
import com.yourticket.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    
    @GetMapping(value="get", produces = {"application/json"})
    public ResponseEntity<CustomerResDTO> getCustomer(@RequestParam(name="customerId") int customerId){
        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }
    
    @PutMapping(value = "update", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<CustomerResDTO> updateCustomer(@RequestBody CustomerReqDTO customer){
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }
}
