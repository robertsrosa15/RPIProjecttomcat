package com.joseroberts.rpiproject.models.data;

import com.mongodb.BasicDBList;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDAO {
    public final MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    public final MongoDatabase database = mongoClient.getDatabase("rpirepo");

    public BasicDBList findAll(MongoCollection<Document> collection) {
        BasicDBList basicDBList = new BasicDBList();
        for (Document document: collection.find()) {
            System.out.println(document);
            basicDBList.add(document);
        }
        return basicDBList;
    }

    public BasicDBList findByName (MongoCollection<Document> collection , Document bson){
        BasicDBList basicDBList = new BasicDBList();
        basicDBList.add(collection.find(bson));
        return basicDBList;
    }

    public void saveDoc (MongoCollection<Document> collection, Document bson){
        collection.insertOne(bson);
    }

    public void removeDoc (MongoCollection<Document> collection, Document bson){
        collection.deleteOne(bson);
    }
}
