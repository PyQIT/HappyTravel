package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user", nativeQuery = true)
    List<User> getAllUsers();

}