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
