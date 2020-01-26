package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.PaymentMethod;
import com.happytravel.happytravel.api.repository.PaymentMethodRepository;
import com.happytravel.happytravel.api.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethod> getPaymentMethods(){
        return paymentMethodRepository.getAllPaymenMethods();
    }
    @Override
    public int addPaymentMethod(Long id, String cardCode, Long cardNr, Date expires, Long clientID){
        return paymentMethodRepository.addPaymentMethod(id, cardCode, cardNr, expires, clientID);
    }
    public Long getMaxId(){
        return paymentMethodRepository.getMaxId();
    }
}