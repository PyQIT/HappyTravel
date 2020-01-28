package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.AdresDto;
import com.happytravel.happytravel.api.model.Adres;
import com.happytravel.happytravel.api.service.AdresService;
import com.happytravel.happytravel.api.transformer.AdresTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class AdresController {

    private final AdresService adresService;

    @GetMapping("/adress")
    @ResponseStatus(HttpStatus.OK)
    public List<AdresDto> getAdress() {
        List<Adres> adres = adresService.getAdress();
        return adres.stream().map(AdresTransformer::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/adress/adresyWPolsce")
    @ResponseStatus(HttpStatus.OK)
    public List<AdresDto> getAdressByCountry() {
        List<Adres> adres = adresService.getAdressByCountry("Polska");
        return adres.stream().map(AdresTransformer::convertToDto).collect(Collectors.toList());
    }
}