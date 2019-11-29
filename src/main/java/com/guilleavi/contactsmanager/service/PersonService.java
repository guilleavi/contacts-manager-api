package com.guilleavi.contactsmanager.service;

import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.model.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;

/**
 * Service responsible for People Management
 */
public interface PersonService {

    /**
     * Returns list of all clients, providers, banks and other
     * @return list of people
     */
    List<PersonDTO> getPeople();

    /**
     * Add a new person
     * @return new person
     */
    Person addPerson(@PathVariable("personId") BigInteger personId);
}
