package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Adres;

import java.util.List;

public interface AdresService {
    List<Adres> getAdressByCountry(String country);
    List<Adres> getAdress();

}