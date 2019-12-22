package com.guilleavi.contactsmanager.controller.v1;

import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;

@Controller
@Api(value="Language API")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully operation"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
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
    @ApiOperation(value = "View a list of people")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    List<PersonDTO> getPeople() {
        return personService.getPeople();
    }

    /**
     * Returns list of all clients, providers, banks and other
     *
     * @param personId person to add id
     * @return new person
     */
    @ApiOperation(value = "Add a new person")
    @RequestMapping(value = "/{personId}", method = RequestMethod.POST)
    @ResponseBody
    PersonDTO addPerson(@PathVariable("personId") BigInteger personId) {
        return personService.addPerson(personId);
    }
}
