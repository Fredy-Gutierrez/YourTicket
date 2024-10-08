package com.yourticket.repositories;

import com.yourticket.dtos.request.ETicketReqDTO;
import com.yourticket.entities.CheckInEntity;
import com.yourticket.entities.ETicketEntity;

/**
 *
 * @author fredd
 */
public interface IETicketRepository {
    public ETicketEntity getETicket(int orderId);

    public ETicketEntity getETicket(String eticket);

    public CheckInEntity getCheckIn(int orderId);

    public ETicketEntity saveETicket(ETicketReqDTO eticket);

    public ETicketEntity updateETicket(int orderId, ETicketReqDTO eticket);

    public ETicketEntity checkIn(ETicketReqDTO eticket);
}
