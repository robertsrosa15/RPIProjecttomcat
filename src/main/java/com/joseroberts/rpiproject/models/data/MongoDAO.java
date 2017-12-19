//package com.joseroberts.rpiproject.models.data;
//
//import com.mongodb.DB;
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoDatabase;
//
//public class MongoDAO {
//    private static DB db;
//    private static MongoClient mongoClient = null;
//
//    public static void init(){
////        MongoClient mongoClient = new MongoClient();
////        MongoDatabase mongoDatabase = mongoClient.getDatabase("rpirepo");
//
//        mongoClient = new MongoClient("locahost", 27017);
//        System.out.println("there was an error");
//        db = (DB) mongoClient.getDatabase("rpirepo");
//    }
//    public static DB getDb(){
//        return db;
//    }
//    public static void close(){
//        mongoClient.close();
//    }
//}
