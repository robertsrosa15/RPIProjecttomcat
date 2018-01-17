package com.joseroberts.rpiproject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App {

    public static void main(String[] args){
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
//        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
//
//        Users user = new Users("Isaac", "password");
//        mongoOperation.save(user);

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
//        List<Users> listUser = mongoOperation.findAll(Users.class);
//        System.out.println("4. Number of user = " + listUser.size());
//
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("rpirepo");
        MongoCollection<Document> collection = database.getCollection("visitors");
        StringBuilder output = new StringBuilder();

        try (MongoCursor<Document> cur = collection.find().iterator()) {
            while (cur.hasNext()) {
                output.append(cur.next().toJson());

//                Document doc = cur.next();
//
//                List list = new ArrayList(doc.values());
//                System.out.print(list.get(1));
//                System.out.print(": ");
//                System.out.println(list.get(2));
            }
        }

        System.out.println(output);

        mongoClient.close();
    }


//        ListCollectionsIterable<Document> listCollection = database.getCollection();
//        MongoCursor<Document> cursor = listCollection.iterator();
//        String output = "";
//        try {
//            while (cursor.hasNext()) {
//                output += cursor.next().toJson();
//            }
//        } finally {
//            cursor.close();
//        }
//        return output;





}
