package com.spring.henallux.springProject.dataAccess.util;

import org.dozer.CustomConverter;

import java.time.LocalDateTime;

public class LocalDateTimeConverter implements CustomConverter {
    @Override
    public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {

        System.out.println("hhhhhhh");
        if(source == null)
            return null;

        if(source instanceof LocalDateTime)
            return source;

        throw new IllegalArgumentException("Unsupported conversion: " + source.getClass() + " to " + destClass);
    }
}
