package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.PersonDto;
import com.happytravel.happytravel.api.model.Person;
import com.happytravel.happytravel.api.service.PersonService;
import com.happytravel.happytravel.api.service.UserService;
import com.happytravel.happytravel.api.transformer.PersonTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class PersonController {

    private final PersonService personService;
    private final UserService userService;

    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getPersons() {
        List<Person> person = personService.getPersons();
        return person.stream().map(PersonTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/getPersonByUserID")
    public PersonDto getPersonByUserID(@RequestParam Long userID){
        return PersonTransformer.convertToDto(personService.getPersonByUserID(userID));
    }
    @GetMapping("/changeMail")
    public int changeMail(@RequestParam String pass, @RequestParam String newMail, @RequestParam Long loggedUser){
        if(userService.checkPassword(loggedUser, pass) == null) return -1;
        else{
            Person person = personService.getPersonByUserID(loggedUser);
            return personService.changeMail(newMail, person.getID());
        }
    }
}