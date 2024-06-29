/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.controllers;

import com.yourticket.dtos.request.EventReqDTO;
import com.yourticket.dtos.request.RowsReqDTO;
import com.yourticket.dtos.request.SeatsReqDTO;
import com.yourticket.dtos.request.ZonesReqDTO;
import com.yourticket.dtos.response.EventResDTO;
import com.yourticket.dtos.response.RowsResDTO;
import com.yourticket.dtos.response.SeatsResDTO;
import com.yourticket.dtos.response.ZonesResDTO;
import com.yourticket.services.IEventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(value="event")
public class EventController {
    
    @Autowired
    private IEventService eventService;
    
    ///********************EVENT SECTION*********************///
    
    @GetMapping(value="get", produces = {"application/json"})
    public ResponseEntity<EventResDTO> getEvent(@RequestParam(name="eventId") int eventId){
        return new ResponseEntity<>(eventService.getEvent(eventId), HttpStatus.OK);
    }
    
    @GetMapping(value="getall", produces = {"application/json"})
    public ResponseEntity<List<EventResDTO>> getAllEvent(){
        return new ResponseEntity<>(eventService.getAllEvent(), HttpStatus.OK);
    }
    
    @GetMapping(value="getsellerevents", produces = {"application/json"})
    public ResponseEntity<List<EventResDTO>> getSellerEvents(@RequestParam(name="userId") int userId){
        return new ResponseEntity<>(eventService.getSellerEvents(userId), HttpStatus.OK);
    }
    
    @PostMapping(value="create", consumes={"application/json"}, produces={"application/json"})
    public ResponseEntity<EventResDTO> createEvent(@RequestBody EventReqDTO event){
        return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.OK);
    }
    
    @PutMapping(value="update", consumes = {"application/json"}, produces={"application/json"})
    public ResponseEntity<EventResDTO> updateEvent(@RequestBody EventReqDTO event){
        return new ResponseEntity<>(eventService.updateEvent(event), HttpStatus.OK);
    }
    
    @PutMapping(value="cancel", consumes = {"application/json"}, produces={"application/json"})
    public ResponseEntity<EventResDTO> cancelEvent(@RequestBody EventReqDTO event){
        return new ResponseEntity<>(eventService.cancelEvent(event), HttpStatus.OK);
    }
    
    ///********************ZONES SECTION*********************///
    @GetMapping(value="getzones", produces = {"application/json"})
    public ResponseEntity<List<ZonesResDTO>> getZones(@RequestParam(name="eventId") int eventId){
        return new ResponseEntity<>(eventService.getZones(eventId), HttpStatus.OK);
    }
    
    @PostMapping(value="addzones", consumes={"application/json"}, produces={"application/json"})
    public ResponseEntity<List<ZonesResDTO>> addZones(@RequestParam(name="eventId") int eventId, @RequestBody List<ZonesReqDTO> zones){
        return new ResponseEntity<>(eventService.addZones(eventId, zones), HttpStatus.OK);
    }
    
    @DeleteMapping(value="deletezone", produces = {"application/json"})
    public ResponseEntity<List<ZonesResDTO>> deleteZone(@RequestParam(name="eventId") int eventId, @RequestParam(name="zoneId") int zoneId){
        return new ResponseEntity<>(eventService.deleteZone(eventId, zoneId), HttpStatus.OK);
    }
    
    
    ///********************ROWS SECTION*********************///
    
    @GetMapping(value="getrows", produces = {"application/json"})
    public ResponseEntity<List<RowsResDTO>> getRows(@RequestParam(name="zoneId") int zoneId){
        return new ResponseEntity<>(eventService.getRows(zoneId), HttpStatus.OK);
    }
    
    @PostMapping(value="addrows", consumes={"application/json"}, produces={"application/json"})
    public ResponseEntity<List<RowsResDTO>> addRows(@RequestParam(name="zoneId") int zoneId, @RequestBody List<RowsReqDTO> rows){
        return new ResponseEntity<>(eventService.addRows(zoneId, rows), HttpStatus.OK);
    }
    
    @PostMapping(value="deleterows", produces = {"application/json"})
    public ResponseEntity<List<RowsResDTO>> deleterows(@RequestParam(name="zoneId") int zoneId, @RequestBody List<RowsReqDTO> rows){
        return new ResponseEntity<>(eventService.deleterows(zoneId, rows), HttpStatus.OK);
    }
    
    
    ///********************SEATS SECTION*********************///
    
    @GetMapping(value="getseats", produces = {"application/json"})
    public ResponseEntity<List<SeatsResDTO>> getSeats(@RequestParam(name="rowId") int rowId){
        return new ResponseEntity<>(eventService.getSeats(rowId), HttpStatus.OK);
    }
    
    @PostMapping(value="addseats", consumes={"application/json"}, produces={"application/json"})
    public ResponseEntity<List<SeatsResDTO>> addSeats(@RequestParam(name="rowId") int rowId, @RequestBody List<SeatsReqDTO> seats){
        return new ResponseEntity<>(eventService.addSeats(rowId, seats), HttpStatus.OK);
    }
    
    @PostMapping(value="deleteseats", produces = {"application/json"})
    public ResponseEntity<List<SeatsResDTO>> deleteSeats(@RequestParam(name="rowId") int rowId, @RequestBody List<SeatsReqDTO> seats){
        return new ResponseEntity<>(eventService.deleteSeats(rowId, seats), HttpStatus.OK);
    }
    
}
