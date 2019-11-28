package com.guilleavi.contactsmanager.entities;

        import lombok.RequiredArgsConstructor;

        import java.io.Serializable;

@RequiredArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 4768291624807231582L;

    private final Long id;
    private final String description;
    private final String street;
    private final String city;
    private final String county;
    private final String state;
    private final String country;
}
