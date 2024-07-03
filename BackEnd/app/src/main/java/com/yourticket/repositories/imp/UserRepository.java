package com.yourticket.repositories.imp;

import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.entities.UserEntity;
import com.yourticket.entities.UserSessionEntity;
import com.yourticket.repositories.IUserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class UserRepository implements IUserRepository {
    @Autowired
    private JdbcTemplate jdbc;
    
    @Override
    public UserEntity getUser(int userId) {
        UserEntity user = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tuser ")
                    .append("WHERE userID = ?;")
                    .toString();
            
            user = jdbc.queryForObject(query, (ResultSet rs, int rowNumber) -> {
                UserEntity entity = new UserEntity();
                entity.setUserID(rs.getInt("userID"));
                entity.setUserName(rs.getString("userName"));
                entity.setUserPassword(rs.getString("userPassword"));
                entity.setAvailable(rs.getBoolean("available"));
                entity.setRoleID(rs.getInt("roleID"));
                return entity;
            }, userId);
        } catch (EmptyResultDataAccessException empty){
            System.out.println("Empty");
        }catch (DataAccessException ex){
            System.out.println("Exception");
        }
        
        return user;
    }

    @Override
    public UserEntity getUser(String userName) {
        UserEntity user = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tuser ")
                    .append("WHERE userName = ?;")
                    .toString();
            
            user = jdbc.queryForObject(query, (ResultSet rs, int rowNumber) -> {
                UserEntity entity = new UserEntity();
                entity.setUserID(rs.getInt("userID"));
                entity.setUserName(rs.getString("userName"));
                entity.setUserPassword(rs.getString("userPassword"));
                entity.setAvailable(rs.getBoolean("available"));
                entity.setRoleID(rs.getInt("roleID"));
                return entity;
            }, userName);
        } catch (EmptyResultDataAccessException empty){
            System.out.println("Empty");
        }catch (DataAccessException ex){
            System.out.println("Exception");
        }
        
        return user;
    }
    
    @Override
    public UserSessionEntity getUserSession(String username) {
        UserSessionEntity userEntity = null;
        try{
            String query = new StringBuffer("SELECT * ")
                    .append("FROM tuser ")
                    .append("WHERE userName = ?;")
                    .toString();
            
            userEntity = jdbc.queryForObject(query, (ResultSet rs, int rowNumber) -> {
                UserSessionEntity entity = new UserSessionEntity();
                entity.setUserName(rs.getString("userName"));
                entity.setUserPasswordHash(rs.getString("userPassword"));
                entity.setRoleID(rs.getInt("roleID"));
                return entity;
            }, username);
        } catch (EmptyResultDataAccessException empty){
            System.out.println("Empty");
        }catch (DataAccessException ex){
            System.out.println("Exception");
        }
        
        return userEntity;
    }

    @Override
    public int createUser(UserReqDTO user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();                

        String query = new StringBuffer("INSERT INTO ")
            .append("tuser(userName,userPassword,available,roleID) ")
            .append("VALUES(?, ?, ?, ?);")
            .toString();
        
        jdbc.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPassword());
            ps.setBoolean(3, user.isAvailable());
            ps.setInt(4, user.getRoleID());
            return ps;
        }, keyHolder);
        
        
        return (int)keyHolder.getKeys().get("userID");
    }

    @Override
    public boolean updateUser(UserReqDTO user) {
        String query = new StringBuffer("UPDATE tuser ")
                    .append("SET userPassword = ? ")
                    .append("WHERE userName = ?;")
                    .toString();
        
        jdbc.update(query, user.getUserPassword(), user.getUserName());
        
        return true;
    }
    
}
