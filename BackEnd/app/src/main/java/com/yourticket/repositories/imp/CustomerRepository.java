package com.yourticket.repositories.imp;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.entities.CustomerEntity;
import com.yourticket.mappers.CustomerMapper;
import com.yourticket.repositories.ICustomerRepository;
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
public class CustomerRepository implements ICustomerRepository {
    
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public CustomerEntity getCustomer(int customerId) {
        CustomerEntity customer = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tcustomer ")
                    .append("WHERE customerID = ?;")
                    .toString();

            customer = jdbc.queryForObject(query, new CustomerMapper(), customerId);
        } catch (EmptyResultDataAccessException empty){
            System.out.println("Empty");
        }catch (DataAccessException ex){
            System.out.println("Exception");
        }
        
        return customer;
    }
    
    @Override
    public CustomerEntity getCustomerByUser(int userId) {
        CustomerEntity customer = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tcustomer ")
                    .append("WHERE userID = ?;")
                    .toString();

            customer = jdbc.queryForObject(query, new CustomerMapper(), userId);
        } catch (EmptyResultDataAccessException empty){
            System.out.println("Empty");
        }catch (DataAccessException ex){
            System.out.println("Exception");
        }
        
        return customer;
    }

    @Override
    public int createCustomer(CustomerReqDTO customer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();                

        String query = new StringBuffer("INSERT INTO ")
            .append("tcustomer(name,lastName,birthDay,country,addres,email,phoneNumber, userID) ")
            .append("VALUES(?, ?, ?, ?, ?, ?, ?, ?);")
            .toString();
        
        jdbc.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getLastName());
            ps.setDate(3, java.sql.Date.valueOf(customer.getBirthDay()));
            ps.setString(4, customer.getCountry());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPhone());
            ps.setInt(8, customer.getUserID());
            return ps;
        }, keyHolder);
        
        return (int)keyHolder.getKeys().get("customerID");
    }

    @Override
    public boolean updateCustomer(CustomerReqDTO customer) {
        String query = new StringBuffer("UPDATE tcustomer ")
                    .append("SET name = ?,")
                    .append("lastName = ?,")
                    .append("birthDay = ?,")
                    .append("country = ?,")
                    .append("addres = ?,")
                    .append("email = ?,")
                    .append("phoneNumber = ? ")
                    .append("WHERE customerID = ?;")
                    .toString();
        
        jdbc.update(query, customer.getName(), customer.getLastName(), customer.getBirthDay(), customer.getCountry(),
                customer.getAddress(), customer.getEmail(), customer.getPhone(), customer.getCustomerID());
        
        return true;
    }
    
}
