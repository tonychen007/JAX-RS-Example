package com.tony.shop.service;

import org.junit.Test;

import java.io.InputStream;

public class CustomerResourceTest {

    @Test
    public void createCustomerTest() {
        CustomerResource csr = new CustomerResource();
        InputStream is = CustomerResourceTest.class.getResourceAsStream("/customer.xml");
        csr.createCustomer(is);
    }
}
