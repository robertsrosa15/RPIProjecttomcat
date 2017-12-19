package com.joseroberts.rpiproject;

import com.joseroberts.rpiproject.config.MongoConfig;
import com.joseroberts.rpiproject.models.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class App {

    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

        Users user = new Users("Isaac", "password");
        mongoOperation.save(user);

//        Query searchUserQuery = new Query(Criteria.where("username").is("Jose"));
//
//        // find the saved user again.
//        Users savedUser = mongoOperation.findOne(searchUserQuery, Users.class);
//        System.out.println("2. find - savedUser : " + savedUser);

        // update password
//        mongoOperation.updateFirst(searchUserQuery, Update.update("password", "new password"),
//                Users.class);

        // find the updated user object
//        Users updatedUser = mongoOperation.findOne(
//                new Query(Criteria.where("username").is("Jose")), Users.class);
//
//        System.out.println("3. updatedUser : " + updatedUser);

        // delete
//        mongoOperation.remove(searchUserQuery, Users.class);

        // List, it should be empty now.
        List<Users> listUser = mongoOperation.findAll(Users.class);
        System.out.println("4. Number of user = " + listUser.size());

    }
}
