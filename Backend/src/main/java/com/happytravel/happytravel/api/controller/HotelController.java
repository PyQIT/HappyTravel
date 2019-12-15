package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.HotelDto;
import com.happytravel.happytravel.api.model.Hotel;
import com.happytravel.happytravel.api.service.HotelService;
import com.happytravel.happytravel.api.transformer.HotelTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/hotels")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelDto> getHotels() {
        List<Hotel> hotel = hotelService.getHotels();
        return hotel.stream().map(HotelTransformer::convertToDto).collect(Collectors.toList());
    }
}