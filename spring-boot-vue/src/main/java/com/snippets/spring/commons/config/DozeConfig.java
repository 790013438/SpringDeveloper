package com.snippets.spring.commons.config;

import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class DozeConfig {

    @Bean("org.dozer.Mapper")
    public Mapper dozerBeanMapper() {
        List<String> mappingFiles = Collections.singletonList(
                "mapping.xml"
        );
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingFiles);
        return dozerBeanMapper;
    }
}
