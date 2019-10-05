package com.tony.shop.app;

import com.tony.shop.convert.ColorConverterProvider;
import com.tony.shop.service.impl.CustomerDatabaseResource;
import com.tony.shop.service.impl.CustomerResourceService;
import com.tony.shop.service.impl.FileService;
import com.tony.shop.service.impl.TextBookService;

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
		singletons.add(new CustomerDatabaseResource());
		singletons.add(new ColorConverterProvider());
		singletons.add(new FileService());
		singletons.add(new TextBookService());
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