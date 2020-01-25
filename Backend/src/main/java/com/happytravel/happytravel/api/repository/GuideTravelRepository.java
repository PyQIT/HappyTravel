package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.GuideTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GuideTravelRepository extends JpaRepository<GuideTravel, Long> {

    @Query(value = "select * from guidetravel", nativeQuery = true)
    List<GuideTravel> getAllGuideTravels();
    @Query(value = "select max(id) from guidetravel", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "insert into guidetravel(id, guideid, travelid) values(:id, :guideID, :travelID)", nativeQuery = true)
    int addGuideToTravel(@Param("id") Long id, @Param("guideID") Long guideID, @Param("travelID") Long travelID);

}