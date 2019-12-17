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

}