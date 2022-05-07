package com.fullexample.all.exceptionhandling;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import net.bytebuddy.matcher.MethodExceptionTypeMatcher;
@RestControllerAdvice
public class ExceptionHandlerClass {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> ExceptionNulpointer(NullPointerException n)
	{
		return new ResponseEntity<>("No data found", HttpStatus.NOT_FOUND);
	}

}
