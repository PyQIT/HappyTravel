package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select * from client", nativeQuery = true)
    List<Client> getAllClients();

}