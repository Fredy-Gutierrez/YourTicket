package com.yourticket.repositories;

import com.yourticket.dtos.request.SellerReqDTO;
import com.yourticket.entities.SellerEntity;

/**
 *
 * @author fredd
 */
public interface ISellerRepository {
    public SellerEntity getSeller(int sellerId);
    public SellerEntity getSellerByUser(int userId);
    public int createSeller(SellerReqDTO seller);
    public boolean updateSeller(SellerReqDTO seller);
}
