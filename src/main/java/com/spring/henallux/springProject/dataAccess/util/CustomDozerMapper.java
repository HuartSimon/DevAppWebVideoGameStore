package com.spring.henallux.springProject.dataAccess.util;


import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import java.time.LocalDateTime;
import java.util.Collections;

public class CustomDozerMapper extends DozerBeanMapper{

    public CustomDozerMapper(){
        this.setCustomConverters(Collections.singletonList(new LocalDateTimeConverter()));

        this.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(LocalDateTime.class, LocalDateTime.class, TypeMappingOptions.oneWay());
            }
        });
    }
}
