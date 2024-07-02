/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.services.imp;

import com.yourticket.dtos.request.SellerReqDTO;
import com.yourticket.dtos.response.SellerResDTO;
import com.yourticket.entities.SellerEntity;
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
    public SellerResDTO createSeller(SellerReqDTO seller) {
        int sellerId = sellerRepository.createSeller(seller);
        if(sellerId > 0)
            return getSeller(sellerId);
        return null;
    }

    @Override
    public SellerResDTO updateSeller(SellerReqDTO seller) {
        if(sellerRepository.updateSeller(seller))
            return mapperDTO.map(seller, SellerResDTO.class);
        return null;
    }
    
}
