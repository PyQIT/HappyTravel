package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Adres;
import com.happytravel.happytravel.api.repository.AdresRepository;
import com.happytravel.happytravel.api.service.AdresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdresServiceImpl implements AdresService {

    private final AdresRepository adresRepository;

    @Override
    public List<Adres> getAdress(){
        return adresRepository.getAllAdress();
    }
    @Override
    public List<Adres> getAdressByCountry(String country){
        return adresRepository.getAdressByCountry(country);
    }

}