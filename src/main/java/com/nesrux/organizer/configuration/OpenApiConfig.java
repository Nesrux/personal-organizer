package com.nesrux.organizer.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "organizer API",
                version = "v1",
                description = "API for task management",
                license = @License(
                        name = "MIT",
                        url = "https://github.com/Nesrux/personal-organizer?tab=MIT-1-ov-file#readme"
                ),
                contact = @Contact(
                        name = "João marcos",
                        email = "joaomarcosdevs@gmail.com",
                        url = "https://www.linkedin.com/in/joaomarcosdev/"
                )
        )
)
public class OpenApiConfig {
}
