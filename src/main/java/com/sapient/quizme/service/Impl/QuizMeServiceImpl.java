package com.sapient.quizme.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.quizme.exception.QuizMeException;
import com.sapient.quizme.response.NewsSearchResponse;
import com.sapient.quizme.service.NewsService;
import com.sapient.quizme.service.QuizMeService;

@Service
public class QuizMeServiceImpl implements QuizMeService {

	@Autowired
	NewsService newsService;

	@Override
	public NewsSearchResponse fetchNewsSearchResponse(String query) {
		// TODO Auto-generated method stub
		if (query.equals(null)) {
			throw new QuizMeException("Empty Query");
		}
		NewsSearchResponse newsSearchResponse = NewsSearchResponse.builder()
				.nytimesResponse(newsService.getNytimesNews(query)).guardianResponse(newsService.getGuardianNews(query))
				.build();
		return newsSearchResponse;
	}

}
