package com.moduscreate

import java.net.URI
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/user")
class UserResource {

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun save(@Valid user: User): Response =
            user.let {
                it.persist()
                Response.created(URI("/user/${user.id}")).entity(user).build()
            }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("id") id: String): Response =
            Response.ok(User.findById(id)).build()

}