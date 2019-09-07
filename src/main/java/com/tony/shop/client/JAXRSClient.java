package com.tony.shop.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class JAXRSClient {
	public static void main(String[] args) throws IOException {
		Client client = ClientBuilder.newClient();
		InputStream cust = JAXRSClient.class.getResourceAsStream("/customer.xml");
		String xml = new String(cust.readAllBytes(), "utf-8");
		Response response = client.target("http://localhost:8080/services/customers").request().post(Entity.xml(xml));

	}
}
