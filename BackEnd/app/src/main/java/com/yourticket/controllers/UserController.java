package com.yourticket.controllers;

import com.yourticket.dtos.request.UserCustomerReqDTO;
import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.request.UserSellerReqDTO;
import com.yourticket.dtos.response.UserResDTO;
import com.yourticket.exceptions.FildValidationException;
import com.yourticket.services.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping(value = "user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping(value = "get", produces = { "application/json" })
    public ResponseEntity<UserResDTO> getUser(
            @RequestParam(name = "userId") @Min(value = 1, message = "El userId debe ser mayor a 0")int userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }
    
    @PostMapping(value = "create", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<UserResDTO> createUser (
            @Valid @RequestBody UserCustomerReqDTO user) throws FildValidationException {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
    
    @PostMapping(value = "createseller", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<UserResDTO> createUserSeller(
            @Valid @RequestBody UserSellerReqDTO seller) throws FildValidationException{
        return new ResponseEntity<>(userService.createUserSeller(seller), HttpStatus.OK);
    }
    
    @PutMapping(value = "update", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<UserResDTO> updateUser(
            @Valid @RequestBody UserReqDTO user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }
}
