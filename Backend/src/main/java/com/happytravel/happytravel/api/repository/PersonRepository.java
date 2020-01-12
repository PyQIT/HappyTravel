package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select * from person", nativeQuery = true)
    List<Person> getAllPersons();
    @Query(value = "select max(id) from person", nativeQuery=true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "insert into Person(id, email, name, pesel, phonenumber, surname, userid) values (:id, :email, :name, :pesel, :phonenumber, :surname, :userid)", nativeQuery=true)
    int insertPerson(@Param("id") Long id, @Param("email") String email, @Param("name") String name, @Param("pesel") Long pesel, @Param("phonenumber") String phonenumber, @Param("surname") String surname, @Param("userid") Long userid);
}