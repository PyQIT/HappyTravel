package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Seller;

import java.util.List;

public interface SellerService {

    List<Seller> getSellers();
    Long getMaxId();
    int insertSeller(Long id, Long sellerId);
    Long getSellerIdByUserId(Long uID);
}