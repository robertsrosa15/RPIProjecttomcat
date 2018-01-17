package com.joseroberts.rpiproject.Utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class MongoHelper {

    private MongoDatabase database = null;
    private MongoCollection mongoCollection = null;


    /**
     * Sets database to be default MongoConstants.DEFAULT_DB_NAME
     */
    public MongoHelper(){
        this.database = new MongoClient().getDatabase(MongoConstants.DEFAULT_DB_NAME);
    }

    /**
     * Sets database to @param
     * @param dbName
     */
    public MongoHelper(String dbName){
        this.database = new MongoClient().getDatabase(dbName);
    }


    /**
     * Sets database to @param
     * Sets collection to @param
     * @param dbName
     * @param collectionName
     */
    public MongoHelper(String dbName, String collectionName){
        this.database = new MongoClient().getDatabase(dbName);
        this.mongoCollection = getCollection(collectionName);
    }

    /**
     * Returns collection of @param
     * @param collectionName
     * @return
     */
    public MongoCollection getCollection(String collectionName){
        return this.database.getCollection(collectionName);
    }


    /**
     * Returns a List of all collections
     * Use for(String collectionName: getCollections()){
     *          do whatever with collectionName
     *     }
     * }
     * @return
     */
    public MongoIterable<String> getCollectionsAll(){
        return this.database.listCollectionNames();
    }

    /**
     * Returns current name of database if any
     * @return
     */
    public String getDBName(){
        return this.database.getName();
    }

    /**
     * Returns Document by getting the first document
     * by Id in current collection
     * @param id
     * @return
     */
    public Document getDocumentById(int id){
        return (Document) mongoCollection.find(createBsonDocument("id", id)).first();
    }

    /**
     * Returns JSON by getting the first document
     * by Id in current collection     * @param id
     * @return
     */
    public String getDocumentByIdJson(int id){
        return getDocumentById(id).toJson();
    }

    /**
     * Returns Document by getting the
     * first document in current collection
     * @return
     */
    public Document getFirstDocument(){
        return (Document) mongoCollection.find().first();
    }

    /**
     * Returns JSON by getting the
     * first document in current collection
     * @return
     */
    public String getFirstDocumentJson(){
        return getFirstDocument().toJson();
    }

    /**
     * Returns Document by getting the
     * first document. Gets the document
     * by passing a BSON of String Name and String Value
     * in current collection
     * @param name
     * @param value
     * @return
     */
    public Document getFirstDocument(String name, String value){
        return (Document) mongoCollection.find(createBsonDocument(name, value)).first();
    }

    /**
     * Returns Document by getting the
     * first document. Gets the document
     * by passing a BSON of String Name and int Value
     * in current collection
     * @param name
     * @param value
     * @return
     */
    public Document getFirstDocument(String name, int value){
        return (Document) mongoCollection.find(createBsonDocument(name, value)).first();
    }

    /**
     * Returns Document by getting the
     * first document. Gets the document
     * by passing a BSON of String Name and boolean Value
     * in current collection
     * @param name
     * @param value
     * @return
     */
    public Document getFirstDocument(String name, boolean value){
        return (Document) mongoCollection.find(createBsonDocument(name, value)).first();
    }

    /**
     * Returns JSON by getting the
     * first document. Gets the document
     * by passing a BSON of String Name and Stirng Value
     * in current collection
     * @param name
     * @param value
     * @return
     */
    public String getFirstDocumentJson(String name, String value){
        return getFirstDocument(name, value).toJson();
    }

    /**
     * Returns JSON by getting the
     * first document. Gets the document
     * by passing a BSON of String Name and int Value
     * in current collection
     * @param name
     * @param value
     * @return
     */
    public String getFirstDocumentJson(String name, int value){
        return getFirstDocument(name, value).toJson();
    }

    /**
     * Returns JSON by getting the
     * first document. Gets the document
     * by passing a BSON of String Name and boolean Value
     * in current collection
     * @param name
     * @param value
     * @return
     */
    public String getFirstDocumentJson(String name, boolean value){
        return getFirstDocument(name, value).toJson();
    }

    /**
     * Returns a new BSON Document by passing
     * String name, String value
     * @param name
     * @param value
     * @return
     */
    public Document createBsonDocument(String name, String value){
        return new Document(name, value);
    }

    /**
     * Returns a new BSON Document by passing
     * String name, int value
     * @param name
     * @param value
     * @return
     */
    public Document createBsonDocument(String name, int value){
        return new Document(name, value);
    }

    /**
     * Returns a new BSON Document by passing
     * String name, boolean value
     * @param name
     * @param value
     * @return
     */
    public Document createBsonDocument(String name, boolean value){
        return new Document(name, value);
    }
}
