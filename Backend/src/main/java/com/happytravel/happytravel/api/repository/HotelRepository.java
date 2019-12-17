package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(value = "select * from hotel", nativeQuery = true)
    List<Hotel> getAllHotels();

}