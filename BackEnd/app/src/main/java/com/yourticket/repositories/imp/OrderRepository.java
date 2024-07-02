package com.yourticket.repositories.imp;

import com.yourticket.dtos.request.OrderReqDTO;
import com.yourticket.entities.OrderEntity;
import com.yourticket.mappers.OrderMapper;
import com.yourticket.repositories.IOrderRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fredd
 */
@Repository
public class OrderRepository implements IOrderRepository {
    
    
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public OrderEntity getOrder(int orderId) {
        OrderEntity event = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM torder ")
                    .append("WHERE orderID = ?;")
                    .toString();

            event = jdbc.queryForObject(query, new OrderMapper(), orderId);
        } catch (EmptyResultDataAccessException empty){
        }catch (DataAccessException ex){
        }
        return event;
    }

    @Override
    public List<OrderEntity> getOrders(int userId) {
        List<OrderEntity> order = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM torder ")
                    .append("WHERE userID = ?;")
                    .toString();

            order = jdbc.query(query, new OrderMapper(), userId);
        } catch (EmptyResultDataAccessException empty){
        }catch (DataAccessException ex){
        }
        return order;
    }

    @Override
    public int createOrder(OrderReqDTO order) {
        KeyHolder keyHolder = new GeneratedKeyHolder();                

        String query = new StringBuffer("INSERT INTO ")
            .append("torder(paymentMethod,orderDate,status,seatID,userID) ")
            .append("VALUES(?, ?, ?, ?, ?);")
            .toString();
        
        jdbc.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getPaymentMethod());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(order.getOrderDate()));
            ps.setString(3, order.getStatus());
            ps.setInt(4, order.getSeatID());
            ps.setInt(5, order.getUserID());
            return ps;
        }, keyHolder);
        
        return (int)keyHolder.getKeys().get("orderID");
    }

    @Override
    public boolean updateOrder(OrderReqDTO order) {
        String query = new StringBuffer("UPDATE torder ")
                    .append("SET userID = ?, ")
                    .append("status = ? ")
                    .append("WHERE orderID = ?;")
                    .toString();
        
        jdbc.update(query, order.getUserID(), order.getStatus(), order.getOrderID());
        
        return true;
    }

    @Override
    public boolean cancelOrder(OrderReqDTO order) {
        String query = new StringBuffer("UPDATE torder ")
                    .append("SET status = ? ")
                    .append("WHERE orderID = ?;")
                    .toString();
        
        jdbc.update(query, order.getStatus(), order.getOrderID());
        
        return true;
    }
    
}
