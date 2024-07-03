package com.yourticket.mappers;

import com.yourticket.entities.EventEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author fredd
 */
public class EventMapper implements RowMapper<EventEntity> {

    @Override
    public EventEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        EventEntity entity = new EventEntity();
        
        entity.setEventID(rs.getInt("eventID"));
        entity.setEventName(rs.getString("eventName"));
        entity.setInformation(rs.getString("information"));
        entity.setLocalization(rs.getString("location"));
        entity.setEventDay(rs.getTimestamp("eventDay").toLocalDateTime());
        entity.setStatus(rs.getString("status"));
        entity.setUserID(rs.getInt("userID"));
        
        return entity;
    }
    
}
