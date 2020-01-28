package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.User;
import com.happytravel.happytravel.api.model.Manager;
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

    public User getUserByID(Long userID) {
        return userRepository.getUserByID(userID);
    }
    public String getUserType(String login){
        return userRepository.getUserType(login);
    }
    public Long getUserIdByLogin(String login){
        return userRepository.getUserIdByLogin(login);
    }
    public int updateType(String type, Long eID) {
        return userRepository.updateType(type, eID);
    }
    public Long getUserIDByEmployeeID(Long eID){
        return userRepository.getUserIDByEmployeeID(eID);
    }
    public Long checkPassword(Long uID, String pass){
        return userRepository.checkPassword(uID, pass);
    }
    public int changePass(String pass, Long uID){
        return userRepository.changePass(pass, uID);
    }
    public Long getClientIdByUserId(Long uID){
        return userRepository.getClientIdByUserId(uID);
    }
}