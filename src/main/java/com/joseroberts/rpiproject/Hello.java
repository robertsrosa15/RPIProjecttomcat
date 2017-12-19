package com.joseroberts.rpiproject;

import com.joseroberts.rpiproject.config.MongoConfig;
import com.joseroberts.rpiproject.models.Users;
import com.joseroberts.rpiproject.models.Visitors;
//import com.joseroberts.rpiproject.models.data.MongoDAO;
import com.joseroberts.rpiproject.models.data.UsersRepository;
import com.joseroberts.rpiproject.models.data.VisitorsRepository;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//@Path("/hello")
@Path("/try")
public class Hello {

    private List<?> response;
    private Query query;

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    private MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    @GET
    public Response getGenMsg() {
        String output = "Jersey say : " + "Bitcoin is the shit. You should invest NOW!!! \n\n ";
        String dbOutput = getDatabase("rpirepo");
        return Response.status(200).entity(output +"\n MongoDB has the following...   --->>> \n" + dbOutput).build();
    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say  : " + msg;
        String dbOutput = getDatabase("rpirepo");
        return Response.status(200).entity(output +"\n Database has tge shitttt \n" + dbOutput).build();
    }

    @GET
    @Path("/works")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisitors(){
//        response = mongoOperation.findAll(Visitors.class);
        query = new Query(Criteria.where("visitorName").is("Stevens"));
        Visitors response = mongoOperation.findOne(query, Visitors.class);
        return Response.status(200).entity(response +"" ).build();
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(){
        query = new Query(Criteria.where("username").is("Jose"));
        Users response = mongoOperation.findOne(query, Users.class);
        return Response.status(200).entity(response +"" ).build();
    }


//    @GET
//    @Path("/new")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getNew(){
//        MongoDAO.init();
//        System.out.println("ssssss");
//        String dbOutput = getDatabase("rpirepo");
////        List<Visitors> response = repository.findAll();
//        return Response.status(200).entity(dbOutput).build();
//    }

//    ***************************************
//    possible image handling
//    ***************************************
//    @GET
//    @Path("/pic")
//    public static boolean attachFile(InputStream stream, String name) {
//        GridFS gStore = new GridFS(DBConnection.getDb(), "photos");
//        GridFSInputFile gFile = gStore.createFile(stream);
//        gFile.setFilename(name + ".JPG"); // let's say we store images
//        gFile.save();
//        try {
//            gFile.validate();
//        } catch (final MongoException e) {
//            return false;
//        }
//        return true;
//    }

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
