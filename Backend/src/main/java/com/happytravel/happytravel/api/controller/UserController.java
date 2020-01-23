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
    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final ManagerService managerService;
    private final GuideService guideService;
    private final SellerService sellerService;

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
        } else result = 0;
        return "{\"result\":" + result + ", \"user\":" + user.toString() + "}";
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
    @GetMapping("/signEmployee")
    public String signNewEmployee(@RequestParam Long loggedUser, @RequestParam String name, @RequestParam String lastName, @RequestParam String email, @RequestParam Long pesel, @RequestParam String phoneNumber, @RequestParam String type, @RequestParam Long salary, @RequestParam Long officeID){
        if(!isManager(loggedUser)) return "-1";
        else if(personService.getPersonByEmail(email) != null) return "-2";
        else {
            Long userid = userService.getMaxId() + 1;
            int result = 0;
            String login = type + userid;
            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            String pass = "";
            Random rand = new Random();
            for(int i=0;i<8;i++){
                pass+=alphabet.charAt(rand.nextInt(alphabet.length()));
            }
            result = userService.signUp(userid, login, pass, type);
            if (result == 0) return "-3";
            Long personId = personService.getMaxId() + 1;
            result = personService.insertPerson(personId, email, name, pesel, phoneNumber, lastName, userid);
            if (result == 0) return "-4";
            Long employeeId = employeeService.getMaxId()+1;
            result = employeeService.insertEmployee(employeeId, null, new Date(), type, salary, officeID, personId);
            if (result == 0) return "-5";
            if (type.equals("Kierownik")){
                Long managerId = managerService.getMaxId()+1;
                result = managerService.insertManager(managerId, employeeId);
                if(result == 0) return "-6";
            }
            else if (type.equals("Przewodnik")){
                Long guideId = guideService.getMaxId()+1;
                result = guideService.insertGuide(guideId, employeeId);
                if(result == 0) return "-7";
            }
            else if (type.equals("Sprzedawca")){
                Long sellerId = sellerService.getMaxId()+1;
                result = sellerService.insertSeller(sellerId, employeeId);
                if(result == 0) return "-8";
            }
            User user = userService.getUserByID(userid);
            if(user == null) return "-9";
            return "{\"user\":" + user.toString() + "}";
        }
        }
    @GetMapping("/isManager")
    public boolean isManager(@RequestParam Long user_ID){
        if(userService.getManagerID(user_ID)==null) return false;
        else return true;
    }
}