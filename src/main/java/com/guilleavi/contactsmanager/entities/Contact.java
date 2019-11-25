package com.guilleavi.contactsmanager.entities;

import org.springframework.data.annotation.Id;

//@Entity
public class Contact {

    private final @Id Long id;
    private final String firstName;
    private final String lastName;

    public Contact(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact withId(Long id) {
        return new Contact(id, this.firstName, this.lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
