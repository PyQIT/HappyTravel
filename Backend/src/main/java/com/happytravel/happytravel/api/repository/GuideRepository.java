package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

    @Query(value = "select * from guide", nativeQuery = true)
    List<Guide> getAllGuides();

}