/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yourticket.services;

import com.yourticket.entities.UserSessionEntity;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author fredd
 */
public interface ITokenService {
    public String generateToken(UserSessionEntity session);
    public boolean verifyToken(String token);
    public String extractUsername(String jwtToken);
    public boolean isJwtTokenValid(String jwtToken, UserDetails userDetails);
}
