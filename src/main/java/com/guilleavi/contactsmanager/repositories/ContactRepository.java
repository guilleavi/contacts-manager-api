package com.guilleavi.contactsmanager.repositories;

import com.guilleavi.contactsmanager.entities.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, Long> {
}
