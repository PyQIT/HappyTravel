package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.PaymentMethodDto;
import com.happytravel.happytravel.api.model.PaymentMethod;
import com.happytravel.happytravel.api.service.PaymentMethodService;
import com.happytravel.happytravel.api.transformer.PaymentMethodTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

import java.text.SimpleDateFormat;
import java.text.ParseException;

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
    @GetMapping("/addPaymentMethod")
    public int addPaymentMethod(@RequestParam String cardCode, @RequestParam Long cardNr, @RequestParam String expires, @RequestParam Long loggedUser){
        Long id = paymentMethodService.getMaxId()+1;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date expirationDate = formatter.parse(expires);
            Date date = new Date();
            if(expirationDate.before(date)) return -1;
            else return paymentMethodService.addPaymentMethod(id, cardCode, cardNr, expirationDate, loggedUser);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return -1;
    }
}