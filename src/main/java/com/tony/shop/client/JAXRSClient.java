package com.tony.shop.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JAXRSClient {
    private static Client client = ClientBuilder.newClient();

    public static Response postCustomer() throws Exception {
        Client client = ClientBuilder.newClient();
        InputStream cust = JAXRSClient.class.getResourceAsStream("/customer.xml");
        String xml = new String(cust.readAllBytes(), "utf-8");
        Response response = client.target("http://localhost:8080/services/customers").request().post(Entity.xml(xml));
        int status = response.getStatus();
        response.close();
        client.close();

        return response;
    }

    public static void getCustomer() throws Exception {
        Response post = postCustomer();
        String loc = post.getLocation().toString();
        Response response = client.target(loc).request().get();
        Object ent = response.getEntity();
        int asm3 = 0;
        response.close();
        client.close();
    }

    public static void main(String[] args) throws Exception {
        //getCustomer();

        WebTarget target = client.target("http://localhost:8080/services/customers/car/{model}/{year}");
        String response = target.resolveTemplate("model","tony;color=red").resolveTemplate("year",1990).request().get(String.class);
        int asm3 = 0;
    }
}
