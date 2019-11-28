package com.guilleavi.contactsmanager;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.guilleavi.contactsmanager.repositories")
public class MongoConfig extends AbstractMongoConfiguration  {

    @Override
    public MongoClient mongoClient() {
        return  new MongoClient("localhost", 27017);
    }

    @Override
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), "contacts-manager");
        mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
        return mongoTemplate;
    }

    @Override
    protected String getDatabaseName() {
        return "contacts-manager";
    }
}
