package com.sapient.quizme.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.quizme.response.NewsSearchResponse;
import com.sapient.quizme.service.QuizMeService;

@WebMvcTest(QuizMeControllerTest.class)
public class QuizMeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	QuizMeService quizMeService;
	@Autowired
	ObjectMapper mapper;

	@Test
	public void getNews_fail() throws Exception {
		NewsSearchResponse newsSearchResponse = NewsSearchResponse.builder().build();
		Mockito.when(quizMeService.fetchNewsSearchResponse("apple")).thenReturn(newsSearchResponse);

		mockMvc.perform(
				MockMvcRequestBuilders.get("/quizme/LocalDateTime/apple").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());

	}

}
