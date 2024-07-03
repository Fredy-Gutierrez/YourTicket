package com.yourticket.repositories;

import com.yourticket.dtos.request.OrderReqDTO;
import com.yourticket.entities.OrderEntity;
import java.util.List;

/**
 *
 * @author fredd
 */
public interface IOrderRepository {
    public OrderEntity getOrder(int orderId);
    public List<OrderEntity> getOrders(int userId);
    public int createOrder(OrderReqDTO order);
    public boolean updateOrder(OrderReqDTO order);
    public boolean cancelOrder(OrderReqDTO order);
}
