package com.joseroberts.rpiproject;

import com.joseroberts.rpiproject.models.data.MongoDAO;
import com.mongodb.BasicDBList;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//@Path("/hello")
@Path("/try")
public class Hello {
//    private Query query;
//    private ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
//    private MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
//    private MongoClient mongoClient = new MongoClient("localhost", 27017);
//    private MongoDatabase mongoDatabase = mongoClient.getDatabase("rpirepo");
    private MongoDAO mongoDAO = new MongoDAO();
    MongoCollection<Document> collection = mongoDAO.database.getCollection("visitors");

    @GET
    public Response getGenMsg() {
        Document bson = new Document("visitorName","Stevens");
        FindIterable<Document> doc = collection.find(bson);
        return Response.status(200).entity(doc.first().toJson()).build();
    }


    @GET
    @Path("/visitorlist")
    public Response getVisitorList(){
        BasicDBList response = mongoDAO.findAll(collection);
        return Response.status(200).entity(response.toString()).build();
    }

    @GET
    @Path("/visitor/{param}")
    public Response getVisitor(@PathParam("param") String msg){
        Document bson = new Document("visitorName","Stevens");
        FindIterable<Document> response = collection.find(bson);
        return Response.status(200).entity(response.first().toJson()).build();
    }

    @POST
    @Path("/visitore/{param}")
    public Response updateVisitor(){
        Document bson = new Document("visitorName","Stevens");
        FindIterable<Document> response = collection.find(bson);
        //make an update
        Document bson1 = new Document("visitorName","Keilynn");
        collection.updateOne(bson, bson1);
        return Response.status(200).entity("user updated").build();
    }

    @POST
    @Path("/create")
    public Response createVisitor(){
        //make an update
        Document bson = new Document("visitorName","Keilynn");
        collection.insertOne(bson);
        return Response.status(200).entity("User Created").build();
    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "You entered : " + msg;
//        String dbOutput = getDatabase("rpirepo");
        return Response.status(200).entity(output +"\n it seems you took a wrong turn \n").build();
    }

    @GET
    @Path("/works")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisitors(){
//        MongoCollection<Document> collection = mongoDatabase.getCollection("visitors");

        MongoDAO mongoDAO = new MongoDAO();
        BasicDBList response = mongoDAO.findAll(collection);

        Document bson = new Document(response.toMap());
        return Response.status(200).entity(response.toString()).build();
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
