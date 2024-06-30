/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.repositories.imp;

import com.yourticket.entities.HistoryEntity;
import com.yourticket.repositories.IHistoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fredd
 */
@Repository
public class HistoryRepository implements IHistoryRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public boolean saveHistory(HistoryEntity history) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String query = new StringBuffer("INSERT INTO ")
                .append("torderhistory(paymentmethod, eventdate, seatnumber, rowname, zonename, eventname, location, userid) ")
                .append("VALUES(?, ?, ?, ?, ?, ?, ?, ?);")
                .toString();

        jdbc.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, history.getPaymentMethod());
            ps.setTimestamp(2, Timestamp.valueOf(history.getEventDate()));
            ps.setInt(3, history.getSeatNumber());
            ps.setString(4, history.getRowName());
            ps.setString(5, history.getZoneName());
            ps.setString(6, history.getEventName());
            ps.setString(7, history.getLocation());
            ps.setInt(8, history.getUserID());
            return ps;
        }, keyHolder);

        return true;
    }

}
