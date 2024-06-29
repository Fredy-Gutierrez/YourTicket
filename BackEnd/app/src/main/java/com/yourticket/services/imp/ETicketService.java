package com.yourticket.services.imp;

import com.yourticket.dtos.request.ETicketReqDTO;
import com.yourticket.dtos.response.ETicketResDTO;
import com.yourticket.repositories.IETicketRepository;
import com.yourticket.services.IETicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredd
 */
@Service
public class ETicketService implements IETicketService {

    @Autowired
    private IETicketRepository eTicketRepository;
    
    @Override
    public ETicketResDTO generateETicket(int orderId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ETicketResDTO checkIn(ETicketReqDTO eticket) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
