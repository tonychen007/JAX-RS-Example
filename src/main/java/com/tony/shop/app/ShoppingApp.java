package com.tony.shop.app;

import com.tony.shop.convert.*;
import com.tony.shop.service.impl.CustomerDatabaseResourceService;
import com.tony.shop.service.impl.CustomerResourceService;
import com.tony.shop.service.impl.FileService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/services")
public class ShoppingApp extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public ShoppingApp() {
        singletons.add(new CustomerResourceService());
        singletons.add(new CustomerDatabaseResourceService());
        singletons.add(new FileService());
        singletons.add(new ColorConverterProvider());

        // set<class<?>> for per request
        empty.add(JavaXMLMarshaller.class);
        empty.add(JavaObjectMarshaller.class);
        empty.add(JavaJSONMarshaller.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}