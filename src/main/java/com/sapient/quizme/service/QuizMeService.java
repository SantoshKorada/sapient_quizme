package com.sapient.quizme.service;

import com.sapient.quizme.response.NewsSearchResponse;

public interface QuizMeService {

	public NewsSearchResponse fetchNewsSearchResponse(String query);
}
