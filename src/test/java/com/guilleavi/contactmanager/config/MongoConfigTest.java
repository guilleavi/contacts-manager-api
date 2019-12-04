package com.guilleavi.contactmanager.config;

import com.guilleavi.contactmanager.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MongoConfigTest extends AbstractTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void MongoTemplateConfigTest() {
        assertEquals("contacts-manager", mongoTemplate.getDb().getName(), "Database name should match");
    }

}
