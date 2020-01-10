package com.hacking.memeservice;

import com.hacking.memeservice.Meme;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * Resources
 * 
 * Creating a command-line tool to send REST requests
 * https://spring.io/guides/gs/consuming-rest/ Sending GETs with a list in Java
 * https://www.baeldung.com/spring-rest-template-list
 */

@Slf4j
@SpringBootApplication
public class DemoApplication {

	// TODO: Update these values to be your name and email address
	// Otherwise you won't get credit for solving the puzzles :(
	private static final String STUDENT_NAME = "test";

	private static final String STUDENT_EMAIL = "example@email.com";

	// Entry point to a Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Spring Boot uses Rest Templates (or newer, Web Clients) to
	// connect to external services
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.rootUri("https://memeservice.cfapps.io/api").build();
	}

	// The main applicaton, this is your script
	// Run this by entering `mvn spring-boot:run` into the terminal
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

		return args -> {
			log.info("Running the Demo Application");
		};
	}

	// Helper method to help you get the memes
	private Meme[] getMemes(RestTemplate restTemplate) {
		log.info("GETting a list of Memes");

		return restTemplate.getForObject("/memes", Meme[].class);
	}

	// Helper method that posts a list to the service
	private void postMemeList(RestTemplate restTemplate, Meme[] memes) {
		log.info("POSTing a list of Memes");

		HttpHeaders headers = new HttpHeaders();
		headers.add("studentName", STUDENT_NAME);
		headers.add("studentEmail", STUDENT_EMAIL);

		HttpEntity<Meme[]> request = new HttpEntity<Meme[]>(memes, headers);

		try {
			restTemplate.postForObject("/challenges/filter", request, Void.class);
		} catch (BadRequest e) {
			// If you have the wrong answer, it will be caught and logged here
			log.error(e.getLocalizedMessage());
		}

		log.info("Recieved a success from the Meme Service (200 OK)");

	}

	// Helper method that posts an integer to the service
	private void postInteger(RestTemplate restTemplate, int integer) {
		// TODO: Implement this using postMemeList as a reference
	}

}
