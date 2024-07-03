package com.yourticket.mappers;

import com.yourticket.entities.SellerEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author fredd
 */
public class SellerMapper implements RowMapper<SellerEntity> {

    @Override
    public SellerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        SellerEntity seller = new SellerEntity();
        
        seller.setSellerID(rs.getInt("sellerID"));
        seller.setName(rs.getString("name"));
        seller.setInformation(rs.getString("information"));
        seller.setRfc(rs.getString("rfc"));
        seller.setCountry(rs.getString("country"));
        seller.setAddress(rs.getString("addres"));
        seller.setEmail(rs.getString("email"));
        seller.setPhone(rs.getString("phoneNumber"));
        seller.setUserID(rs.getInt("userID"));
        
        return seller;
    }
    
}
