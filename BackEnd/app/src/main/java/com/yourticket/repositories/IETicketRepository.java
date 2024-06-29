/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yourticket.repositories;

import com.yourticket.dtos.request.ETicketReqDTO;
import com.yourticket.entities.ETicketEntity;

/**
 *
 * @author fredd
 */
public interface IETicketRepository {
    public ETicketEntity saveETicket(ETicketReqDTO eticket);
    public boolean deleteETicket(int orderId, int userId);
    public ETicketEntity checkIn(ETicketReqDTO eticket);
}
