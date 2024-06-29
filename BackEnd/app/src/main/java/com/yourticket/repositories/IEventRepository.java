/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yourticket.repositories;

import com.yourticket.dtos.request.EventReqDTO;
import com.yourticket.dtos.request.RowsReqDTO;
import com.yourticket.dtos.request.SeatsReqDTO;
import com.yourticket.dtos.request.ZonesReqDTO;
import com.yourticket.entities.EventEntity;
import com.yourticket.entities.RowsEntity;
import com.yourticket.entities.SeatsEntity;
import com.yourticket.entities.ZonesEntity;
import java.util.List;

/**
 *
 * @author fredd
 */
public interface IEventRepository {
    ///********************EVENT SECTION*********************///
    public EventEntity getEvent(int eventId);
    public List<EventEntity> getAllEvent();
    public List<EventEntity> getSellerEvents(int userId);
    public int createEvent(EventReqDTO event);
    public boolean updateEvent(EventReqDTO event);
    public boolean cancelEvent(EventReqDTO event);
    
    ///********************ZONES SECTION*********************///
    public List<ZonesEntity> getZones(int eventId);
    public boolean addZones(int eventId, List<ZonesReqDTO> zones);
    public boolean deleteZone(int zoneId);
    
    ///********************ROWS SECTION*********************///
    public List<RowsEntity> getRows(int zoneId);
    public boolean addRows(int zoneId, List<RowsReqDTO> rows);
    public boolean deleteRows(List<RowsReqDTO> rows);
    
    ///********************SEATS SECTION*********************//
    public SeatsEntity getSeat(int seatId);
    public List<SeatsEntity> getSeats(int rowId);
    public boolean addSeats(int rowId, List<SeatsReqDTO> seats);
    public boolean updateSeatAvalaible(int rowId, SeatsReqDTO seat);
    public boolean deleteSeats(int rowId, List<SeatsReqDTO> seats);
}
