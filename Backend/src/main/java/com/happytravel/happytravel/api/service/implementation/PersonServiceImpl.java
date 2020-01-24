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
    @Override
    public Long getMaxId(){return personRepository.getMaxId();}
    public int insertPerson(Long id, String email, String name, Long pesel, String phonenumber, String surname, Long userid){
        return personRepository.insertPerson(id, email, name, pesel, phonenumber, surname, userid);
    }
    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.getPersonByEmail(email);
    }
    @Override
    public Person getPersonByUserID(Long uID){
        return personRepository.getPersonByUserID(uID);
    }
}