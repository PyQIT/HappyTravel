package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

    @Query(value = "select * from guide", nativeQuery = true)
    List<Guide> getAllGuides();
    @Query(value = "select max(id) from guide", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "insert into Guide(id, employeeId) values (:id, :employeeId)", nativeQuery = true)
    int insertGuide(@Param("id") Long id, @Param("employeeId") Long employeeId);
    @Query(value = "select g.id from person p, employee e, guide g where p.userID = :uID and e.personID = p.id and e.id = g.employeeID", nativeQuery = true)
    Long getGuideIdByUserId(@Param("uID") Long uID);
    @Query(value = "select g.* from Guide g, GuideTravel gt, Travel t where t.id = :tID and t.id = gt.travelID and gt.guideID = g.id", nativeQuery = true)
    List<Guide> getGuidesOnTravel(@Param("tID")Long tID);

}