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
    Long getManagerID(Long user_ID);
    User getUserByID(Long userID);
}