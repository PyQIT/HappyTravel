package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.User;
import com.happytravel.happytravel.api.repository.UserRepository;
import com.happytravel.happytravel.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        return userRepository.getAllUsers();
    }
    @Override
    public User logIn(String login, String pass) {return userRepository.logIn(login, pass);}
    @Override
    public User checkLogins(String login) {return userRepository.checkLogins(login);}
    @Override
    public Long getMaxId() {return userRepository.getMaxId();}
    @Override
    public int signUp(Long id, String login, String pass, String stanowisko) {
        return userRepository.signUp(id, login, pass, stanowisko);
    }
}