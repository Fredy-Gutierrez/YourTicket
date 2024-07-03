package com.yourticket.services;

import com.yourticket.dtos.request.UserCustomerReqDTO;
import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.request.UserSellerReqDTO;
import com.yourticket.dtos.response.UserResDTO;

/**
 *
 * @author fredd
 */
public interface IUserService {
    public UserResDTO createUser(UserCustomerReqDTO user);
    public UserResDTO createUserSeller(UserSellerReqDTO user);
    public UserResDTO getUser(int userId);
    public UserResDTO updateUser(UserReqDTO user);
}
