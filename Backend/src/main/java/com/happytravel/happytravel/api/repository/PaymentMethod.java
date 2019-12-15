package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.PaymenMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymenMethodRepository extends JpaRepository<PaymenMethod, Long> {

    @Query(value = "select * from paymenMethod", nativeQuery = true)
    List<PaymenMethod> getAllPaymenMethods();

}