package com.joseroberts.rpiproject;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/hello")

public class Hello {

    @GET
    public Response getGenMsg() {

        String output = "Jersey say : " + "Bitcoin is the shit. You should invest NOW!!!";

        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say what the  : " + msg;
        String dbOutput = getDatabase("rpiproject");

        return Response.status(200).entity(output +"\n Database has tge shitttt \n" + dbOutput).build();

    }

    public String getDatabase(String dbName){

        MongoClient mongoClient = new MongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
        MongoCollection collection = mongoDatabase.getCollection("users");


        MongoCursor<Document> cursor = collection.find().iterator();
        String output = "";
        try {
            while (cursor.hasNext()) {
                output += cursor.next().toJson();
                System.out.println(output);
            }
        } finally {
            cursor.close();
        }
        return output;
    }

}
