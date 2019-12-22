package com.guilleavi.contactsmanager.service;

import com.guilleavi.contactsmanager.dto.PersonDTO;

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
     * @return  new person
     */
    PersonDTO addPerson(BigInteger personId);
}
