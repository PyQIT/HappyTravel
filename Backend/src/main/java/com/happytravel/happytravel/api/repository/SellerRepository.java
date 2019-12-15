package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query(value = "select * from seller", nativeQuery = true)
    List<Seller> getAllSellers();

}