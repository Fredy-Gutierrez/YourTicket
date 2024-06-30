/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yourticket.services;

import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.response.UserSessionResDTO;

/**
 *
 * @author fredd
 */
public interface IUserSessionService {
    public UserSessionResDTO logIn(UserReqDTO user);
//    public UserSessionResDTO logInUserSeller(UserSessionReqDTO user);
    public boolean validateToken(String token);
    public UserSessionResDTO logOut( int userId);
}
