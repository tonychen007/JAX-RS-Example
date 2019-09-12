package com.tony.shop.service.impl;

import com.tony.shop.domain.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

public class FirstLastCustomerResourceService extends AbstractResourceService {

	@GET
	@Path("{first}-{last}")
	@Produces("application/xml")
	public StreamingOutput getCustomer(@PathParam("first") String first, @PathParam("last") String last) {
		Customer[] cust = new Customer[1];
		Customer cm = new Customer();
		cm.setId(1);
		cm.setFirstName("tony");
		cm.setLastName("chen");
		cm.setState("Shanghai");
		cm.setStreet("XiJiang");
		cm.setCity("Shanghai");
		cm.setCountry("China");
		cm.setZip("200");
		customerDB.put(1, cm);

		customerDB.entrySet().forEach(v -> {
			final Customer c = v.getValue();
			if (c.getFirstName().equalsIgnoreCase(first) &&
					c.getLastName().equalsIgnoreCase(last)) {

				cust[0] = c;
				int a = 0;
			}

			return;
		});

		if (cust[0] == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return (output -> outputCustomer(output, cust[0]));
	}
}
