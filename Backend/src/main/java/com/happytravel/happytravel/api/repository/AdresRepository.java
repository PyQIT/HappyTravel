package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface AdresRepository extends JpaRepository<Adres, Long> {

    @Query(value = "select * from adres", nativeQuery = true)
    List<Adres> getAllAdress();
    @Query(value = "SELECT * FROM adres where country = :country", nativeQuery = true)
    List<Adres> getAdressByCountry(@Param("country") String country);
}