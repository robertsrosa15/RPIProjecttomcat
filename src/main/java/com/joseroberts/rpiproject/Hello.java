package com.joseroberts.rpiproject;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")

public class Hello {

    @GET
    public Response getGenMsg() {
        String output = "Jersey say : " + "Bitcoin is the shit. You should invest NOW!!! \n\n ";
        String dbOutput = getDatabase("rpiproject");
        return Response.status(200).entity(output +"\n MongoDB has the following...   --->>> \n" + dbOutput).build();
    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say  : " + msg;
        String dbOutput = getDatabase("rpiproject");
        return Response.status(200).entity(output +"\n Database has tge shitttt \n" + dbOutput).build();

    }

    private String getDatabase(String dbName){
        MongoClient mongoClient = new MongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);

        ListCollectionsIterable<Document> listCollection = mongoDatabase.listCollections();
        MongoCursor<Document> cursor = listCollection.iterator();
        String output = "";
        try {
            while (cursor.hasNext()) {
                output += cursor.next().toJson();
            }
        } finally {
            cursor.close();
        }
        return output;
    }
}
