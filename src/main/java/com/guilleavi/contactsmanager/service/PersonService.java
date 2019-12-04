package com.guilleavi.contactsmanager.service;

import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.model.Person;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;
import java.util.List;

/**
 * Service responsible for People Management
 */
public interface PersonService {

    /**
     * Returns list of all clients, providers, banks and other
     *
     * @return list of people
     */
    List<PersonDTO> getPeople();

    /**
     * Returns list of all clients, providers, banks and other
     *
     * @param personId person to add id
     * @return list of people
     */
    PersonDTO addPerson(BigInteger personId);
}
