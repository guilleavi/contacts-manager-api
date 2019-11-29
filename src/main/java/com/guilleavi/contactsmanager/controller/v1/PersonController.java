package com.guilleavi.contactsmanager.controller.v1;

import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.model.Person;
import com.guilleavi.contactsmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    List<PersonDTO> getPeople() {
        return personService.getPeople();
    };

    /**
     * Add a new person
     * @return new person
     */
    @RequestMapping(value = "/{personId}", method = RequestMethod.POST)
    @ResponseBody
    Person addPerson(@PathVariable("personId") BigInteger personId) {
        return personService.addPerson(personId);
    };
}
