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
