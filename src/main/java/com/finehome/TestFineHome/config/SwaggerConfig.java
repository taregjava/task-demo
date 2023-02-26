package com.finehome.TestFineHome.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("task-demo")
                .description("Task demo Spring boot")
                .contact(new Contact().name("Tareg Balola")
                        .email("tareg.balola@gmail.com")));
    }
}
