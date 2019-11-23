package com.guilleavi.contactsmanager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guilleavi.contactsmanager.entities.Contact;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactController {

    @RequestMapping("/contacts")
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "John", "Doe"));
        return contacts;
    }
}
