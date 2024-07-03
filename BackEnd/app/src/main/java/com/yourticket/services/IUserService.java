package com.yourticket.services;

import com.yourticket.dtos.request.UserCustomerReqDTO;
import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.request.UserSellerReqDTO;
import com.yourticket.dtos.response.UserResDTO;
import com.yourticket.exceptions.FildValidationException;

/**
 *
 * @author fredd
 */
public interface IUserService {
    public UserResDTO getUser(int userId);
    public UserResDTO getUser(String userName);
    public UserResDTO createUser(UserCustomerReqDTO user) throws FildValidationException;
    public UserResDTO createUserSeller(UserSellerReqDTO user) throws FildValidationException;
    public UserResDTO updateUser(UserReqDTO user);
}
