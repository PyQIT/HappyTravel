package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User logIn(String login, String pass);
    User checkLogins(String login);
    Long getMaxId();
    int signUp(Long id, String login, String pass, String stanowisko);
}