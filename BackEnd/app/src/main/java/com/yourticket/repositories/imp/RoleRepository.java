package com.yourticket.repositories.imp;

import com.yourticket.entities.RoleEntity;
import com.yourticket.repositories.IRoleRepository;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fredd
 */
@Repository
public class RoleRepository implements IRoleRepository {
    
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public RoleEntity getRole(int roleId) {
        RoleEntity role = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM trole ")
                    .append("WHERE roleID = ?;")
                    .toString();
            
            role = jdbc.queryForObject(query, (ResultSet rs, int rowNumber) -> {
                RoleEntity entity = new RoleEntity();
                entity.setRoleID(rs.getInt("roleID"));
                entity.setDescription(rs.getString("description"));
                return entity;
            }, roleId);
        } catch (EmptyResultDataAccessException empty){
            System.out.println("Empty");
        }catch (DataAccessException ex){
            System.out.println("Exception");
        }
        
        return role;
    }
    
}
