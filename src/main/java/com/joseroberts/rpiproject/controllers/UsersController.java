package com.joseroberts.rpiproject.controllers;

import com.google.gson.Gson;
import com.joseroberts.rpiproject.models.Users;
import com.joseroberts.rpiproject.models.data.MongoDAO;
import com.mongodb.BasicDBList;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

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
    public Response addUser(@FormParam("username") String username,
                          @FormParam("password") String password){
        Users newUser = new Users(username,password);
        Gson gson = new Gson();
        Document request = Document.parse(gson.toJson(newUser));
        mongoDAO.saveDoc(collection, request);
        String response = gson.toJson(newUser.toString());
        return Response.status(200).entity(gson.toJson(response)).build();
    }

    @POST
    @Path("/id/{id}")
    @Consumes({MediaType.TEXT_PLAIN,
            MediaType.APPLICATION_FORM_URLENCODED,
            MediaType.APPLICATION_JSON,
            MediaType.MULTIPART_FORM_DATA})
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeOne(@PathParam("id") String id){
        System.out.println(id);
        Gson gson = new Gson();
        Document request = new Document("_id", new ObjectId(id));
        mongoDAO.removeDoc(collection, request);
        String response = gson.toJson(request);
        System.out.println(response);
        return Response.status(200).entity(response).build();
    }


    @GET
    @Path("/{param}")
    public Response findVisitor(@PathParam("param") String param){
        Document bson = new Document("username", param);
        BasicDBList response = mongoDAO.findByName(collection, bson);
        return Response.status(200).entity(response.toString()).build();
    }


}
