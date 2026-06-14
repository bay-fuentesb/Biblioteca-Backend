package com.Libro.Libros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient marcaWebClient(){
        return WebClient.builder()
        .baseUrl("http://Libros:8080/").build();
    }
}
