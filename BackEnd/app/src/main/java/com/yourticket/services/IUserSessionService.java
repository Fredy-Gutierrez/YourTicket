package com.yourticket.services;

import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.response.UserSessionResDTO;

/**
 *
 * @author fredd
 */
public interface IUserSessionService {
    public UserSessionResDTO logIn(UserReqDTO user);
    public boolean validateToken(String token);
}
