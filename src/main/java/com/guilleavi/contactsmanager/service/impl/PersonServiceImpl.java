package com.guilleavi.contactsmanager.service.impl;

import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.dto.mapper.PersonMapper;
import com.guilleavi.contactsmanager.model.Person;
import com.guilleavi.contactsmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service responsible for People Management
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PersonServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonDTO> getPeople() {
        return mongoTemplate.findAll(Person.class).stream().map(PersonMapper::toPersonDto)
                .collect(Collectors.toList());
}
    @Override
    @Transactional
    public PersonDTO addPerson(BigInteger personId) {
        Person person = Person.basicData(personId, "John " + personId + " Doe");
        return PersonMapper.toPersonDto(mongoTemplate.insert(person, "Person"));
    }
}
