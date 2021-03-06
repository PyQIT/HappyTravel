package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.User;
import com.happytravel.happytravel.api.model.Manager;
import com.happytravel.happytravel.api.model.Person;
import com.happytravel.happytravel.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user", nativeQuery = true)
    List<User> getAllUsers();
    @Query(value = "select * from user where id = :userID", nativeQuery = true)
    User getUserByID(@Param("userID") Long userID);
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
    @Query(value = "select usertype from user where login = :login", nativeQuery = true)
    String getUserType(@Param("login") String login);
    @Query(value = "select id from user where login = :login", nativeQuery=true)
    Long getUserIdByLogin(@Param("login") String login);
    @Query(value = "select User.id from User, Employee, Person where Employee.id = :eID and Employee.PersonID = Person.id and Person.userID = user.id", nativeQuery = true)
    Long getUserIDByEmployeeID(@Param("eID") Long eID);
    @Modifying
    @Transactional
    @Query(value = "update User set usertype = :type where id = :uID", nativeQuery = true)
    int updateType(@Param("type") String type, @Param("uID") Long uID);
    @Query(value = "Select id from User where id = :uID and password = :pass", nativeQuery = true)
    Long checkPassword(@Param("uID") Long uID, @Param("pass") String pass);
    @Modifying
    @Transactional
    @Query(value = "update User set password = :pass where id = :uID", nativeQuery = true)
    int changePass(@Param("pass") String pass, @Param("uID") Long uID);
    @Query(value = "select c.id from Client c, Person p where p.userID = :uID and p.id = c.personID", nativeQuery = true)
    Long getClientIdByUserId(@Param("uID") Long uID);
}