package com.yourticket.services;

import com.yourticket.dtos.request.ETicketReqDTO;
import com.yourticket.dtos.response.ETicketResDTO;

/**
 *
 * @author fredd
 */
public interface IETicketService {
    public ETicketResDTO generateETicket(int orderId, int userId);
    public ETicketResDTO checkIn(ETicketReqDTO eticket);
}
