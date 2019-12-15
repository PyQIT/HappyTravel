package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.PaymenMethod;

import java.util.List;

public interface PaymenMethodService {

    List<PaymenMethod> getPaymenMethods();

}