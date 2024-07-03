package com.yourticket.controllers;

import com.yourticket.dtos.request.SellerReqDTO;
import com.yourticket.dtos.response.SellerResDTO;
import com.yourticket.exceptions.FildValidationException;
import com.yourticket.services.ISellerService;
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
@RequestMapping(value="seller")
public class SellerController {
    @Autowired
    private ISellerService sellerService;
    
    @GetMapping(value="get", produces = {"application/json"})
    public ResponseEntity<SellerResDTO> getSeller(
            @RequestParam(name="sellerId") @Min(value = 1, message = "El sellerId debe ser mayor a 0") int sellerId){
        return new ResponseEntity<>(sellerService.getSeller(sellerId), HttpStatus.OK);
    }
    
    @GetMapping(value="getbyuserid", produces = {"application/json"})
    public ResponseEntity<SellerResDTO> getSellerByUserId(
            @RequestParam(name="userId") @Min(value = 1, message = "El userId debe ser mayor a 0") int userId){
        return new ResponseEntity<>(sellerService.getSellerByUser(userId), HttpStatus.OK);
    }
    
    @PutMapping(value = "update", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<SellerResDTO> updateSeller(
            @Valid @RequestBody SellerReqDTO seller) throws FildValidationException{
        return new ResponseEntity<>(sellerService.updateSeller(seller), HttpStatus.OK);
    }
}
