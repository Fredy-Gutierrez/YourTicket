package com.yourticket.controllers;

import com.yourticket.dtos.request.ETicketReqDTO;
import com.yourticket.dtos.response.ETicketResDTO;
import com.yourticket.services.IETicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredd
 */
@RestController
@RequestMapping(value="eticket")
public class ETicketController {
    
    @Autowired
    private IETicketService eTicketService;
    
    @GetMapping(value="generate", produces= {"application/json"})
    public ResponseEntity<ETicketResDTO> generateETicket(@RequestParam(name="orderId") int orderId, @RequestParam(name="userId") int userId){
        return new ResponseEntity<>(eTicketService.generateETicket(orderId, userId), HttpStatus.OK);
    }
    
    @PostMapping(value="checkin", consumes={"application/json"}, produces = {"application/json"})
    public ResponseEntity<ETicketResDTO> checkIn(@RequestBody ETicketReqDTO eticket){
        return new ResponseEntity<>(eTicketService.checkIn(eticket), HttpStatus.OK);
    }
}
