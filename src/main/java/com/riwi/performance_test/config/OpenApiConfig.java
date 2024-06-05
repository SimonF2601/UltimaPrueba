package com.riwi.performance_test.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Swagger Configuration
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Riwi's Api for digital course configuration", version = "1.0", description = "API documentation. Lovelace Performance Test"))
public class OpenApiConfig {

}
