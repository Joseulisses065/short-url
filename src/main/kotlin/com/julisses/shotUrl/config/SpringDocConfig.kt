package com.julisses.shotUrl.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfig {
    @Bean
    fun gatOpenApi():OpenAPI {
        return OpenAPI().info(Info()
            .title("ShotUrl-API")
            .description("ShotUrl API Documentation")
            .version("v1")
            .license(License().name("Apache 2.0").url("http://springdoc.org")))
    }

    }
