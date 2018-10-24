package com.be.demo.common.exceptions;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ CustomException.class })
	@ResponseBody
	public ResponseEntity<?> handleCustomException(CustomException e) {
		return response(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ResponseEntity<?> handleAnyException(Exception e) {
		String uuid = UUID.randomUUID().toString();
		CustomUnexpectedException cu = new CustomUnexpectedException(uuid, "Server Hata");
		e.printStackTrace();
		return response(cu, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	protected <T> ResponseEntity<T> response(T body, HttpStatus status) {
		return new ResponseEntity<>(body, new HttpHeaders(), status);
	}
}
