package com.joseroberts.rpiproject;

import javax.servlet.http.*;
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

        return Response.status(200).entity(output).build();

    }

}
