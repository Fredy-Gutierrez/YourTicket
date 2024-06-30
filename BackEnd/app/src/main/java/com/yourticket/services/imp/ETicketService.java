package com.yourticket.services.imp;

import com.yourticket.dtos.request.ETicketReqDTO;
import com.yourticket.dtos.response.ETicketResDTO;
import com.yourticket.entities.CheckInEntity;
import com.yourticket.entities.ETicketEntity;
import com.yourticket.repositories.IETicketRepository;
import com.yourticket.services.IETicketService;

import java.util.UUID;

import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper mapperDTO;

    @Override
    public ETicketResDTO generateETicket(int orderId, int userId) {
        if (eTicketRepository.getCheckIn(orderId) != null)
            return null;// error there is a checkin whit orderid

        UUID uuid = UUID.randomUUID();

        ETicketReqDTO eticket = new ETicketReqDTO();
        eticket.setOrderId(orderId);
        eticket.setETicket(uuid.toString());

        ETicketEntity newEticket;
        ETicketEntity prevEticket = eTicketRepository.getETicket(orderId);
        if (prevEticket == null)
            newEticket = eTicketRepository.saveETicket(eticket);
        else
            newEticket = eTicketRepository.updateETicket(orderId, eticket);

        if (newEticket == null)
            return null;

        return mapperDTO.map(newEticket, ETicketResDTO.class);
    }

    @Override
    public ETicketResDTO checkIn(ETicketReqDTO eticket) {
        ETicketEntity prevEticket = eTicketRepository.getETicket(eticket.getETicket());
        if (prevEticket == null)
            return null;// error no't valid eticket

        CheckInEntity prevCheckIn = eTicketRepository.getCheckIn(prevEticket.getOrderId());
        if (prevCheckIn != null)
            return null;// error accesing again

        eticket.setOrderId(prevEticket.getOrderId());
        ETicketEntity entity = eTicketRepository.checkIn(eticket);
        if (entity == null)
            return null;// error saving

        return mapperDTO.map(entity, ETicketResDTO.class);
    }

}
