package com.yourticket.mappers;

import com.yourticket.entities.OrderEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author fredd
 */
public class OrderMapper implements RowMapper<OrderEntity> {

    @Override
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderEntity entity = new OrderEntity();
        entity.setOrderID(rs.getInt("orderID"));
        entity.setPaymentMethod(rs.getString("paymentMethod"));
        entity.setOrderDate(rs.getTimestamp("orderDate").toLocalDateTime());
        entity.setStatus(rs.getString("status"));
        entity.setSeatID(rs.getInt("seatID"));
        entity.setUserID(rs.getInt("userID"));

        entity.setSeatNumber(rs.getInt("seatNumber"));
        entity.setRowName(rs.getString("rowName"));
        entity.setZoneName(rs.getString("zoneName"));
        entity.setTicketPrice(rs.getBigDecimal("ticketPrice"));
        entity.setEventName(rs.getString("eventName"));
        entity.setInformation(rs.getString("information"));
        entity.setEventDay(rs.getTimestamp("eventDay").toLocalDateTime());
        entity.setLocalization(rs.getString("location"));
        return entity;
    }

}
