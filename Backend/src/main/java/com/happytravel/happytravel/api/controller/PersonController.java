package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.PersonDto;
import com.happytravel.happytravel.api.model.Person;
import com.happytravel.happytravel.api.service.PersonService;
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

    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getPersons() {
        List<Person> person = personService.getPersons();
        return person.stream().map(PersonTransformer::convertToDto).collect(Collectors.toList());
    }
}