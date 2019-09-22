package com.tony.shop.app;

import com.tony.shop.convert.ColorConverterProvider;
import com.tony.shop.convert.CustomerJSONResolver;
import com.tony.shop.convert.CustomerXMLResolver;
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
        singletons.add(new CustomerXMLResolver());
        //singletons.add(new CustomerJSONResolver());
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