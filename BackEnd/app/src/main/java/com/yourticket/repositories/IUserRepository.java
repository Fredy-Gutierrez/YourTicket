package com.yourticket.repositories;

import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.entities.UserEntity;
import com.yourticket.entities.UserSessionEntity;

/**
 *
 * @author fredd
 */
public interface IUserRepository {
    public UserEntity getUser(int userId);
    public UserEntity getUser(String userName);
    public UserSessionEntity getUserSession(String username);
    public int createUser(UserReqDTO user);
    public boolean updateUser(UserReqDTO user);
}
