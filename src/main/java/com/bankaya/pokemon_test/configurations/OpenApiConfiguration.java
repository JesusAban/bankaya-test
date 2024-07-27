package com.bankaya.pokemon_test.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Pokemon Test");

        Contact myContact = new Contact();
        myContact.setName("Jesús Abán");
        myContact.setEmail("jesus.aban.pech@gmail.com");

        Info information = new Info()
                .title("Pokemon Test Api")
                .version("1.0")
                .description("This API exposes endpoints to manage pokemon in test mode.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }

}
