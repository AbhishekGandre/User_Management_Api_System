package com.example.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class ErrorClass {
	
	

	public ErrorClass() {
		// TODO Auto-generated constructor stub
	}
		String message;
		int errorCode;
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public int getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}
		
		
}

@Configuration
class ErrorBeanConfigure{
	
	@Bean
	ErrorClass errorClass() {
	return new ErrorClass();
	}
	
}
