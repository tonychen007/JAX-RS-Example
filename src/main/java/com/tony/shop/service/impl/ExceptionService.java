package com.tony.shop.service.impl;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;

@Path("/exception")
public class ExceptionService {
	@Path("notFound")
	public void notFound() {
		throw new NotFoundException();
	}
}
