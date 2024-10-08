package com.yourticket.services;

import com.yourticket.dtos.request.EventReqDTO;
import com.yourticket.dtos.request.RowsReqDTO;
import com.yourticket.dtos.request.SeatsReqDTO;
import com.yourticket.dtos.request.ZonesReqDTO;
import com.yourticket.dtos.response.EventResDTO;
import com.yourticket.dtos.response.RowsResDTO;
import com.yourticket.dtos.response.SeatInformationDTO;
import com.yourticket.dtos.response.SeatsResDTO;
import com.yourticket.dtos.response.ZonesResDTO;
import com.yourticket.exceptions.FildValidationException;

import java.util.List;

/**
 *
 * @author fredd
 */
public interface IEventService {
    /// ********************EVENT SECTION*********************///
    public EventResDTO getEvent(int eventId);

    public List<EventResDTO> getAllEvent();

    public List<EventResDTO> getSellerEvents(int userId);

    public EventResDTO createEvent(EventReqDTO event)throws FildValidationException;

    public EventResDTO updateEvent(EventReqDTO event)throws FildValidationException;

    public EventResDTO cancelEvent(EventReqDTO event) throws FildValidationException;

    /// ********************ZONES SECTION*********************///
    public List<ZonesResDTO> getZones(int eventId);

    public List<ZonesResDTO> addZones(int eventId, List<ZonesReqDTO> zones);

    public List<ZonesResDTO> deleteZone(int eventId, int zoneId);

    /// ********************ROWS SECTION*********************///
    public List<RowsResDTO> getRows(int zoneId);

    public List<RowsResDTO> addRows(int zoneId, List<RowsReqDTO> rows);

    public List<RowsResDTO> deleterows(int zoneId, List<RowsReqDTO> rows) throws FildValidationException;

    /// ********************SEATS SECTION*********************///
    public SeatsResDTO getSeat(int seatId);

    public List<SeatsResDTO> getSeats(int rowId);

    public SeatInformationDTO getAllSeatInformation(int seatId);

    public List<SeatsResDTO> addSeats(int rowId, List<SeatsReqDTO> seats);

    public SeatsResDTO updateSeatAvalaible(int rowId, SeatsReqDTO seat) throws FildValidationException;

    public List<SeatsResDTO> deleteSeats(int rowId, List<SeatsReqDTO> seats) throws FildValidationException;
}
