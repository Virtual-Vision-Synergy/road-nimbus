package com.project.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI roadOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Roadworks Reporting API")
                        .description("Mock API pour coordonner Auth, Carto, Signalements et Front helpers")
                        .version("0.1" )
                        .contact(new Contact().name("Equipe Road").email("road@example.com")))
                .components(new Components().addSecuritySchemes("static-token",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("static-token"));
    }

    @Bean
    public GroupedOpenApi authGroup() {
        return GroupedOpenApi.builder()
                .group("auth")
                .pathsToMatch("/api/auth/**")
                .build();
    }

    @Bean
    public GroupedOpenApi mapGroup() {
        return GroupedOpenApi.builder()
                .group("map")
                .pathsToMatch("/api/map/**")
                .build();
    }

    @Bean
    public GroupedOpenApi signalementGroup() {
        return GroupedOpenApi.builder()
                .group("signalements")
                .pathsToMatch("/api/signalements/**")
                .build();
    }
}

