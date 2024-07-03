package com.yourticket.services.imp;

import com.yourticket.dtos.request.SellerReqDTO;
import com.yourticket.dtos.response.SellerResDTO;
import com.yourticket.entities.SellerEntity;
import com.yourticket.exceptions.FildValidationException;
import com.yourticket.repositories.ISellerRepository;
import com.yourticket.services.ISellerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fredd
 */
@Service
public class SellerService implements ISellerService {
    
    @Autowired
    private ISellerRepository sellerRepository;
    
    @Autowired
    private ModelMapper mapperDTO;

    @Override
    public SellerResDTO getSeller(int sellerId) {
        SellerEntity entity = sellerRepository.getSeller(sellerId);
        if(entity == null)
            return null;
        return mapperDTO.map(entity, SellerResDTO.class);
    }
    
    @Override
    public SellerResDTO getSellerByUser(int userId) {
        SellerEntity entity = sellerRepository.getSellerByUser(userId);
        if(entity == null)
            return null;
        return mapperDTO.map(entity, SellerResDTO.class);
    }

    @Override
    public SellerResDTO createSeller(SellerReqDTO seller) throws FildValidationException{
        if(seller.getUserID() <= 0)
            throw new FildValidationException("userID", "El userID debe ser mayor a 0");
        
        int sellerId = sellerRepository.createSeller(seller);
        if(sellerId > 0)
            return getSeller(sellerId);
        return null;
    }

    @Override
    public SellerResDTO updateSeller(SellerReqDTO seller) throws FildValidationException{
        if(seller.getSellerID() <= 0)
            throw new FildValidationException("sellerID", "El sellerID debe ser mayor a 0");
        
        if(sellerRepository.updateSeller(seller))
            return mapperDTO.map(seller, SellerResDTO.class);
        return null;
    }
    
}
