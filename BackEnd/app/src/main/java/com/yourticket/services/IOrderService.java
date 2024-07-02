/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yourticket.services;

import com.yourticket.dtos.request.OrderReqDTO;
import com.yourticket.dtos.response.OrderResDTO;
import java.util.List;

/**
 *
 * @author fredd
 */
public interface IOrderService {
    public OrderResDTO getOrder(int orderId);
    public List<OrderResDTO> getOrders(int userId);
    public OrderResDTO createOrder(OrderReqDTO order);
    public OrderResDTO updateOrder(OrderReqDTO order);
    public OrderResDTO cancelOrder(OrderReqDTO order);
}
