package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Query(value = "select * from paymenMethod", nativeQuery = true)
    List<PaymentMethod> getAllPaymenMethods();

}