/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.controllers;

import com.yourticket.dtos.request.SellerReqDTO;
import com.yourticket.dtos.response.SellerResDTO;
import com.yourticket.services.ISellerService;
import jakarta.validation.Valid;
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
@RequestMapping(value="seller")
public class SellerController {
    @Autowired
    private ISellerService sellerService;
    
    @GetMapping(value="get", produces = {"application/json"})
    public ResponseEntity<SellerResDTO> getSeller(@RequestParam(name="sellerId") int sellerId){
        return new ResponseEntity<>(sellerService.getSeller(sellerId), HttpStatus.OK);
    }
    
    @GetMapping(value="getbyuserid", produces = {"application/json"})
    public ResponseEntity<SellerResDTO> getSellerByUserId(@RequestParam(name="userId") int userId){
        return new ResponseEntity<>(sellerService.getSellerByUser(userId), HttpStatus.OK);
    }
    
    @PutMapping(value = "update", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<SellerResDTO> updateSeller(@Valid @RequestBody SellerReqDTO seller){
        return new ResponseEntity<>(sellerService.updateSeller(seller), HttpStatus.OK);
    }
}
