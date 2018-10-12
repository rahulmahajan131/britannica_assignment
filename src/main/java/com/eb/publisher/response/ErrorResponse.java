package com.eb.publisher.response;
/**
 * This Object used to wrap the error message for response.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 10-12-2018
 */
public class ErrorResponse{

	private String message;
	
	private int code;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}