package com.campus.springboot_crud_mysql.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> map=new HashMap<String,String>();
		List<FieldError> fieldErrors=ex.getFieldErrors();
		for(FieldError error:fieldErrors) {
			String fieldName=error.getField();
			String fieldMsg=error.getDefaultMessage();
			
			map.put(fieldName, fieldMsg);
		}
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(map);
	}
    
    @ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<?> runtimeExceptionHandler(RuntimeException ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
}
