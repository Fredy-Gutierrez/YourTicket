package com.yourticket.mappers;

import com.yourticket.entities.CustomerEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

/**
 *
 * @author fredd
 */
public class CustomerMapper implements RowMapper<CustomerEntity>{

    @Override
    public CustomerEntity mapRow(@Nullable ResultSet rs, int rowNum) throws SQLException {
        CustomerEntity customer = new CustomerEntity();
        
        customer.setCustomerID(rs.getInt("customerID"));
        customer.setName(rs.getString("name"));
        customer.setLastName(rs.getString("lastName"));
        customer.setBirthDay(rs.getDate("birthDay").toLocalDate());
        customer.setCountry(rs.getString("country"));
        customer.setAddress(rs.getString("addres"));
        customer.setEmail(rs.getString("email"));
        customer.setPhone(rs.getString("phoneNumber"));
        customer.setUserID(rs.getInt("userID"));
        
        return customer;
    }
    
}
