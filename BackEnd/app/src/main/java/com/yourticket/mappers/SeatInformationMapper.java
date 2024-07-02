package com.yourticket.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yourticket.entities.SeatInformationEntity;

public class SeatInformationMapper implements RowMapper<SeatInformationEntity> {

    @Override
    public SeatInformationEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        SeatInformationEntity entity = new SeatInformationEntity();

        entity.setSeatID(rs.getInt("seatID"));
        entity.setSeatNumber(rs.getInt("seatNumber"));
        entity.setAvailable(rs.getBoolean("avalaible"));
        entity.setRowID(rs.getInt("rowID"));
        entity.setRowName(rs.getString("rowName"));
        entity.setZoneID(rs.getInt("zoneID"));
        entity.setZoneName(rs.getString("zoneName"));
        entity.setTicketPrice(rs.getBigDecimal("ticketPrice"));
        entity.setEventID(rs.getInt("eventID"));
        entity.setEventName(rs.getString("eventName"));
        entity.setInformation(rs.getString("information"));
        entity.setEventDay(rs.getTimestamp("eventDay").toLocalDateTime());
        entity.setStatus(rs.getString("status"));
        entity.setLocalization(rs.getString("location"));
        entity.setUserID(rs.getInt("userID"));

        return entity;
    }

}
