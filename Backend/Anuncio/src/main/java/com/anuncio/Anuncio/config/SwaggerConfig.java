package com.anuncio.Anuncio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Microservicio - Anuncios / Calendario")
                .description("API REST para la gestión del calendario de eventos y anuncios de la Biblioteca.")
                .version("0.0.1-SNAPSHOT")
                .contact(new Contact()
                    .name("Biblioteca Backend")
                    .url("https://github.com/bay-fuentesb/Biblioteca-Backend")));
    }
}