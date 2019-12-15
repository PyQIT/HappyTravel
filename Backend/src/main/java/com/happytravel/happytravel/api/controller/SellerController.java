package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.SellerDto;
import com.happytravel.happytravel.api.model.Seller;
import com.happytravel.happytravel.api.service.SellerService;
import com.happytravel.happytravel.api.transformer.SellerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/sellers")
    @ResponseStatus(HttpStatus.OK)
    public List<SellerDto> getSellers() {
        List<Seller> seller = sellerService.getSellers();
        return seller.stream().map(SellerTransformer::convertToDto).collect(Collectors.toList());
    }
}