package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {

    List<PaymentMethod> getPaymentMethods();

}