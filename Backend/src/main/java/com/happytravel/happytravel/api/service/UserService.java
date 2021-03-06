package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.User;
import com.happytravel.happytravel.api.model.Manager;
import java.util.List;

public interface UserService {

    List<User> getUsers();
    User logIn(String login, String pass);
    User checkLogins(String login);
    Long getMaxId();
    int signUp(Long id, String login, String pass, String stanowisko);
    User getUserByID(Long userID);
    String getUserType(String login);
    Long getUserIdByLogin(String login);
    int updateType(String type, Long employeeID);
    Long getUserIDByEmployeeID(Long eID);
    Long checkPassword(Long uID, String pass);
    int changePass(String pass, Long uID);
    Long getClientIdByUserId(Long uID);
}