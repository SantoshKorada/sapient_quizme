package com.sapient.quizme.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.sapient.quizme.config.QuizmeApiConfig;
import com.sapient.quizme.service.NewsService;
import com.sapient.quizme.util.QuizmeJsonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NewsServiceImpl implements NewsService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	QuizmeApiConfig quizmeApiConfig;

	@Override
	public JsonNode getNytimesNews(String query) {
		// TODO Auto-generated method stub
		String nytimesAPI = quizmeApiConfig.getNytimes();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(nytimesAPI);
		Map<String, String> urlparams = new HashMap<String, String>();
		urlparams.put("query", query);
		nytimesAPI = builder.buildAndExpand(urlparams).encode().toUriString();
		log.info("Generated Nytimes URL :: {}", nytimesAPI);
		HttpHeaders httpHeaders = httpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<String> responseEntity = restTemplate.exchange(nytimesAPI, HttpMethod.GET, httpEntity,
				String.class);
		restTemplate.getForObject(nytimesAPI, String.class);
		log.info("Nytime API Status :: {} ", responseEntity.getStatusCode());
		return QuizmeJsonUtil.convertStringToJson(responseEntity.getBody());
	}

	@Override
	public JsonNode getGuardianNews(String query) {
		// TODO Auto-generated method stub
		String guardianAPI = quizmeApiConfig.getGuardian();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(guardianAPI);
		Map<String, String> urlparams = new HashMap<String, String>();
		urlparams.put("query", query);
		guardianAPI = builder.buildAndExpand(urlparams).encode().toUriString();
		log.info("Generated GuardianAPI URL :: {}", guardianAPI);
		HttpHeaders httpHeaders = httpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<String> responseEntity = restTemplate.exchange(guardianAPI, HttpMethod.GET, httpEntity,
				String.class);
		restTemplate.getForObject(guardianAPI, String.class);
		log.info("Guardian API Status :: {} ", responseEntity.getStatusCode());
		return QuizmeJsonUtil.convertStringToJson(responseEntity.getBody());

	}

	private HttpHeaders httpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json;charset=utf-8");
		headers.set("Accept", "*/*");
		return headers;
	}

}
