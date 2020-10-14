package com.sumit.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import lombok.Getter;
@Getter
public class ResponseException {
	
	private Date timestamp;
	private String message;
	private String details;
	public ResponseException(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	

}
