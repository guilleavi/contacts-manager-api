package com.guilleavi.contactsmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guilleavi.contactsmanager.model.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PersonDTO {

    private BigInteger id;

    private String name;

    private Map<String, String> taxIdentifier;

    private String status;

    private Set<String> categories;

    private Set<Map<String, String>> phones;

    private Set<Map<String, String>> emails;

    private Set<Address> addresses;

}
