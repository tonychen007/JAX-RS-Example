package com.tony.shop.service.impl;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/customersdb")
public class CustomerDatabaseResourceService {

	@Path("{database}-db")
	public Object getCustomerResource(@PathParam("database") String db) {
		return locateCustomerDB(db);
	}

	public Object locateCustomerDB(String db) {
		if ("usa".equalsIgnoreCase(db)) {
			return new CustomerResourceService();
		} else if ("tw".equalsIgnoreCase(db)) {
			return new FirstLastCustomerResourceService();
		} else {
			return  null;
		}
	}
}
