package com.yourticket.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String allowedOrigins;
    private String allowedMethods;
    private String allowedHeaders;
    private String exposedHeaders;
    private Boolean ignoreSession;
}
