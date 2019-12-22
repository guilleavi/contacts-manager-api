package com.guilleavi.contactmanager.service.impl;

import com.guilleavi.contactmanager.AbstractTest;
import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.model.Person;
import com.guilleavi.contactsmanager.service.impl.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class PersonServiceImplTest extends AbstractTest {

    @Mock
    private MongoTemplate mongoTemplateMock;

    @InjectMocks
    private PersonServiceImpl personService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPeopleTest() throws Exception {
        Person person1 = Person.basicData(BigInteger.ONE, "John Doe");
        Person person2 = Person.basicData(BigInteger.TWO, "Jane Doe");
        List<Person> personList = Arrays.asList(person1, person2);

        when(mongoTemplateMock.findAll(Person.class)).thenAnswer(answer -> personList);

        List<PersonDTO> personListDTO = personService.getPeople();

        assertEquals(personList.size(), personListDTO.size(), "List size should match");

        verify(mongoTemplateMock, times(1)).findAll(Person.class);
        verifyNoMoreInteractions(mongoTemplateMock);
    }

    @Test
    public void addPersonTest() throws Exception {
        BigInteger personId = BigInteger.ONE;
        String personName = "John " + personId + " Doe";
        Person person = Person.basicData(personId, personName);

        when(mongoTemplateMock.insert(person, "Person")).thenAnswer(answer -> person);

        PersonDTO personDTO = personService.addPerson(personId);

        assertEquals(personId, personDTO.getId(), "Person id should match");
        assertEquals(personName, personDTO.getName(), "Person name should match");

        verify(mongoTemplateMock, times(1)).findAll(Person.class);
        verifyNoMoreInteractions(mongoTemplateMock);
    }

}
