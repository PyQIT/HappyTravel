package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.ManagerDto;
import com.happytravel.happytravel.api.model.Manager;
import com.happytravel.happytravel.api.model.User;
import com.happytravel.happytravel.api.service.ManagerService;
import com.happytravel.happytravel.api.service.*;
import com.happytravel.happytravel.api.transformer.ManagerTransformer;
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
public class ManagerController {
    private final ManagerService managerService;
    private final UserService userService;
    private final PersonService personService;
    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final GuideService guideService;
    private final SellerService sellerService;

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDto> getManagers() {
        List<Manager> manager = managerService.getManagers();
        return manager.stream().map(ManagerTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/fireEmployee")
    public int fireEmployee(@RequestParam Long loggedUser, @RequestParam Long employeeID) {
        if (!isManager(loggedUser)) return -2;
        else {
            int result = managerService.fireEmployee(employeeID, new Date());
            return result;
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
            return user.toString();
        }
    }
    @GetMapping("/isManager")
    public boolean isManager(@RequestParam Long user_ID){
        if(managerService.getManagerID(user_ID)==null) return false;
        else return true;
    }
    @GetMapping("/updateSalary")
    public int updateSalary(@RequestParam Long loggedUser, @RequestParam Long salary, @RequestParam Long employeeID){
        if(!isManager(loggedUser)) return -1;
        else {
            managerService.updateSalary(salary, employeeID);
            return 0;
        }
    }
    @GetMapping("/updateOffice")
    public int updateOffice(@RequestParam Long loggedUser, @RequestParam Long officeID, @RequestParam Long employeeID){
        if(!isManager(loggedUser)) return -1;
        else {
            managerService.updateOffice(officeID, employeeID);
            return 0;
        }
    }
    @GetMapping("/updatePosition")
    public int updatePosition(@RequestParam Long loggedUser, @RequestParam String position, @RequestParam Long employeeID){
        if(!isManager(loggedUser)) return -1;
        else {
            managerService.updatePosition(position, employeeID);
            return 0;
        }
    }

}