package com.yourticket.services.imp;

import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.response.UserSessionResDTO;
import com.yourticket.entities.RoleEntity;
import com.yourticket.entities.UserSessionEntity;
import com.yourticket.repositories.IRoleRepository;
import com.yourticket.repositories.IUserRepository;
import com.yourticket.services.ITokenService;
import com.yourticket.services.IUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredd
 */
@Service
public class UserSessionService implements IUserSessionService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserSessionResDTO logIn(UserReqDTO user) {
        UserSessionEntity userEntity = userRepository.getUserSession(user.getUserName());
        if (userEntity == null)
            return null;

        if (!encoder.matches(user.getUserPassword(), userEntity.getUserPasswordHash()))
            return null;

        RoleEntity roleEntity = roleRepository.getRole(userEntity.getRoleID());
        userEntity.setUserRole(roleEntity.getDescription());

        UserSessionResDTO userSession = new UserSessionResDTO();
        userSession.setUserID(userEntity.getUserID());
        userSession.setUserName(userEntity.getUsername());
        userSession.setUserRole(userEntity.getUserRole());
        userSession.setToken(tokenService.generateToken(userEntity));

        return userSession;
    }

    @Override
    public boolean validateToken(String token) {
        return tokenService.verifyToken(token);
    }

}
