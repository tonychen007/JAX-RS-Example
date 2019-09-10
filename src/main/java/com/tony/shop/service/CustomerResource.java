package com.tony.shop.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.InputStream;

@Path("/customers")
public interface CustomerResource {
    @POST
    @Consumes("application/xml; charset=utf-8")
    Response createCustomer(InputStream is);

    @GET
    @Path("{id}")
    @Produces("application/xml; charset=utf-8")
    StreamingOutput getCustomer(@PathParam("id") int id);

    @PUT
    @Path("{id}")
    @Consumes("application/xml; charset=utf-8")
    void updateCustomer(@PathParam("id") int id, InputStream is);
}