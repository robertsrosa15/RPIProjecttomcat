package com.joseroberts.rpiproject;

import com.joseroberts.rpiproject.config.MongoConfig;
import com.joseroberts.rpiproject.models.Visitors;
import com.joseroberts.rpiproject.models.data.MongoDAO;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
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

    private Query query;

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    private MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    private MongoClient mongoClient = new MongoClient("localhost", 27017);
    private MongoDatabase mongoDatabase = mongoClient.getDatabase("rpirepo");

    @GET
    public Response getGenMsg() {

        MongoCollection<Document> dbOutput = mongoDatabase.getCollection("visitors");
        Document bson = new Document("visitorName","Stevens");
        FindIterable<Document> doc = dbOutput.find(bson);

//        Col myDoc = dbOutput.find();
//        Document firstDocument = doc.first();
        System.out.println("**********************" + doc + "**********************");
        return Response.status(200).entity(doc.first().toJson()).build();
    }

    @GET
    @Path("/mine")
    public Response getEm(){ 
        MongoDAO mongoDAO = new MongoDAO();
        String response = mongoDAO.getAll();
        
        return Response.status(200).entity(response).build();
    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say  : " + msg;
//        String dbOutput = getDatabase("rpirepo");
        return Response.status(200).entity(output +"\n Database has tge shitttt \n").build();
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
//        query = new Query(Criteria.where("username").is("Jose"));
        List<Visitors> response = mongoOperation.findAll(Visitors.class, "visitors");
//        JsonObject json = new JSONArray(response);
        System.out.println(response.getClass().getName());
        return Response.status(200).entity(response + "").build();
    }

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

//    private String getDatabase(String dbName){
//        MongoClient mongoClient = new MongoClient();
//        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
//
//        ListCollectionsIterable<Document> listCollection = mongoDatabase.listCollections();
//        MongoCursor<Document> cursor = listCollection.iterator();
//        String output = "";
//        try {
//            while (cursor.hasNext()) {
//                output += cursor.next().toJson();
//            }
//        } finally {
//            cursor.close();
//        }
//        return output;
//    }
}
