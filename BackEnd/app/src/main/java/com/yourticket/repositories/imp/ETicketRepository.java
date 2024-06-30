package com.yourticket.repositories.imp;

import com.yourticket.dtos.request.ETicketReqDTO;
import com.yourticket.entities.CheckInEntity;
import com.yourticket.entities.ETicketEntity;
import com.yourticket.repositories.IETicketRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

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
public class ETicketRepository implements IETicketRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public ETicketEntity getETicket(int orderId) {
        ETicketEntity eticket = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM teticket ")
                    .append("WHERE orderID = ?;")
                    .toString();

            eticket = jdbc.queryForObject(query, (ResultSet rs, int rowNumber) -> {
                ETicketEntity entity = new ETicketEntity();
                entity.setETicket(rs.getString("teticket"));
                entity.setOrderId(rs.getInt("orderID"));
                return entity;
            }, orderId);
        } catch (EmptyResultDataAccessException empty) {
            System.out.println("Empty");
        } catch (DataAccessException ex) {
            System.out.println("Exception");
        }

        return eticket;
    }

    @Override
    public ETicketEntity getETicket(String eticket) {
        ETicketEntity result = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM teticket ")
                    .append("WHERE teticket = ?;")
                    .toString();

            result = jdbc.queryForObject(query, (ResultSet rs, int rowNumber) -> {
                ETicketEntity entity = new ETicketEntity();
                entity.setETicket(rs.getString("teticket"));
                entity.setOrderId(rs.getInt("orderID"));
                return entity;
            }, eticket);
        } catch (EmptyResultDataAccessException empty) {
            System.out.println("Empty");
        } catch (DataAccessException ex) {
            System.out.println("Exception");
        }

        return result;
    }

    @Override
    public CheckInEntity getCheckIn(int orderId) {
        CheckInEntity result = null;
        try {
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tcheckin ")
                    .append("WHERE orderID = ?;")
                    .toString();

            result = jdbc.queryForObject(query, (ResultSet rs, int rowNumber) -> {
                CheckInEntity entity = new CheckInEntity();
                entity.setCkeckID(rs.getInt("ckeckID"));
                entity.setCheckDate(rs.getTimestamp("checkDate").toLocalDateTime());
                entity.setTeticket(rs.getString("teticket"));
                entity.setOrderID(rs.getInt("orderID"));
                return entity;
            }, orderId);
        } catch (EmptyResultDataAccessException empty) {
            System.out.println("Empty");
        } catch (DataAccessException ex) {
            System.out.println("Exception");
        }

        return result;
    }

    @Override
    public ETicketEntity saveETicket(ETicketReqDTO eticket) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String query = new StringBuffer("INSERT INTO ")
                .append("teticket(teticket, orderid) ")
                .append("VALUES(?, ?);")
                .toString();

        jdbc.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, eticket.getETicket());
            ps.setInt(2, eticket.getOrderId());
            return ps;
        }, keyHolder);

        return new ETicketEntity(eticket.getETicket(), eticket.getOrderId());
    }

    @Override
    public ETicketEntity updateETicket(int orderId, ETicketReqDTO eticket) {
        String query = new StringBuffer("UPDATE teticket ")
                .append("SET teticket = ? ")
                .append(" WHERE orderid = ?;")
                .toString();

        jdbc.update(query, eticket.getETicket(), eticket.getOrderId());

        return new ETicketEntity(eticket.getETicket(), orderId);
    }

    @Override
    public ETicketEntity checkIn(ETicketReqDTO eticket) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String query = new StringBuffer("INSERT INTO ")
                .append("tcheckin(checkdate, teticket, orderID) ")
                .append("VALUES(?, ?, ?);")
                .toString();

        jdbc.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(2, eticket.getETicket());
            ps.setInt(3, eticket.getOrderId());
            return ps;
        }, keyHolder);

        return new ETicketEntity(eticket.getETicket(), eticket.getOrderId());
    }

}
