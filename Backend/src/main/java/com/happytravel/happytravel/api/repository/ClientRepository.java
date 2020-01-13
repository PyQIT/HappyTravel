package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select * from client", nativeQuery = true)
    List<Client> getAllClients();
    @Query(value = "select max(id) from client", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "insert into Client (id, personId) values (:id, :personId)", nativeQuery = true)
    int insertClient(@Param("id") Long id, @Param("personId") Long personid);
}