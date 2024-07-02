/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.repositories.imp;

import com.yourticket.dtos.request.SellerReqDTO;
import com.yourticket.entities.SellerEntity;
import com.yourticket.mappers.SellerMapper;
import com.yourticket.repositories.ISellerRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
public class SellerRepository implements ISellerRepository {
    
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public SellerEntity getSeller(int sellerId) {
        SellerEntity seller = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tseller ")
                    .append("WHERE sellerID = ?;")
                    .toString();

            seller = jdbc.queryForObject(query, new SellerMapper(), sellerId);
        } catch (EmptyResultDataAccessException empty){
            System.out.println("Empty");
        }catch (DataAccessException ex){
            System.out.println("Exception");
        }
        
        return seller;
    }
    
    @Override
    public SellerEntity getSellerByUser(int userId) {
        SellerEntity seller = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tseller ")
                    .append("WHERE userID = ?;")
                    .toString();

            seller = jdbc.queryForObject(query, new SellerMapper(), userId);
        } catch (EmptyResultDataAccessException empty){
            System.out.println("Empty");
        }catch (DataAccessException ex){
            System.out.println("Exception");
        }
        
        return seller;
    }

    @Override
    public int createSeller(SellerReqDTO seller) {
        KeyHolder keyHolder = new GeneratedKeyHolder();                

        String query = new StringBuffer("INSERT INTO ")
            .append("tseller(name,information,rfc,country,addres,email,phoneNumber,userID) ")
            .append("VALUES(?, ?, ?, ?, ?, ?, ?, ?);")
            .toString();
        
        jdbc.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, seller.getName());
            ps.setString(2, seller.getInformation());
            ps.setString(3, seller.getRfc());
            ps.setString(4, seller.getCountry());
            ps.setString(5, seller.getAddress());
            ps.setString(6, seller.getEmail());
            ps.setString(7, seller.getPhone());
            ps.setInt(8, seller.getUserID());
            return ps;
        }, keyHolder);
        
        return (int)keyHolder.getKeys().get("sellerID");
    }

    @Override
    public boolean updateSeller(SellerReqDTO seller) {
        String query = new StringBuffer("UPDATE tseller ")
                    .append("SET name = ?,")
                    .append("information = ?,")
                    .append("rfc = ?,")
                    .append("country = ?,")
                    .append("addres = ?,")
                    .append("email = ?,")
                    .append("phoneNumber = ? ")
                    .append("WHERE sellerID = ?;")
                    .toString();
        
        jdbc.update(query, seller.getName(), seller.getInformation(), seller.getRfc(),
        seller.getCountry(), seller.getAddress(), seller.getEmail(), seller.getPhone(),
        seller.getSellerID());
        
        return true;
    }
    
}
