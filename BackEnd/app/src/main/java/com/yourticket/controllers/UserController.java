package com.yourticket.controllers;

import com.yourticket.dtos.request.NewUserReqDTO;
import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.response.UserResDTO;
import com.yourticket.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping(value = "user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping(value = "get", produces = { "application/json" })
    public ResponseEntity<UserResDTO> getUser(@RequestParam(name = "userId") int userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }
    
    @PostMapping(value = "create", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<UserResDTO> createUser(@RequestBody NewUserReqDTO user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
    
    @PostMapping(value = "createseller", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<UserResDTO> createUserSeller(@RequestBody NewUserReqDTO user){
        return new ResponseEntity<>(userService.createUserSeller(user), HttpStatus.OK);
    }
    
    @PutMapping(value = "update", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<UserResDTO> updateUser(@RequestBody UserReqDTO user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }
}
