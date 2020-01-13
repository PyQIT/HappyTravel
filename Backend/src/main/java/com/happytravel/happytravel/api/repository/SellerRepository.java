package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query(value = "select * from seller", nativeQuery = true)
    List<Seller> getAllSellers();
    @Query(value = "select max(id) from seller", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "insert into seller (id, employeeId) values (:id, :employeeId)", nativeQuery = true)
    int insertSeller(@Param("id") Long id, @Param("employeeId") Long employeeId);

}