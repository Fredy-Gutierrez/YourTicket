package com.yourticket.controllers;

import com.yourticket.dtos.request.OrderReqDTO;
import com.yourticket.dtos.response.OrderResDTO;
import com.yourticket.services.IOrderService;
import java.util.List;
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
@RestController()
@RequestMapping(value="order")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    
    @GetMapping(value = "get", produces = {"application/json"})
    public ResponseEntity<OrderResDTO> getOrder(@RequestParam(name="orderId") int orderId){
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }
    
    @GetMapping(value = "getall", produces = {"application/json"})
    public ResponseEntity<List<OrderResDTO>> getOrders(@RequestParam(name="userId") int userId){
        return new ResponseEntity<>(orderService.getOrders(userId), HttpStatus.OK);
    }
    
    @PostMapping(value = "create", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<OrderResDTO> createOrder(@RequestBody OrderReqDTO order){
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.OK);
    }
    
    @PutMapping(value = "update", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<OrderResDTO> updateOrder(@RequestBody OrderReqDTO order){
        return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.OK);
    }
    
    @PutMapping(value = "cancel", consumes={"application/json"}, produces = {"application/json"})
    public ResponseEntity<OrderResDTO> cancelOrder(@RequestBody OrderReqDTO order){
        return new ResponseEntity<>(orderService.cancelOrder(order), HttpStatus.OK);
    }
}