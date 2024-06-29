/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.repositories.imp;

import com.yourticket.dtos.request.ETicketReqDTO;
import com.yourticket.entities.ETicketEntity;
import com.yourticket.repositories.IETicketRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fredd
 */
@Repository
public class ETicketRepository implements IETicketRepository {

    @Override
    public ETicketEntity checkIn(ETicketReqDTO eticket) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ETicketEntity saveETicket(ETicketReqDTO eticket) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteETicket(int orderId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
