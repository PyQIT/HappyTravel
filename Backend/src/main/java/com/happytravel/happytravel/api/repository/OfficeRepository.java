package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{
	
	@Query(value = "select * from office", nativeQuery = true)
	List<Office> getAllOffices();
}