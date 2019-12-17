package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.TravelDto;
import com.happytravel.happytravel.api.model.Travel;
import com.happytravel.happytravel.api.service.TravelService;
import com.happytravel.happytravel.api.transformer.TravelTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class TravelController {

    private final TravelService travelService;

    @GetMapping("/travel")
    @ResponseStatus(HttpStatus.OK)
    public List<TravelDto> getTravel() {
        List<Travel> travel = travelService.getTravel();
        return travel.stream().map(TravelTransformer::convertToDto).collect(Collectors.toList());
    }
}