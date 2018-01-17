package com.joseroberts.rpiproject.controllers;

import com.joseroberts.rpiproject.Utils.MongoHelper;
import com.joseroberts.rpiproject.models.data.MongoDAO;
import com.mongodb.BasicDBList;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("visitors")
public class VisitorsController {

    private MongoDAO mongoDAO = new MongoDAO();
    private MongoCollection<Document> collection = mongoDAO.database.getCollection("visitors");
    MongoHelper mongoHelper = new MongoHelper("rpirepo", "visitors");

    @GET
    public Response getVisitors(){
        BasicDBList response = mongoDAO.findAll(collection);
        return Response.status(200).entity(response.toString()).build();
    }


    @GET
    @Path("/{param}")
    public Response findVisitor(@PathParam("param") String param){
        Document bson = new Document("visitorName", param);
        BasicDBList response = mongoDAO.findByName(collection, bson);
        return Response.status(200).entity(response.toString()).build();
    }
}
