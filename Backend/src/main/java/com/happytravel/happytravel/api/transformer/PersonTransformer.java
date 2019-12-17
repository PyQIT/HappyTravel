package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.PersonDto;
import com.happytravel.happytravel.api.model.Person;
import org.springframework.beans.BeanUtils;

public class PersonTransformer {

    public static PersonDto convertToDto(Person person) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(person, personDto);
        return personDto;
    }

    public static Person convertToEntity(PersonDto personDto) {
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        return person;
    }
}