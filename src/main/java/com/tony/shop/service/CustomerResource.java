package com.tony.shop.service;

import com.tony.shop.domain.Color;
import com.tony.shop.domain.JAXB.JAXCustomer;
import com.tony.shop.domain.TestBean;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
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


    @GET
    @Path("xml/cust/{id}")
    @Produces("application/xml; charset=utf-8")
    JAXCustomer getCustomerXML(@PathParam("id") int id);

    @GET
    @Path("json/cust/{id}")
    @Produces("application/json; charset=utf-8")
    JAXCustomer getCustomerJSON(@PathParam("id") int id);

    @PUT
    @Path("{id}")
    @Consumes("application/xml; charset=utf-8")
    void updateCustomer(@PathParam("id") int id, InputStream is);

    @GET
    @Path("/1/{matrix}")
    @Consumes("text/html;charser-utf-8")
    Response getMatrixParam(@PathParam("matrix") String matrix);


    @GET
    @Path("/{model}/{year}")
    @Produces("text/html; charset=utf-8")
    Response getCarInfo(@PathParam("model") PathSegment car, @PathParam("year") String year, @Context UriInfo uri);

    @POST
    @Path("/form")
    @Produces("text/html; charset=utf-8")
    Response getFormInfo(@FormParam("first") String first);

    @POST
    @Path("/bean")
    @Produces("text/html; charset=utf-8")
    Response getBeanInfo(@BeanParam TestBean bean);

    @GET
    @Path("/paramCovt")
    @Produces("text/html; charset=utf-8")
    Response getParamConverter(@QueryParam("color") Color cl);
}