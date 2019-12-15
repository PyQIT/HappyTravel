package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.PaymentMethodDto;
import com.happytravel.happytravel.api.model.PaymentMethod;
import org.springframework.beans.BeanUtils;

public class PaymentMethodTransformer {

    public static PaymentMethodDto convertToDto(PaymentMethod paymentMethod) {
        PaymentMethodDto paymentMethodDto = new PaymentMethodDto();
        BeanUtils.copyProperties(paymentMethod, paymentMethodDto);
        return paymentMethodDto;
    }

    public static PaymentMethod convertToEntity(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = new PaymentMethod();
        BeanUtils.copyProperties(paymentMethodDto, paymentMethod);
        return paymentMethod;
    }
}