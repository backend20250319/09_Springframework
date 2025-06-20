package com.ohgiraffers.restapi.section05.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(swaggerinfo());
    }

    private Info swaggerinfo() {
        return new Info()
                .title("ohgiraffers API")
                .description("Spring Boot Swagger 연동 테스트")
                .version("1.0.0");
    }
}
