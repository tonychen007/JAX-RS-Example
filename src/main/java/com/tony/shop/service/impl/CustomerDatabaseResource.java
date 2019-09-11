package com.tony.shop.service.impl;

import com.tony.shop.service.CustomerResource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/customersdb")
public class CustomerDatabaseResource {

	@Path("{database}-db")
	public CustomerResource getCustomerResource(@PathParam("database") String db) {
		return locateCustomerDB(db);
	}

	public CustomerResource locateCustomerDB(String db) {
		return new CustomerResourceService();
	}
}
