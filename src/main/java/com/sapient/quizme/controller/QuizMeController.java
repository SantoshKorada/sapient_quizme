package com.sapient.quizme.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.quizme.response.NewsSearchResponse;
import com.sapient.quizme.service.QuizMeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("quizme")
@Slf4j
public class QuizMeController {

	@Autowired
	QuizMeService quizMeService;

	@GetMapping("news-search/{query}")
	public ResponseEntity<NewsSearchResponse> newsSearch(@PathVariable("query") String query) {
		long startTime = System.currentTimeMillis();
		log.info("***** News Search API at :: {} *****",
				DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
		NewsSearchResponse newsSearchResponse = quizMeService.fetchNewsSearchResponse(query);
		long duration = System.currentTimeMillis() - startTime;
		log.info("***** Time taken to process the News Search API :: {} minutes {} seconds *****",
				(duration / 1000) / 60, (duration / 1000) % 60);
		return new ResponseEntity<NewsSearchResponse>(newsSearchResponse, HttpStatus.OK);
	}

	@GetMapping("test")
	public String test() {
		return "News Search API";
	}

}
