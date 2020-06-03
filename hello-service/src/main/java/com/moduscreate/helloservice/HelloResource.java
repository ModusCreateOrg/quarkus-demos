package com.moduscreate.helloservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        if (HelloHealthCheck.respondWithError) {
            return Response.serverError().build();
        } else {
            return Response.ok("Good Morning from " +
                    System.getenv().getOrDefault("HOSTNAME", "unknown")).build();
        }
    }

    @GET
    @Path("/toggleErrorResponse")
    @Produces(MediaType.TEXT_PLAIN)
    public Response changeRespondWithErrorValue() {
        HelloHealthCheck.respondWithError = !HelloHealthCheck.respondWithError;
        return Response.ok().entity(HelloHealthCheck.respondWithError).build();
    }

}