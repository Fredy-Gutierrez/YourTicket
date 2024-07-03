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
        // Pagado jaja
        return true;
    }

    @Override
    public boolean refundPayment(OrderReqDTO order) {
        // Devuelto XD
        return true;
    }

}
