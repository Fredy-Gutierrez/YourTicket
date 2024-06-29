/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.repositories.imp;

import com.yourticket.dtos.request.OrderReqDTO;
import com.yourticket.repositories.IPaymentRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fredd
 */
@Repository
public class PaymentRepository implements IPaymentRepository {

    @Override
    public boolean makePayment(OrderReqDTO order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean refundPayment(OrderReqDTO order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
