package com.yourticket.controllers;

import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.response.UserSessionResDTO;
import com.yourticket.services.IUserSessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredd
 */
@Validated
@RestController
@RequestMapping(value = "usersession")
public class UserSessionController {
    @Autowired
    private IUserSessionService userSessionService;
    
    @PostMapping(value = "login", consumes=  {"application/json"}, produces = {"application/json"})
    public ResponseEntity<UserSessionResDTO> logIn(@Valid @RequestBody UserReqDTO user){
        return new ResponseEntity<>(userSessionService.logIn(user), HttpStatus.OK);
    }
}
