package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(value = "select * from hotel", nativeQuery = true)
    List<Hotel> getAllHotels();
    @Query(value = "select max(id) from hotel", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "insert into hotel(id, hotelname, adresid) values(:id, :hName, :aID)", nativeQuery = true)
    int addHotel(@Param("id")Long id, @Param("hName") String hName, @Param("aID") Long aID);

}