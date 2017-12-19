package com.joseroberts.rpiproject.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration

@EnableMongoRepositories(basePackages = "com.joseroberts.rpiproject.models.data")
public class MongoConfig extends AbstractMongoConfiguration{

    @Override
    protected String getDatabaseName() {
        return "rpirepo";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.joseroberts.rpiproject";
    }

//    @Override
//    public MongoTemplate mongoTemplate() throws Exception{
//        return new MongoTemplate((mongo(), "database" , "JR");
//    }
}
