package com.tony.shop.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/textbook")
public class TextBookService {

	@GET
	@Path("/restful/java")
	@Produces("text/plain")
	public Response getBook() {
		String book = "I never danced at the White House.";
		Response.ResponseBuilder builder =  Response.ok(book);
		builder.language("fr").header("some-key","some-value");
		return builder.build();
	}
}
