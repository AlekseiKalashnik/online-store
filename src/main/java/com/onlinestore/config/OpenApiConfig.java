package com.onlinestore.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Online store",
                description = "Test app", version = "1.0.0",
                contact = @Contact(
                        name = "Alex K",
                        email = "id50538996@gmail.com"
                )
        )
)
public class OpenApiConfig {

    @Bean
    public OpenAPI baseOpenApi() {
        return new OpenAPI().info(new Info().title("Spring Doc")
                .version("1.0.0").description("SpringDoc"));
    }
}
