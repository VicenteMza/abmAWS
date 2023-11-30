package com.awsvalidator.validatorserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://Localhost:8082")
                .allowedMethods("PUT", "DELETE","POST", "GET")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
