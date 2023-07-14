package net.java.nlmp.blog.payload;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	
	private HttpStatus httpStatus;
	private Date timestamp;
	private String message;
	private String errorDetails;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(HttpStatus httpStatus, Date timestamp, String message, String errorDetails) {
		super();
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	

}
