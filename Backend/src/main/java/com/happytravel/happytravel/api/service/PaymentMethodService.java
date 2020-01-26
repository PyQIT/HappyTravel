package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.PaymentMethod;

import java.util.List;
import java.util.Date;

public interface PaymentMethodService {

    List<PaymentMethod> getPaymentMethods();
    int addPaymentMethod( Long id, String cardCode, Long cardNr, Date expires, Long clientID);
    Long getMaxId();
}