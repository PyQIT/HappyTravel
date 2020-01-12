package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user", nativeQuery = true)
    List<User> getAllUsers();
    @Query(value = "select * from user where login = :login and password = :pass", nativeQuery = true)
    User logIn(@Param("login") String login, @Param("pass") String pass);
    @Query(value = "select * from user where login = :login", nativeQuery = true)
    User checkLogins(@Param("login") String login);
    @Query(value = "select max(id) from user", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "insert into User (id, login, password, usertype) values(:id, :login, :pass, :stanowisko)", nativeQuery = true)
    int signUp(@Param("id") Long id, @Param("login") String login, @Param("pass") String pass, @Param("stanowisko") String stanowisko);
}