package com.projet_API.tp5;

import com.projet_API.tp5.model.AddressApi;
import jdk.internal.instrumentation.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Tp5Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp5Application.class, args);
	}
}
