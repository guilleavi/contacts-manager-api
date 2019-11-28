package com.guilleavi.contactsmanager.services;

import com.guilleavi.contactsmanager.entities.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;

/**
 * Service responsible for People Management
 */
@RequestMapping("/people")
public interface PeopleService {

    /**
     * Returns list of all clients, providers, banks and other
     * @return list of people
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    List<Person> getPeople();

    /**
     * Add a new person
     * @return new person
     */
    @RequestMapping(value = "/{personId}", method = RequestMethod.POST)
    @ResponseBody
    Person addPerson(@PathVariable("personId") BigInteger personId);
}
