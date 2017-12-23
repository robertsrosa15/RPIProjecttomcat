package com.joseroberts.rpiproject.models.data;

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
}
