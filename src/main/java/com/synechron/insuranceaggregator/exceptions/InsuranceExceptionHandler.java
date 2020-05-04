package com.synechron.insuranceaggregator.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import net.minidev.json.JSONObject;

@ControllerAdvice
public class InsuranceExceptionHandler {

	@ExceptionHandler(value = { CustomException.class })
	public ResponseEntity<Object> customException(CustomException ex, WebRequest request) {
		String message = "Exception occured";

		ApiExceptoin exceptionMessage = new ApiExceptoin(HttpStatus.INTERNAL_SERVER_ERROR, message, ex);

		return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
		String message = "Invalid records found";
		ApiExceptoin exceptionMessage = new ApiExceptoin(HttpStatus.BAD_REQUEST, message, ex);

		JSONObject errors = new JSONObject();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		exceptionMessage.setDebugMessage(errors.toString());

		return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleInvalidRecordsExceptions(HttpMessageNotReadableException ex) {
		String message = "Invalid records found";
		ApiExceptoin exceptionMessage = new ApiExceptoin(HttpStatus.BAD_REQUEST, message, ex);

		exceptionMessage.setDebugMessage(ex.getCause().getCause().getLocalizedMessage());

		return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
