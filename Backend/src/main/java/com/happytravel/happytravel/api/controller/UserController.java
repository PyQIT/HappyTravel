package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.UserDto;
import com.happytravel.happytravel.api.model.User;
import com.happytravel.happytravel.api.service.UserService;
import com.happytravel.happytravel.api.transformer.UserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers() {
        List<User> user = userService.getUsers();
        return user.stream().map(UserTransformer::convertToDto).collect(Collectors.toList());
    }
}