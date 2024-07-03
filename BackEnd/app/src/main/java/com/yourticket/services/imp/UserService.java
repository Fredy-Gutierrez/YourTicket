package com.yourticket.services.imp;

import com.yourticket.dtos.request.CustomerReqDTO;
import com.yourticket.dtos.request.SellerReqDTO;
import com.yourticket.dtos.request.UserCustomerReqDTO;
import com.yourticket.dtos.request.UserReqDTO;
import com.yourticket.dtos.request.UserSellerReqDTO;
import com.yourticket.dtos.response.CustomerResDTO;
import com.yourticket.dtos.response.SellerResDTO;
import com.yourticket.dtos.response.UserResDTO;
import com.yourticket.entities.UserEntity;
import com.yourticket.repositories.IUserRepository;
import com.yourticket.services.ICustomerService;
import com.yourticket.services.ISellerService;
import com.yourticket.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredd
 */
@Service
public class UserService implements IUserService {
    
    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private ICustomerService customerService;
    
    @Autowired
    private ISellerService sellerService;
    
    @Autowired
    private PasswordEncoder encoder;
    
    @Autowired
    private ModelMapper mapperDTO;
    
    @Override
    public UserResDTO getUser(int userId) {
        UserEntity entity = userRepository.getUser(userId);
        if(entity == null)
            return null;
        return mapperDTO.map(entity, UserResDTO.class);
    }

    @Override
    public UserResDTO createUser(UserCustomerReqDTO user) {
        if(user.getUser() == null)
            return null;
        if(user.getCustomer() == null)
            return null;
        
        user.getUser().setRoleID(2);//User ROLE
        user.getUser().setAvailable(true);//User ROLE
        user.getUser().setUserPassword(encoder.encode(user.getUser().getUserPassword()));
        int userId = userRepository.createUser(user.getUser());
        if(userId <= 0)
            return null;
        
        CustomerReqDTO customer = user.getCustomer();
        customer.setUserID(userId);
        CustomerResDTO newcustomer = customerService.createCustomer(customer);
        if(newcustomer == null)
            return null;
        
        return getUser(userId);
    }

    @Override
    public UserResDTO createUserSeller(UserSellerReqDTO user) {
        if(user.getUser() == null)
            return null;
        if(user.getSeller() == null)
            return null;
        
        user.getUser().setRoleID(3);//SELLER ROLE
        user.getUser().setAvailable(true);//User ROLE
        user.getUser().setUserPassword(encoder.encode(user.getUser().getUserPassword()));
        int userId = userRepository.createUser(user.getUser());
        if(userId <= 0)
            return null;
        
        SellerReqDTO seller = user.getSeller();
        seller.setUserID(userId);
        SellerResDTO newseller = sellerService.createSeller(seller);
        if(newseller == null)
            return null;
        
        return getUser(userId);
    }

    @Override
    public UserResDTO updateUser(UserReqDTO user) {
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        if(userRepository.updateUser(user))
            return getUser(user.getUserID());
        return null;
    }
    
}
