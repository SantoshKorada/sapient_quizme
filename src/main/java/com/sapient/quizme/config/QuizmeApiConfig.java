package com.sapient.quizme.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "quizme.api")
public class QuizmeApiConfig {

	private String nytimes;
	private String guardian;

}
