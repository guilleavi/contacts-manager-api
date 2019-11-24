package com.guilleavi.contactsmanager.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.guilleavi.contactsmanager.entities.Contact;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Service responsible for Contacts Management
 */
@RequestMapping("/contacts")
public interface ContactService {

    /**
     * Returns list of all the contacts
     * @return list of contacts
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    List<Contact> getContacts();

    /**
     * Add a new contact
     * @return new contact
     */
    @RequestMapping(value = "/{contactId}", method = RequestMethod.POST)
    @ResponseBody
    Contact addContact(@PathVariable("contactId") Long contactId);
}
