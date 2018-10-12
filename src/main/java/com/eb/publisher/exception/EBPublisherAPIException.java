package com.eb.publisher.exception;
/**
 * <h1>EBPublisherAPIException</h1> This is custom exception for publisher API.
 *  
 * @author Rahul Mahajan
 * @version 1.0
 * @since 10-12-2018
 *
 */

public class EBPublisherAPIException extends Exception {

	private static final long serialVersionUID = 1L;

	public EBPublisherAPIException(String message,Throwable cause){
		super(message,cause);
	}

	public EBPublisherAPIException(String message){
		super(message);
	}
}
