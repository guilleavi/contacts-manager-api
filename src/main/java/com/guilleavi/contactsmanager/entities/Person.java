package com.guilleavi.contactsmanager.entities;

import com.guilleavi.contactsmanager.enums.PersonCategory;
import com.guilleavi.contactsmanager.enums.PersonStatus;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Person implements Serializable {

    private final @Id @Min(value=1) Long id;

    private final @NotBlank String name;

    private final Map<String, String> taxIdentifier;
    
    private final @NotBlank String status;

    private final @NotEmpty Set<String> categories;

    private final Set<Map<@NotEmpty String, String>> phones;

    private final Set<Map<@Email String, String>> emails;

    private final Set<Address> addresses;

    /**
     * Set only the basic data, the status will be set as Active by default and the category as Client
     *
     * @param id   person id
     * @param name person name
     * @return
     */
    static Person basicData(Long id,
                            String name) {
        return new Person(id, name, null, null, null, null, null, null);
    }

    /**
     * Set only basic and contact data, the status will be set as Active by default
     *
     * @param id         person id
     * @param name       person name
     * @param categories person category: provider, client, bank, other. By default: client
     * @param phones     list of phones with its description
     * @param emails     list of emails with its description
     * @param addresses  list of addresses with its description
     * @return
     */
    static Person contactData(Long id,
                              String name,
                              Set<String> categories,
                              Set<Map<String, String>> phones,
                              Set<Map<String, String>> emails,
                              Set<Address> addresses) {

        return new Person(id, name, null, null, categories, phones, emails, addresses);
    }

    /**
     * Set all the person data
     *
     * @param id            person id
     * @param name          person name
     * @param taxIdentifier tax identifier information: type and number
     * @param status        person status: active, inactive. By default: active.
     * @param categories    person category: provider, client, bank. By default: client
     * @param phones        list of phones with its description
     * @param emails        list of emails with its description
     * @param addresses     list of addresses with its description
     * @return
     */
    static Person fullData(Long id,
                           String name,
                           Map<String, String> taxIdentifier,
                           String status,
                           Set<String> categories,
                           Set<Map<String, String>> phones,
                           Set<Map<String, String>> emails,
                           Set<Address> addresses) {

        return new Person(id, name, taxIdentifier, status, categories, phones, emails, addresses);
    }

    private Person(Long id,
                   String name,
                   Map<String, String> taxIdentifier,
                   String status,
                   Set<String> categories,
                   Set<Map<String, String>> phones,
                   Set<Map<String, String>> emails,
                   Set<Address> addresses) {
        String defaultStatus = PersonStatus.ACTIVE.name(); // TODO: parameterize this
        Set<String> defaultCategory = new HashSet<>(Arrays.asList(PersonCategory.CLIENT.name())); // TODO: parameterize this

        this.id = id;
        this.name = name;
        this.taxIdentifier = taxIdentifier;
        this.status = null != status ? status : defaultStatus;
        this.categories = null != categories && !categories.isEmpty() ? categories : defaultCategory;
        this.phones = phones;
        this.emails = emails;
        this.addresses = addresses;
    }
}
