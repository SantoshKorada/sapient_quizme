package com.sapient.quizme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/*
 * public class SapientQuizmeApplication extends SpringBootServletInitializer {
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(SapientQuizmeApplication.class, args); }
 * 
 * @Override protected SpringApplicationBuilder
 * configure(SpringApplicationBuilder builder) { return
 * builder.sources(SapientQuizmeApplication.class); }
 * 
 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
 * 
 * }
 */
public class SapientQuizmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SapientQuizmeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
