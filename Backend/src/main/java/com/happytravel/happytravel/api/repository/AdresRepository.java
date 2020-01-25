package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AdresRepository extends JpaRepository<Adres, Long> {

    @Query(value = "select * from adres", nativeQuery = true)
    List<Adres> getAllAdress();
    @Query(value = "SELECT * FROM adres where country = :country", nativeQuery = true)
    List<Adres> getAdressByCountry(@Param("country") String country);
    @Modifying
    @Transactional
    @Query(value = "Insert into Adres(id, apartmentnr, city, country, housenr, street) values(:id, :aNR, :city, :country, :hNR, :street)", nativeQuery = true)
    int addAdress(@Param("id") Long id, @Param("aNR") String aNR, @Param("city") String city, @Param("country") String country, @Param("hNR") String hNR, @Param("street") String street);
    @Query(value = "Select max(id) from Adres")
    Long getMaxId();
}