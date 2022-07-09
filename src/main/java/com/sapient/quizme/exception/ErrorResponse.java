package com.sapient.quizme.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

	private String timestamp;
	private int status;
	private String error;
	private String message;
	private String apiPath;
}
