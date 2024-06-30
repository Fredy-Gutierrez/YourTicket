/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.services.imp;

import com.yourticket.dtos.request.EventReqDTO;
import com.yourticket.dtos.request.RowsReqDTO;
import com.yourticket.dtos.request.SeatsReqDTO;
import com.yourticket.dtos.request.ZonesReqDTO;
import com.yourticket.dtos.response.EventResDTO;
import com.yourticket.dtos.response.RowsResDTO;
import com.yourticket.dtos.response.SeatInformationDTO;
import com.yourticket.dtos.response.SeatsResDTO;
import com.yourticket.dtos.response.ZonesResDTO;
import com.yourticket.entities.EventEntity;
import com.yourticket.entities.RowsEntity;
import com.yourticket.entities.SeatInformationEntity;
import com.yourticket.entities.SeatsEntity;
import com.yourticket.entities.ZonesEntity;
import com.yourticket.mappers.ListMapper;
import com.yourticket.repositories.IEventRepository;
import com.yourticket.services.IEventService;
import com.yourticket.utils.EventStatus;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredd
 */
@Service
public class EventService implements IEventService {

    @Autowired
    private IEventRepository eventRepository;

    @Autowired
    private ModelMapper mapperDTO;

    @Autowired
    private ListMapper listMapper;

    /// ********************EVENT SECTION*********************///
    @Override
    public EventResDTO getEvent(int eventId) {
        EventEntity entity = eventRepository.getEvent(eventId);
        if (entity == null)
            return null;
        return mapperDTO.map(entity, EventResDTO.class);
    }

    @Override
    public List<EventResDTO> getAllEvent() {
        List<EventEntity> entity = eventRepository.getAllEvent();
        if (entity == null)
            return null;
        return listMapper.mapList(entity, EventResDTO.class);
    }

    @Override
    public List<EventResDTO> getSellerEvents(int userId) {
        List<EventEntity> entity = eventRepository.getSellerEvents(userId);
        if (entity == null)
            return null;
        return listMapper.mapList(entity, EventResDTO.class);
    }

    @Override
    public EventResDTO createEvent(EventReqDTO event) {
        event.setStatus(EventStatus.DISPONIBLE.toString());

        int eventId = eventRepository.createEvent(event);
        if (eventId > 0)
            return getEvent(eventId);
        return null;
    }

    @Override
    public EventResDTO updateEvent(EventReqDTO event) {
        if (eventRepository.updateEvent(event))
            return mapperDTO.map(event, EventResDTO.class);
        return null;
    }

    @Override
    public EventResDTO cancelEvent(EventReqDTO event) {
        event.setStatus(EventStatus.CANCELADO.toString());

        if (eventRepository.cancelEvent(event))
            return new EventResDTO();
        return null;
    }

    /// ********************ZONES SECTION*********************///
    @Override
    public List<ZonesResDTO> getZones(int eventId) {
        List<ZonesEntity> entity = eventRepository.getZones(eventId);
        if (entity == null)
            return null;
        return listMapper.mapList(entity, ZonesResDTO.class);
    }

    @Override
    public List<ZonesResDTO> addZones(int eventId, List<ZonesReqDTO> zones) {
        if (eventRepository.addZones(eventId, zones))
            return getZones(eventId);
        return null;
    }

    @Override
    public List<ZonesResDTO> deleteZone(int eventId, int zoneId) {
        if (eventRepository.deleteZone(zoneId))
            return getZones(eventId);
        return null;
    }

    /// ********************ROWS SECTION*********************///
    @Override
    public List<RowsResDTO> getRows(int zoneId) {
        List<RowsEntity> entity = eventRepository.getRows(zoneId);
        if (entity == null)
            return null;
        return listMapper.mapList(entity, RowsResDTO.class);
    }

    @Override
    public List<RowsResDTO> addRows(int zoneId, List<RowsReqDTO> rows) {
        if (eventRepository.addRows(zoneId, rows))
            return getRows(zoneId);
        return null;
    }

    @Override
    public List<RowsResDTO> deleterows(int zoneId, List<RowsReqDTO> rows) {
        if (eventRepository.deleteRows(rows))
            return getRows(zoneId);
        return null;
    }

    /// ********************SEATS SECTION*********************///
    @Override
    public SeatsResDTO getSeat(int seatId) {
        SeatsEntity entity = eventRepository.getSeat(seatId);
        if (entity == null)
            return null;
        return mapperDTO.map(entity, SeatsResDTO.class);
    }

    @Override
    public List<SeatsResDTO> getSeats(int rowId) {
        List<SeatsEntity> entity = eventRepository.getSeats(rowId);
        if (entity == null)
            return null;
        return listMapper.mapList(entity, SeatsResDTO.class);
    }

    @Override
    public SeatInformationDTO getAllSeatInformation(int seatId) {
        SeatInformationEntity entity = eventRepository.getAllSeatInformation(seatId);
        if (entity == null)
            return null;
        return mapperDTO.map(entity, SeatInformationDTO.class);

    }

    @Override
    public List<SeatsResDTO> addSeats(int rowId, List<SeatsReqDTO> seats) {
        if (eventRepository.addSeats(rowId, seats))
            return getSeats(rowId);
        return null;
    }

    @Override
    public SeatsResDTO updateSeatAvalaible(int rowId, SeatsReqDTO seat) {
        if (eventRepository.updateSeatAvalaible(rowId, seat))
            return mapperDTO.map(seat, SeatsResDTO.class);
        return null;
    }

    @Override
    public List<SeatsResDTO> deleteSeats(int rowId, List<SeatsReqDTO> seats) {
        if (eventRepository.deleteSeats(rowId, seats))
            return getSeats(rowId);
        return null;
    }

}
