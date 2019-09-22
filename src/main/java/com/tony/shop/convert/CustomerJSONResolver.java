package com.tony.shop.convert;

import com.tony.shop.domain.Customer;
import com.tony.shop.domain.JAXB.JAXAddress;
import com.tony.shop.domain.JAXB.JAXCustomer;
import org.jboss.resteasy.plugins.providers.jaxb.json.JettisonMappedContext;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

@Provider
@Produces("application/json")
public class CustomerJSONResolver implements ContextResolver<JAXBContext> {

    private JAXBContext ctx;

    public CustomerJSONResolver() {
        try {
            ctx = JettisonMappedContext.newInstance(JAXCustomer.class);
        } catch (Exception e) {

        }
    }

    @Override
    public JAXBContext getContext(Class<?> type) {
        return type.equals(JAXCustomer.class) ? ctx : null;
    }
}
