package org.example.jsmpocrestservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenApiConfig {

    @Value("${server}")
    private String url;

    @Bean
    public OpenAPI customConfiguration() {
        return new OpenAPI()
                .servers(Collections
                        .singletonList(new Server().url(url))) //real public URL
                .components(new Components())
                .info(new Info().title("Dummy API Docs")
                        .description("Dummy REST API documentation"));
    }
}
