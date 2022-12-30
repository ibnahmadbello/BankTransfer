package com.arab.banktransfer.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransferErrorService {
	
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<String> handleRunTimeException(RuntimeException e){
		return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
	}
	
	
	private ResponseEntity<String> error(HttpStatus status, Exception exception){
		System.out.println("Exception : " + exception);
		return ResponseEntity.status(status).body(exception.getMessage());
	}
	
}
