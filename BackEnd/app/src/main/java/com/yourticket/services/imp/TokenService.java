package com.yourticket.services.imp;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yourticket.entities.UserSessionEntity;
import com.yourticket.services.ITokenService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredd
 */
@Service
public class TokenService implements ITokenService {
    @Value("${app.tokenKey}")
    private String tokenKey;

    @Value("${app.tokenExpirationTime}")
    private int tokenExp;

    @Value("${app.tokenCreator}")
    private String tokenCreator;

    @Override
    public String generateToken(UserSessionEntity session) {
        LocalDateTime now = LocalDateTime.now();
        Algorithm algorithm = Algorithm.HMAC256(tokenKey);
        
        LocalDateTime expiration = now.plusMinutes(tokenExp);

        String jwtToken = JWT.create()
                .withIssuer(tokenCreator)
                .withSubject(session.getUsername())
                .withIssuedAt( now.atZone(ZoneId.systemDefault()).toInstant() )
                .withExpiresAt(expiration.atZone(ZoneId.systemDefault()).toInstant())
                .withJWTId(UUID.randomUUID()
                        .toString())
                .sign(algorithm);
        return jwtToken;
    }
    
    @Override
    public boolean verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(tokenKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(tokenCreator)
                .build();
        try {
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
    
    
    public DecodedJWT getDecodedJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(tokenKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(tokenCreator)
                .build();
        DecodedJWT decodedJWT;
        try {
            decodedJWT = verifier.verify(token);
        } catch (JWTVerificationException e) {
            return null;
        }
        return decodedJWT;
    }

    @Override
    public String extractUsername(String jwtToken) {
        DecodedJWT decodedJWT = getDecodedJWT(jwtToken);
        if (decodedJWT == null)
            return null;
        return decodedJWT.getSubject();
    }

    @Override
    public boolean isJwtTokenValid(String jwtToken, UserDetails userDetails) {
        final String username = extractUsername(jwtToken);
        if (username == null)
            return false;
        return (username.equals(userDetails.getUsername())) && !isJwtTokenExpired(jwtToken);
    }

    private boolean isJwtTokenExpired(String jwtToken) {
        LocalDateTime expiration = extractExpiration(jwtToken);
        if (expiration == null)
            return true;
        return extractExpiration(jwtToken).isBefore(LocalDateTime.now());
    }

    private LocalDateTime extractExpiration(String jwtToken) {
        DecodedJWT decodedJWT = getDecodedJWT(jwtToken);
        if (decodedJWT == null)
            return null;
        return LocalDateTime.ofInstant(decodedJWT.getExpiresAt().toInstant(), ZoneId.systemDefault());
    }
    
}
