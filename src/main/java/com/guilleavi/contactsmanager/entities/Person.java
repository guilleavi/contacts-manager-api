package com.guilleavi.contactsmanager.entities;

import com.guilleavi.contactsmanager.enums.PersonCategory;
import com.guilleavi.contactsmanager.enums.PersonStatus;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Document("Person")
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 2078894547217940867L;

    @Id
    private final @Min(value = 1) BigInteger id;

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
     * @return new person with basic data
     */
    public static Person basicData(BigInteger id, String name) {
        return new Person(
                id, name, null, PersonStatus.ACTIVE.name(),
                new HashSet<>(Collections.singletonList(PersonCategory.CLIENT.name())),
                null, null, null
        );
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getTaxIdentifier() {
        return taxIdentifier;
    }

    public String getStatus() {
        return status;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public Set<Map<String, String>> getPhones() {
        return phones;
    }

    public Set<Map<String, String>> getEmails() {
        return emails;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }
}
