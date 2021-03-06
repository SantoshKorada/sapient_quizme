package com.sapient.quizme.response;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsSearchResponse {

	private JsonNode nytimesResponse;
	private JsonNode guardianResponse;

}
