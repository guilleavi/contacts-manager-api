package com.guilleavi.contactsmanager.services.impl;

import com.guilleavi.contactsmanager.entities.Person;
import com.guilleavi.contactsmanager.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Service responsible for People Management
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PeopleServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Person> getPeople() {
        return mongoTemplate.findAll(Person.class);
}

    @Override
    public Person addPerson(BigInteger personId) {
        Person person = Person.basicData(personId, "John " + personId + " Doe");
        return mongoTemplate.insert(person, "Person");
    }
}
