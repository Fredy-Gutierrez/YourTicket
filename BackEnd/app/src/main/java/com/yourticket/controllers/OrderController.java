package com.yourticket.controllers;

import com.yourticket.dtos.request.OrderReqDTO;
import com.yourticket.dtos.response.OrderResDTO;
import com.yourticket.exceptions.FildValidationException;
import com.yourticket.services.IOrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
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
@RestController()
@RequestMapping(value="order")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    
    @GetMapping(value = "get", produces = {"application/json"})
    public ResponseEntity<OrderResDTO> getOrder(
            @RequestParam(name="orderId") @Min(value = 1, message = "El orderId debe ser mayor a 0") int orderId){
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }
    
    @GetMapping(value = "getall", produces = {"application/json"})
    public ResponseEntity<List<OrderResDTO>> getOrders(
            @RequestParam(name="userId") @Min(value = 1, message = "El userId debe ser mayor a 0") int userId){
        return new ResponseEntity<>(orderService.getOrders(userId), HttpStatus.OK);
    }
    
    @PostMapping(value = "create", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<OrderResDTO> createOrder(
            @Valid @RequestBody OrderReqDTO order) throws FildValidationException{
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.OK);
    }
    
    @PutMapping(value = "update", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<OrderResDTO> updateOrder(
            @RequestBody OrderReqDTO order) throws FildValidationException{
        return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.OK);
    }
    
    @PutMapping(value = "cancel", consumes={"application/json"}, produces = {"application/json"})
    public ResponseEntity<OrderResDTO> cancelOrder(
            @RequestBody OrderReqDTO order) throws FildValidationException{
        return new ResponseEntity<>(orderService.cancelOrder(order), HttpStatus.OK);
    }
}