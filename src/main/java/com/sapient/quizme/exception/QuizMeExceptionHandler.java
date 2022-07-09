package com.sapient.quizme.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class QuizMeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(QuizMeException.class)
	public ResponseEntity<ErrorResponse> handleInvalidDunsExceptionHandler(QuizMeException qme, WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.builder()
				.timestamp(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()))
				.status(HttpStatus.BAD_REQUEST.value()).error(HttpStatus.BAD_REQUEST.toString())
				.message(qme.getLocalizedMessage()).apiPath(request.getDescription(false)).build();
		log.error("Error Details :: {}", errorResponse.toString());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
