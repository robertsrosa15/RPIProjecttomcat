package com.joseroberts.rpiproject.controllers;

import com.google.gson.Gson;
import com.joseroberts.rpiproject.models.Users;
import com.joseroberts.rpiproject.models.data.MongoDAO;
import com.mongodb.BasicDBList;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/user")
public class UsersController {

    private MongoDAO mongoDAO = new MongoDAO();
    private MongoCollection<Document> collection = mongoDAO.database.getCollection("users");

    @GET
    public Response getUsers(){
        BasicDBList response = mongoDAO.findAll(collection);
//        Document bson = new Document(response.toMap());
        return Response.status(200).entity(response.toString()).build();
    }

    @POST
    public String addUser(){
        Users newUser = new Users("joey","myPass");
        Gson gson = new Gson();
        Document request = Document.parse(gson.toJson(newUser));
        mongoDAO.saveDoc(collection, request);
        return "user created";
    }


    @GET
    @Path("/{param}")
    public Response findVisitor(@PathParam("param") String param){
        Document bson = new Document("username", param);
        BasicDBList response = mongoDAO.findByName(collection, bson);
        return Response.status(200).entity(response.toString()).build();
    }


}
