package com.tony.shop.app;

import com.tony.shop.convert.*;
import com.tony.shop.exception.NotFoundExceptionMapper;
import com.tony.shop.service.impl.*;

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
		singletons.add(new ColorConverterProvider());
		singletons.add(new FileService());
		singletons.add(new TextBookService());
		singletons.add(new ExceptionService());

		empty.add(NotFoundExceptionMapper.class);
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