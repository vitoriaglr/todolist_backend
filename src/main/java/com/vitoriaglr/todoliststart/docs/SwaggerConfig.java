package com.vitoriaglr.todoliststart.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {

    @Bean
    public OpenAPI springTodoListOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("Todo Application")
                .description("Aplicação gerenciadora de tarefas")
                .version("1.0.0"));
    }
}