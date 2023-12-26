package com.myaccessweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(
		title = "MyAccessWeb",
		version = "1.0.0",
		description = "This is my first personal project using Spring Framework.\n * This API is an access control for use in residential or commercial buildings.\n * It is used to control the entry and exit of people and vehicles.",
		termsOfService = "http://swagger.io/terms/",
		contact = @Contact(name = "Bruno M. Soares", email = "brunomourasoares@gmail.com", url = ""),
		license = @License(name	= "License Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
	),
	externalDocs = @ExternalDocumentation(description = "Find out more about Swagger", url = "http://swagger.io"),
	servers = @Server(url = "http://localhost:8080/", description = "Test Server")
)
@SpringBootApplication
public class MyAccessWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAccessWebApplication.class, args);
	}
}
