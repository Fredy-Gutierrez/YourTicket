package com.yourticket.services;

import com.yourticket.dtos.request.NewUserReqDTO;
import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.response.UserResDTO;

/**
 *
 * @author fredd
 */
public interface IUserService {
    public UserResDTO createUser(NewUserReqDTO user);
    public UserResDTO createUserSeller(NewUserReqDTO user);
    public UserResDTO getUser(int userId);
    public UserResDTO updateUser(UserReqDTO user);
}
