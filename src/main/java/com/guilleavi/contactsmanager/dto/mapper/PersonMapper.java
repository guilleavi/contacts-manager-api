package com.guilleavi.contactsmanager.dto.mapper;

import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.model.Person;
import org.modelmapper.ModelMapper;

public class PersonMapper {

    public static PersonDTO toPersonDto(Person person) {
        return new ModelMapper().map(person, PersonDTO.class);
    }
}
