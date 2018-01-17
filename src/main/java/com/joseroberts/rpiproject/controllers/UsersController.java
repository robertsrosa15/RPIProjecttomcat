package com.joseroberts.rpiproject.controllers;

import com.google.gson.Gson;
import com.joseroberts.rpiproject.models.Users;
import com.joseroberts.rpiproject.models.data.MongoDAO;
import com.mongodb.BasicDBList;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    @Consumes({MediaType.MULTIPART_FORM_DATA,
            MediaType.APPLICATION_JSON,
            MediaType.TEXT_PLAIN,
            MediaType.APPLICATION_FORM_URLENCODED})
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@FormParam(value = "username") String username,
                          @FormParam(value = "password") String password){
        Users newUser = new Users(username,password);
        System.out.println(newUser.toString());
        Gson gson = new Gson();
        Document request = Document.parse(gson.toJson(newUser));
        mongoDAO.saveDoc(collection, request);
        String response = "response: user created";
        return Response.status(200).entity(gson.toJson(response)).build();
    }


    @GET
    @Path("/{param}")
    public Response findVisitor(@PathParam("param") String param){
        Document bson = new Document("username", param);
        BasicDBList response = mongoDAO.findByName(collection, bson);
        return Response.status(200).entity(response.toString()).build();
    }


}
