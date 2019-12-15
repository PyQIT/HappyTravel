package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.PaymenMethod;
import com.happytravel.happytravel.api.repository.PaymenMethodRepository;
import com.happytravel.happytravel.api.service.PaymenMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymenMethodServiceImpl implements PaymenMethodService {

    private final PaymenMethodRepository paymenMethodRepository;

    @Override
    public List<PaymenMethod> getPaymenMethods(){
        return paymenMethodRepository.getAllPaymenMethods();
    }

}