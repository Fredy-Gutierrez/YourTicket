package com.yourticket.repositories.imp;

import com.yourticket.dtos.request.EventReqDTO;
import com.yourticket.dtos.request.RowsReqDTO;
import com.yourticket.dtos.request.SeatsReqDTO;
import com.yourticket.dtos.request.ZonesReqDTO;
import com.yourticket.entities.EventEntity;
import com.yourticket.entities.RowsEntity;
import com.yourticket.entities.SeatInformationEntity;
import com.yourticket.entities.SeatsEntity;
import com.yourticket.entities.ZonesEntity;
import com.yourticket.mappers.EventMapper;
import com.yourticket.mappers.SeatInformationMapper;
import com.yourticket.repositories.IEventRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fredd
 */
@Repository
public class EventRepository implements IEventRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private NamedParameterJdbcTemplate npJdbc;

    /// ********************EVENT SECTION*********************///
    @Override
    public EventEntity getEvent(int eventId) {
        EventEntity event = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tevent ")
                    .append("WHERE eventID = ?;")
                    .toString();

            event = jdbc.queryForObject(query, new EventMapper(), eventId);
        } catch (EmptyResultDataAccessException empty) {
        } catch (DataAccessException ex) {
        }

        return event;
    }

    @Override
    public List<EventEntity> getAllEvent() {
        List<EventEntity> event = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tevent;")
                    .toString();

            event = jdbc.query(query, new EventMapper());
        } catch (EmptyResultDataAccessException empty) {
        } catch (DataAccessException ex) {
        }
        return event;
    }

    @Override
    public List<EventEntity> getSellerEvents(int userId) {
        List<EventEntity> event = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tevent ")
                    .append("WHERE userID = ?;")
                    .toString();

            event = jdbc.query(query, new EventMapper(), userId);
        } catch (EmptyResultDataAccessException empty) {
        } catch (DataAccessException ex) {
        }
        return event;
    }

    @Override
    public int createEvent(EventReqDTO event) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String query = new StringBuffer("INSERT INTO ")
                .append("tevent(eventName,information,location,eventDay,status,userID) ")
                .append("VALUES(?, ?, ?, ?, ?, ?);")
                .toString();

        jdbc.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, event.getEventName());
            ps.setString(2, event.getInformation());
            ps.setString(3, event.getLocalization());
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(event.getEventDay()));
            ps.setString(5, event.getStatus());
            ps.setInt(6, event.getUserID());
            return ps;
        }, keyHolder);

        return (int) keyHolder.getKeys().get("eventID");
    }

    @Override
    public boolean updateEvent(EventReqDTO event) {
        String query = new StringBuffer("UPDATE tevent ")
                .append("SET eventName = ?, ")
                .append("information = ?, ")
                .append("location = ?, ")
                .append("eventDay = ? ")
                .append("WHERE eventID = ?;")
                .toString();

        jdbc.update(query, event.getEventName(), event.getInformation(), event.getLocalization(), event.getEventDay(),
                event.getEventID());

        return true;
    }

    @Override
    public boolean cancelEvent(EventReqDTO event) {
        String query = new StringBuffer("UPDATE tevent ")
                .append("SET status = ? ")
                .append("WHERE eventID = ?;")
                .toString();

        jdbc.update(query, event.getStatus(), event.getEventID());

        return true;
    }

    /// ********************ZONES SECTION*********************///
    @Override
    public List<ZonesEntity> getZones(int eventId) {
        List<ZonesEntity> zones = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM teventzone ")
                    .append("WHERE eventID = ?;")
                    .toString();
            zones = jdbc.query(query, (ResultSet rs, int rowNum) -> {
                ZonesEntity entity = new ZonesEntity();
                entity.setZoneID(rs.getInt("zoneID"));
                entity.setZoneName(rs.getString("zoneName"));
                entity.setTicketPrice(rs.getBigDecimal("ticketPrice"));
                entity.setEventID(rs.getInt("eventID"));
                return entity;
            }, eventId);
        } catch (EmptyResultDataAccessException empty) {
        } catch (DataAccessException ex) {
        }
        return zones;
    }

    @Override
    public boolean addZones(int eventId, List<ZonesReqDTO> zones) {
        String query = new StringBuffer("INSERT INTO ")
                .append("teventzone(zoneName,ticketPrice,eventID) ")
                .append("VALUES(?, ?, ?);")
                .toString();

        // Adding the eventId to all elements in list to make the insert faster
        zones.forEach(zone -> zone.setEventID(eventId));

        jdbc.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, zones.get(i).getZoneName());
                ps.setBigDecimal(2, zones.get(i).getTicketPrice());
                ps.setInt(3, zones.get(i).getEventID());
            }

            @Override
            public int getBatchSize() {
                return zones.size();
            }
        });

        return true;
    }

    @Override
    public boolean deleteZone(int zoneId) {
        String query = new StringBuffer("DELETE ")
                .append("FROM teventzone ")
                .append("WHERE zoneID = ?;")
                .toString();
        jdbc.update(query, zoneId);
        return true;
    }

    /// ********************ROWS SECTION*********************///
    @Override
    public List<RowsEntity> getRows(int zoneId) {
        List<RowsEntity> rows = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM trowzone ")
                    .append("WHERE zoneID = ?;")
                    .toString();
            rows = jdbc.query(query, (ResultSet rs, int rowNum) -> {
                RowsEntity entity = new RowsEntity();
                entity.setRowID(rs.getInt("rowID"));
                entity.setRowName(rs.getString("rowName"));
                entity.setZoneID(rs.getInt("zoneID"));
                return entity;
            }, zoneId);
        } catch (EmptyResultDataAccessException empty) {
        } catch (DataAccessException ex) {
        }
        return rows;
    }

    @Override
    public boolean addRows(int zoneId, List<RowsReqDTO> rows) {
        String query = new StringBuffer("INSERT INTO ")
                .append("trowzone(rowName,zoneID) ")
                .append("VALUES(?, ?);")
                .toString();

        rows.forEach(row -> row.setZoneID(zoneId));

        jdbc.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, rows.get(i).getRowName());
                ps.setInt(2, rows.get(i).getZoneID());
            }

            @Override
            public int getBatchSize() {
                return rows.size();
            }
        });

        return true;
    }

    @Override
    public boolean deleteRows(List<RowsReqDTO> rows) {
        String query = new StringBuffer("DELETE ")
                .append("FROM trowzone ")
                .append("WHERE rowID = :rowID;")
                .toString();

        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(rows.toArray());
        int[] results = npJdbc.batchUpdate(query, batchArgs);

        return results.length > 0;
    }

    /// ********************SEATS SECTION*********************///
    @Override
    public SeatsEntity getSeat(int seatId) {
        SeatsEntity seat = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tseatrow ")
                    .append("WHERE seatID = ?;")
                    .toString();

            seat = jdbc.queryForObject(query, (ResultSet rs, int rowNumber) -> {
                SeatsEntity entity = new SeatsEntity();
                entity.setSeatID(rs.getInt("seatID"));
                entity.setSeatNumber(rs.getInt("seatNumber"));
                entity.setAvailable(rs.getBoolean("avalaible"));
                entity.setRowID(rs.getInt("rowID"));
                return entity;
            }, seatId);
        } catch (EmptyResultDataAccessException empty) {
        } catch (DataAccessException ex) {
        }

        return seat;
    }

    @Override
    public List<SeatsEntity> getSeats(int rowId) {
        List<SeatsEntity> seats = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tseatrow ")
                    .append("WHERE rowID = ?;")
                    .toString();
            seats = jdbc.query(query, (ResultSet rs, int rowNum) -> {
                SeatsEntity entity = new SeatsEntity();
                entity.setSeatID(rs.getInt("seatID"));
                entity.setSeatNumber(rs.getInt("seatNumber"));
                entity.setAvailable(rs.getBoolean("avalaible"));
                entity.setRowID(rs.getInt("rowID"));
                return entity;
            }, rowId);
        } catch (EmptyResultDataAccessException empty) {
        } catch (DataAccessException ex) {
        }
        return seats;
    }

    @Override
    public SeatInformationEntity getAllSeatInformation(int seatId) {
        SeatInformationEntity seat = null;
        try {
            String query = new StringBuffer("SELECT tseatrow.seatid, tseatrow.seatnumber,tseatrow.avalaible, ")
                    .append("trowzone.rowid,trowzone.rowname, ")
                    .append("teventzone.zoneid,teventzone.zonename,teventzone.ticketprice, ")
                    .append("tevent.eventid,tevent.eventname,tevent.information,tevent.eventday,tevent.status,tevent.location,tevent.userid ")
                    .append("FROM tseatrow ")
                    .append("LEFT JOIN trowzone ON tseatrow.rowid = trowzone.rowid ")
                    .append("LEFT JOIN teventzone ON teventzone.zoneid = trowzone.zoneid ")
                    .append("LEFT JOIN tevent ON tevent.eventid = teventzone.eventid ")
                    .append("WHERE tseatrow.seatid = ?;")
                    .toString();

            seat = jdbc.queryForObject(query, new SeatInformationMapper(), seatId);
        } catch (EmptyResultDataAccessException empty) {
        } catch (DataAccessException ex) {
        }

        return seat;
    }

    @Override
    public boolean addSeats(int rowId, List<SeatsReqDTO> seats) {
        String query = new StringBuffer("INSERT INTO ")
                .append("tseatrow(seatNumber,avalaible,rowID) ")
                .append("VALUES(?, ?, ?);")
                .toString();

        // Adding the zoneId to all elements in list to make the insert faster
        seats.forEach(seat -> {
            seat.setRowID(rowId);
            seat.setAvailable(true);
        });

        jdbc.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, seats.get(i).getSeatNumber());
                ps.setBoolean(2, seats.get(i).isAvailable());
                ps.setInt(3, seats.get(i).getRowID());
            }

            @Override
            public int getBatchSize() {
                return seats.size();
            }
        });

        return true;
    }

    @Override
    public boolean updateSeatAvalaible(int rowId, SeatsReqDTO seat) {
        String query = new StringBuffer("UPDATE tseatrow ")
                .append("SET avalaible = ? ")
                .append("WHERE seatID = ?;")
                .toString();
        jdbc.update(query, seat.isAvailable(), seat.getSeatID());
        return true;
    }

    @Override
    public boolean deleteSeats(int rowId, List<SeatsReqDTO> seats) {
        String query = new StringBuffer("DELETE ")
                .append("FROM tseatrow ")
                .append("WHERE seatID = :seatID;")
                .toString();

        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(seats.toArray());
        int[] results = npJdbc.batchUpdate(query, batchArgs);

        return results.length > 0;
    }

}
