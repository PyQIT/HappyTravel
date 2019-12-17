package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Person;
import com.happytravel.happytravel.api.repository.PersonRepository;
import com.happytravel.happytravel.api.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getPersons(){
        return personRepository.getAllPersons();
    }

}