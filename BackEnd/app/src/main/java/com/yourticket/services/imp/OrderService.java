package com.yourticket.services.imp;

import com.yourticket.dtos.request.OrderReqDTO;
import com.yourticket.dtos.request.SeatsReqDTO;
import com.yourticket.dtos.response.OrderResDTO;
import com.yourticket.dtos.response.SeatsResDTO;
import com.yourticket.entities.HistoryEntity;
import com.yourticket.mappers.ListMapper;
import com.yourticket.repositories.IHistoryRepository;
import com.yourticket.repositories.IOrderRepository;
import com.yourticket.repositories.IPaymentRepository;
import com.yourticket.services.IEventService;
import com.yourticket.services.IOrderService;
import com.yourticket.utils.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredd
 */
@Service
public class OrderService implements IOrderService {
    
    @Autowired
    private IEventService eventService;
    
    @Autowired
    private IOrderRepository orderRepository;
    
    @Autowired 
    private IPaymentRepository paymentRepository;
    
    @Autowired 
    private IHistoryRepository historyRepository;
    
    @Autowired
    private ModelMapper mapperDTO;
    
    @Autowired
    private ListMapper listMapper;
    
    @Override
    public OrderResDTO getOrder(int orderId) {
        return mapperDTO.map(orderRepository.getOrder(orderId), OrderResDTO.class);
    }

    @Override
    public List<OrderResDTO> getOrders(int userId) {
        return listMapper.mapList(orderRepository.getOrders(userId), OrderResDTO.class);
    }

    @Override
    public OrderResDTO createOrder(OrderReqDTO order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.ACTIVA.toString());
        
        if(!paymentRepository.makePayment(order))
            return null;
        
        SeatsResDTO seatRes = eventService.getSeat(order.getSeatID());
        if(seatRes == null)
            return null;
        
        SeatsReqDTO seat = mapperDTO.map(seatRes, SeatsReqDTO.class);
        if(eventService.updateSeatAvalaible(seat.getRowID(), seat) == null){
            paymentRepository.refundPayment(order);
            return null;
        }
        
        HistoryEntity history = new HistoryEntity();
        //Not supported yet
        historyRepository.saveHistory(history);
        
        int orderId = orderRepository.createOrder(order);
        if(orderId > 0)
            return getOrder(orderId);
        
        return null;
            
    }

    @Override
    public OrderResDTO updateOrder(OrderReqDTO order) {
        order.setStatus(OrderStatus.REASIGNADA.toString());
        if(orderRepository.updateOrder(order))
            return getOrder(order.getOrderID());
        return null;
    }

    @Override
    public OrderResDTO cancelOrder(OrderReqDTO order) {
        order.setStatus(OrderStatus.CANCELADA.toString());
        
        if(orderRepository.cancelOrder(order))
            return new OrderResDTO();
        return null;
    }
    
}
