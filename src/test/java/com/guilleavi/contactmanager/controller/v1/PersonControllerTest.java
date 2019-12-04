package com.guilleavi.contactmanager.controller.v1;

import com.guilleavi.contactmanager.AbstractTest;
import com.guilleavi.contactsmanager.controller.v1.PersonController;
import com.guilleavi.contactsmanager.dto.PersonDTO;
import com.guilleavi.contactsmanager.dto.mapper.PersonMapper;
import com.guilleavi.contactsmanager.model.Person;
import com.guilleavi.contactsmanager.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import util.MediaTypeTestUtil;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class PersonControllerTest extends AbstractTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personServiceMock;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    public void getPeopleTest() throws Exception {
        Person person1 = Person.basicData(BigInteger.ONE, "John Doe");
        Person person2 = Person.basicData(BigInteger.TWO, "Jane Doe");
        List<Person> personList = Arrays.asList(person1, person2);
        List<PersonDTO> personListDto = personList.stream().map(PersonMapper::toPersonDto)
                .collect(Collectors.toList());

        when(personServiceMock.getPeople()).thenAnswer(answer -> personListDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/person"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaTypeTestUtil.APPLICATION_JSON_UTF8)).andReturn();

        verify(personServiceMock, times(1)).getPeople();
        verifyNoMoreInteractions(personServiceMock);
    }

    @Test
    public void addPersonTest() throws Exception {
        BigInteger personId = BigInteger.ONE;
        Person person = Person.basicData(personId, "John Doe");
        PersonDTO personDTO = PersonMapper.toPersonDto(person);

        when(personServiceMock.addPerson(personId)).thenAnswer(answer -> personDTO);

        mockMvc.perform(MockMvcRequestBuilders.post(String.format("/person/%s", personId)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaTypeTestUtil.APPLICATION_JSON_UTF8)).andReturn();

        verify(personServiceMock, times(1)).addPerson(personId);
        verifyNoMoreInteractions(personServiceMock);
    }
}
