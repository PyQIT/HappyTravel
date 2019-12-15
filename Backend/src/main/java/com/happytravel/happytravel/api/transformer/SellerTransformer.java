package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.SellerDto;
import com.happytravel.happytravel.api.model.Seller;
import org.springframework.beans.BeanUtils;

public class SellerTransformer {

    public static SellerDto convertToDto(Seller seller) {
        SellerDto sellerDto = new SellerDto();
        BeanUtils.copyProperties(seller, sellerDto);
        return sellerDto;
    }

    public static Seller convertToEntity(SellerDto sellerDto) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(sellerDto, seller);
        return seller;
    }
}