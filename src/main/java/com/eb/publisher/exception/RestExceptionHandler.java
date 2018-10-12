package com.eb.publisher.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eb.publisher.response.ErrorResponse;

/**
 * <h1>Rest Exception Handler</h1> is used to catch the validation failed
 * exception and send customized response.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 10-12-2018
 */
@ControllerAdvice()
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Exception thrown when
	 * {@link org.springframework.validation.annotation.Validated} is used in
	 * controller. This handler get called when validation got failed in
	 * controller.
	 * 
	 * @param ex
	 * @param request
	 * @return errorResponse {@link ErrorResponse}
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		try {
			List<String> messages = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
					.collect(Collectors.toList());
			String errorMessage = (messages != null && !messages.isEmpty()) ? messages.get(0) : "Invalid class name";
			errorResponse.setMessage(errorMessage);
			errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_XML)
					.body(errorResponse);
		} catch (Exception e) {
			errorResponse.setMessage(e.getMessage());
			errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_XML)
					.body(errorResponse);
		}
	}

	/**
	 * This handler used to handle custom generated API exception and send a
	 * customized response to user.
	 * 
	 * @param ex
	 * @param request
	 * @return errorResponse {@link ErrorResponse}
	 */
	@ExceptionHandler(EBPublisherAPIException.class)
	protected ResponseEntity<?> handleEBPublisherAPIException(EBPublisherAPIException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		try {
			;
			errorResponse.setMessage(ex.getMessage() != null ? ex.getMessage() : "400 Bad Request");
			errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_XML)
					.body(errorResponse);
		} catch (Exception e) {
			errorResponse.setMessage(ex.getMessage());
			errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_XML)
					.body(errorResponse);
		}
	}
}