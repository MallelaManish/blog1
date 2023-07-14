package net.java.nlmp.blog.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException {

	private HttpStatus httpStatus;
	private String message;
	private LocalDate localData;

	public BlogAPIException(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.localData = LocalDate.now();
	}

	public LocalDate getLocalData() {
		return localData;
	}

	public void setLocalData(LocalDate localData) {
		this.localData = localData;
	}

	public BlogAPIException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
