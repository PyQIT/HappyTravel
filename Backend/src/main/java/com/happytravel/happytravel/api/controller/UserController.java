package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.UserDto;
import com.happytravel.happytravel.api.model.User;
import com.happytravel.happytravel.api.service.*;
import com.happytravel.happytravel.api.transformer.UserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.Date;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class UserController {

    private final UserService userService;
    private final PersonService personService;
    private final ClientService clientService;
    private final EmployeeService employeeService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers() {
        List<User> user = userService.getUsers();
        return user.stream().map(UserTransformer::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/signin")
    public String logIn(@RequestParam String login, @RequestParam String pass) {
        User user = userService.logIn(login, pass);
        int result;
        if (user == null) {
            result = -1;
            return "{\"result\":" + result + ", \"user\": null}";
        }
        if(!userService.getUserType(login).equals("Klient")){
            //return "Sprawdzam date";
            if(employeeService.getFiringDateByUserID(userService.getUserIdByLogin(login))!=null){
                result = -1;
                return "Zwolniony";
                //return "{\"result\":" + result + ", \"user\": null}";
            }
        }
        result = 0;
        return "{\"result\":" + result + ", \"user\":" + user.toString() + "}";
        //result = -1;
        //return "aaa";
        //return "{\"result\":" + result + ", \"user\": null}";
    }

    @GetMapping("/signup")
    public int signNewClient(@RequestParam String login, @RequestParam String pass, @RequestParam String name, @RequestParam String lastName, @RequestParam String email, @RequestParam Long pesel, @RequestParam String phoneNumber) {
        if (userService.checkLogins(login) != null) return -1;
        else if(personService.getPersonByEmail(email) != null) return -2;
        else {
            Long userid = userService.getMaxId() + 1;
            int result = 0;
            result = userService.signUp(userid, login, pass, "Klient");
            if (result == 0) return -3;
            Long personId = personService.getMaxId() + 1;
            result = personService.insertPerson(personId, email, name, pesel, phoneNumber, lastName, userid);
            if (result == 0) return -3;
            Long id = clientService.getMaxId() + 1;
            result = clientService.insertClient(id, personId);
            if (result == 0) return -3;
            return 0;
        }
    }

}