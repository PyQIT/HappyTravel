package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.PaymentMethodDto;
import com.happytravel.happytravel.api.model.PaymentMethod;
import com.happytravel.happytravel.api.service.PaymentMethodService;
import com.happytravel.happytravel.api.transformer.PaymentMethodTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping("/paymentMethods")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentMethodDto> getPaymentMethods() {
        List<PaymentMethod> paymentMethod = paymentMethodService.getPaymentMethods();
        return paymentMethod.stream().map(PaymentMethodTransformer::convertToDto).collect(Collectors.toList());
    }
}