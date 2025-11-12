package com.deliveryapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//to handle exceptions across all controllers
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

//	@Override
//	protected ResponseEntity<Object> handleHandlerMethodValidationException(HandlerMethodValidationException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		LocalDateTime timestamp = LocalDateTime.now();
//		int statusCode = status.value();
//		String error = "other Exception "+ ex.getMessage(); 
//		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,ex.getMessage(),error);
//		return ResponseEntity.status(status.value()).body(apiErrors);
//	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value();
		String error = "Method not supported "+ status; 
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,ex.getMessage(),error);
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value();
		String error = "Media Type not supported "+ status; 
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,ex.getMessage(),error);
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value();
		String error = "Path variable is missing "+ status; 
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,ex.getMessage(),error);
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value();
		String error = "Request Parameter is missing "+ status; 
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,ex.getMessage(),error);
		return ResponseEntity.status(status).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value();
		String error = "Data type mismatch "+ status; 
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,ex.getMessage(),error);
		return ResponseEntity.status(status).body(apiErrors);
	}

	//user-defined exception
	@ExceptionHandler(value = RestaurantNotFoundException.class)
	public ResponseEntity<ApiErrors> handleException(RestaurantNotFoundException ex){
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
		String error = "Data type mismatch "+ statusCode; 
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,ex.getMessage(),error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiErrors);
	}
	
	//user-defined exception
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiErrors> handleException(Exception ex){
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String error = "other "+ex.getMessage(); 
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,ex.getMessage(),error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(apiErrors);
	}
	
	
	
}
