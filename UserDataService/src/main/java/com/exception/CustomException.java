package com.exception;

public class CustomException extends Exception{

	private String message;
	public CustomException(String message) {
		super(message);
		this.message = message;
	}
	
	public String toString() {
		return "Error : "+message;
	}
}
