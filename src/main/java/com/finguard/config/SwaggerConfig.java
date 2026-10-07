package com.finguard.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI finGuardOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("FinGuard AI API")
                                .description(
                                        "Fintech Transaction Risk Assessment Platform")
                                .version("0.0.1-SNAPSHOT")
                                .contact(
                                        new Contact()
                                                .name("Fin-Guard Team")
                                                .email("fingaurdsupport@example.com")
                                )
                );
    }
}