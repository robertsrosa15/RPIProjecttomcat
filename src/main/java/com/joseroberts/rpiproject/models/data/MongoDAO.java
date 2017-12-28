package com.joseroberts.rpiproject.models.data;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDAO {
    private final MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    private final MongoDatabase database = mongoClient.getDatabase("rpirepo");
    private MongoCollection<Document> collection = database.getCollection("visitors");

    public String getAll() {

        StringBuilder output = new StringBuilder();

        try (MongoCursor<Document> cur = collection.find().iterator()) {
            while (cur.hasNext()) {
                output.append(cur.next().toJson());
            }
        }

        System.out.println(output);
        mongoClient.close();

        return output.toString();
    }

    public BasicDBList findAll() {
        BasicDBList basicDBList = new BasicDBList();
        BasicDBObject basicDBObject = new BasicDBObject();
//        basicDBList.addAll((Collection<Document>) collection.find());
/*
        }*//*
//        basicDBList.addAll((Collection<?>) collection.find().toString());
        basicDBObject.putAll(collection.find().toString());*/

        Document doc = new Document();
        for (Document document: collection.find()) {
            System.out.println(document);
            basicDBList.add(document);
        }
        basicDBObject.putAll(basicDBList);

        return basicDBList;

    }
}
