package com.yourticket.services;

import com.yourticket.dtos.request.OrderReqDTO;
import com.yourticket.dtos.response.OrderResDTO;
import com.yourticket.exceptions.FildValidationException;
import java.util.List;

/**
 *
 * @author fredd
 */
public interface IOrderService {
    public OrderResDTO getOrder(int orderId);

    public List<OrderResDTO> getOrders(int userId);

    public OrderResDTO createOrder(OrderReqDTO order) throws FildValidationException;

    public OrderResDTO updateOrder(OrderReqDTO order) throws FildValidationException;

    public OrderResDTO updateOrderWithUserName(OrderReqDTO order) throws FildValidationException;

    public OrderResDTO cancelOrder(OrderReqDTO order) throws FildValidationException;
}
