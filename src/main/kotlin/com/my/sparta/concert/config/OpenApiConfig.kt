package com.my.sparta.concert.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableWebMvc
class OpenApiConfig {

    @Bean
    fun concertOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Concert")
                    .version("1.0.0")
                    .description("Concert API")
            )
    }
}