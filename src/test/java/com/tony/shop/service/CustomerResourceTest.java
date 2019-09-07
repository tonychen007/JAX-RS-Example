package com.tony.shop.service;

import com.tony.shop.service.impl.CustomerResourceService;
import org.junit.Test;

import java.io.InputStream;

public class CustomerResourceTest {

    @Test
    public void createCustomerTest() {
        CustomerResourceService csr = new CustomerResourceService();
        InputStream is = CustomerResourceTest.class.getResourceAsStream("/customer.xml");
        csr.createCustomer(is);
    }
}
