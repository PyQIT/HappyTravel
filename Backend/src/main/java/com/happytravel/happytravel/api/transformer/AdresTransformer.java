package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.AdresDto;
import com.happytravel.happytravel.api.model.Adres;
import org.springframework.beans.BeanUtils;

public class AdresTransformer {

    public static AdresDto convertToDto(Adres adres) {
        AdresDto adresDto = new AdresDto();
        BeanUtils.copyProperties(adres, adresDto);
        return adresDto;
    }

    public static Adres convertToEntity(AdresDto adresDto) {
        Adres adres = new Adres();
        BeanUtils.copyProperties(adresDto, adres);
        return adres;
    }
}