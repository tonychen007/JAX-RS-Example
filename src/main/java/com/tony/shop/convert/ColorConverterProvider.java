package com.tony.shop.convert;

import com.tony.shop.domain.Color;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class ColorConverterProvider implements ParamConverterProvider {
    private final ParamConverter<Color> converter = new ColorConverter();

    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation annotations[]) {
        if (!rawType.equals(Color.class)) return null;

        return (ParamConverter<T>)converter;
    }
}
