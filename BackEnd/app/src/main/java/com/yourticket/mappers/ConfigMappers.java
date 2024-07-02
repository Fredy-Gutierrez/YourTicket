package com.yourticket.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author fredd
 */
@Configuration
public class ConfigMappers {
    @Bean
    public ModelMapper mapperDTO(){
        return new ModelMapper();
    }
}
