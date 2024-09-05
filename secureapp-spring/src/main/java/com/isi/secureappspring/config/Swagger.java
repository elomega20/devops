package com.isi.secureappspring.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class Swagger {
    @Bean
    public OpenAPI configOpenAPI() {
        return new OpenAPI().info(
                new Info().title("Secure-App V1")

        ).externalDocs(new ExternalDocumentation()
                .description("Spring boot Documentation")
                .url("https://spring.io/projects/spring-boot"));
    }

}
