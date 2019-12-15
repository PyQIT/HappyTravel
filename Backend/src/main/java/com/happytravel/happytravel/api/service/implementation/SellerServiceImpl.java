package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Seller;
import com.happytravel.happytravel.api.repository.SellerRepository;
import com.happytravel.happytravel.api.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public List<Seller> getSellers(){
        return sellerRepository.getAllSellers();
    }

}