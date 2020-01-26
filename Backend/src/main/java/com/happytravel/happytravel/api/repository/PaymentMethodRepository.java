package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Query(value = "select * from paymenMethod", nativeQuery = true)
    List<PaymentMethod> getAllPaymenMethods();
    @Modifying
    @Transactional
    @Query(value = "insert into paymentMethod(id, cardcode, cardnr, expires, clientid) values(:id, :cardCode, :cardNr, :expires, :clientID)", nativeQuery = true)
    int addPaymentMethod(@Param("id") Long id, @Param("cardCode") String cardCode, @Param("cardNr") Long cardNr, @Param("expires") Date expires, @Param("clientID") Long clienID);
    @Query(value = "select max(id) from paymentMethod", nativeQuery = true)
    Long getMaxId();
}