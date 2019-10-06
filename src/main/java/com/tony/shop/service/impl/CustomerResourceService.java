package com.tony.shop.service.impl;

import com.tony.shop.domain.Color;
import com.tony.shop.domain.Customer;
import com.tony.shop.domain.JAXB.JAXAddress;
import com.tony.shop.domain.JAXB.JAXCustomer;
import com.tony.shop.domain.TestBean;
import com.tony.shop.service.CustomerResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class CustomerResourceService extends AbstractResourceService implements CustomerResource {
	@Override
	public Response createCustomer(InputStream is) {
		Customer customer = readCustomer(is);
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		System.out.println("Created customer " + customer.getId());
		return Response.created(URI.create("/customers/" + customer.getId())).build();
	}

	@Override
	public StreamingOutput getCustomer(@PathParam("id") int id) {
		final Customer customer = customerDB.get(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		return (output -> outputCustomer(output, customer));
	}

	@Override
	public JAXCustomer getCustomerXML(@PathParam("id") int id) {
		return buildCustomer(id);
	}

	@Override
	public Response getCustomerList() {
		List<JAXCustomer> customers = new ArrayList<>();
		customers.add(new JAXCustomer());
		customers.add(new JAXCustomer());
		customers.add(new JAXCustomer());

		GenericEntity entity = new GenericEntity<List<JAXCustomer>>(customers) {};
		return Response.ok(entity).build();
	}

	@Override
	public Customer getCustomerObj(@PathParam("id") int id) {
		Customer cust = new Customer();
		cust.setId(id);
		cust.setFirstName("tony");
		cust.setLastName("chen");
		cust.setCity("Shanghai");

		return cust;
	}

	@Override
	public JAXCustomer getCustomerJSON(@PathParam("id") int id) {
		return buildCustomer(id);
	}

	@Override
	public void updateCustomer(@PathParam("id") int id, InputStream is) {
		Customer update = readCustomer(is);
		Customer current = customerDB.get(id);
		if (current == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);

		current.setFirstName(update.getFirstName());
		current.setLastName(update.getLastName());
		current.setStreet(update.getStreet());
		current.setState(update.getState());
	}

	@Override
	public Response getMatrixParam(String matrix) {
		return Response.created(URI.create("/" + matrix)).build();
	}


	@Override
	public Response getCarInfo(@PathParam("model") PathSegment car,
	                           @PathParam("year") String year,
	                           @Context UriInfo uri) {
		String color = car.getMatrixParameters().getFirst("color");
		URI bu = uri.getBaseUri();
		String path = uri.getPath();
		MultivaluedMap m = uri.getPathParameters();
		List<PathSegment> pss = uri.getPathSegments();
		return Response.ok("car:" + color + ", year:" + year).build();
	}

	@Override
	public Response getFormInfo(String first) {
		return Response.ok("form:" + first).build();
	}

	@Override
	public Response getBeanInfo(TestBean bean) {
		return Response.ok("form:" + bean).build();
	}

	@Override
	public Response getParamConverter(Color cl) {
		return Response.ok("form:" + Color.BLACK).build();
	}
}
