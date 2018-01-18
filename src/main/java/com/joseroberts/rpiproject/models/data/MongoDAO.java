package com.joseroberts.rpiproject.models.data;

import com.mongodb.BasicDBList;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDAO {
    public final MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    public final MongoDatabase database = mongoClient.getDatabase("rpirepo");
//    private MongoCollection<Document> collection = database.getCollection("visitors");

    public String getAll(MongoCollection<Document> collection) {

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

    public BasicDBList findAll(MongoCollection<Document> collection) {
        BasicDBList basicDBList = new BasicDBList();
//        BasicDBObject basicDBObject = new BasicDBObject();
//        basicDBList.addAll((Collection<Document>) collection.find());
//        basicDBList.addAll((Collection<?>) collection.find().toString());
//        basicDBObject.putAll(collection.find().toString());*/
//        Document doc = new Document();
        for (Document document: collection.find()) {
            System.out.println(document);
            basicDBList.add(document);
        }
//        basicDBObject.putAll(basicDBList);

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
//        Document bs = new Document("_id", new ObjectId("5a6000bf781f3f2db88989b5"));
        collection.deleteOne(bson);
    }
}
