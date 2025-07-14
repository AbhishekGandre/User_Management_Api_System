package com.example.demo.swagerdocument;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api Documentation for User Product")
                        .version("1.0")
                        .description("This is the API documentation for User Product")
                        .contact(new Contact()
								.name("Abhishek Gandre")
								.email("gandreabhishek@gmail.com")
								.url("https://github.com/AbhishekGandre")));
    }
    
}
