package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersons();
    Long getMaxId();
    int insertPerson(Long id, String email, String name, Long pesel, String phonenumber, String surname, Long userid);
    Person getPersonByEmail(String email);
}