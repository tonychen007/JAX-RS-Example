package com.tony.shop.convert;

import com.tony.shop.domain.JAXB.JAXCustomer;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

@Provider
@Produces("application/xml")
public class CustomerXMLResolver implements ContextResolver<JAXBContext> {
    private JAXBContext ctx;

    public CustomerXMLResolver() {
        try {
            ctx = JAXBContext.newInstance(JAXCustomer.class);
        } catch (Exception e) {

        }
    }

    @Override
    public JAXBContext getContext(Class<?> type) {
        return type.equals(JAXCustomer.class) ? ctx : null;
    }
}
