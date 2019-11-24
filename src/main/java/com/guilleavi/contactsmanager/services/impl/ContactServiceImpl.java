package com.guilleavi.contactsmanager.services.impl;

import com.guilleavi.contactsmanager.entities.Contact;
import com.guilleavi.contactsmanager.repositories.ContactRepository;
import com.guilleavi.contactsmanager.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsible for Contacts Management
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

    @Override
    public Contact addContact(Long contactId) {
        Contact contact = new Contact(contactId, "John " + contactId, "Doe");
        return contactRepository.insert(contact);
    }
}
