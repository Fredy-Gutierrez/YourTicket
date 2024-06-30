package com.yourticket.services;

import com.yourticket.dtos.request.SellerReqDTO;
import com.yourticket.dtos.response.SellerResDTO;

/**
 *
 * @author fredd
 */
public interface ISellerService {
    public SellerResDTO createSeller(SellerReqDTO seller);
    public SellerResDTO getSeller(int sellerId);
    public SellerResDTO updateSeller(SellerReqDTO seller);
}
