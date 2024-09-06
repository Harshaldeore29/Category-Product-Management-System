package com.springboot.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/api/**")
                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Category And Product Management REST APIs")
                		.description("Category-Product Management System")
                        .version("1.0.0")
                        .contact(new Contact()
                        .name("Harshal Deore")
                        .url("https://deoreharshal.netlify.app/")
                        .email("deoreharshal711@gmail.com"))
                ))
                .build();
    }
}
