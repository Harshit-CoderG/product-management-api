package com.campus.springboot_crud_mysql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "Product Management REST API",
        version = "1.0",
        description = "Backend APIs for Product Management System",
        contact = @Contact(
            name = "CampusClassroom",
            email = "harshit.dev.tech@gmail.com"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
    )
)
public class OpenApiConfig {

    @Bean
    public OpenAPI productManagementOpenAPI() {
        return new OpenAPI();
    }

}