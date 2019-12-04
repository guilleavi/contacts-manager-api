package com.guilleavi.contactsmanager.controller.v1;

import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.model.Person;
import com.guilleavi.contactsmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Returns list of all clients, providers, banks and other
     *
     * @return list of people
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    List<PersonDTO> getPeople() {
        return personService.getPeople();
    }

    /**
     * Returns list of all clients, providers, banks and other
     *
     * @param personId person to add id
     * @return list of people
     */
    @RequestMapping(value = "/{personId}", method = RequestMethod.POST)
    @ResponseBody
    PersonDTO addPerson(@PathVariable("personId") BigInteger personId) {
        return personService.addPerson(personId);
    }
}
