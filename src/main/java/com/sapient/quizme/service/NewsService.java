package com.sapient.quizme.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface NewsService {

	public JsonNode getNytimesNews(String query);

	public JsonNode getGuardianNews(String query);

}
