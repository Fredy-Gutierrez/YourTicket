/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yourticket.repositories;

import com.yourticket.dtos.request.OrderReqDTO;

/**
 *
 * @author fredd
 */
public interface IPaymentRepository {
    public boolean makePayment(OrderReqDTO order);
    public boolean refundPayment(OrderReqDTO order);
}
