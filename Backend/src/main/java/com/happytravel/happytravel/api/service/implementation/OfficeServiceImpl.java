package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Office;
import com.happytravel.happytravel.api.repository.OfficeRepository;
import com.happytravel.happytravel.api.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Override
    public List<Office> getOffice(){
        return officeRepository.getAllOffices();
    }

}