package ru.innopolis.attestation3.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
   @Bean
    public OpenAPI openApiProjectConfig(){
    return new OpenAPI()
            .info(new Info()
                            .title("Мой проект - Помощь врачу")
                            .description("Сервис ведения медецинских карт пациентов")
                            .version("1.0.0")
                            .license(new License().name("Apache Free License 2.0"))
                            .contact(new Contact().name("Larisa Babaeva")
                                    .email("book-29@mail.ru"))
                    );
    }
}
