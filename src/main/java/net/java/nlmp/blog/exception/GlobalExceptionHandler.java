package net.java.nlmp.blog.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import net.java.nlmp.blog.payload.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler{

	// handle specific exception and global excetiom
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFouncException(ResourceNotFoundException exception,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, new Date(), exception.getMessage(),
				webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
				
	}
	
	@ExceptionHandler(BlogAPIException.class)
	public ResponseEntity<ErrorDetails> handlerBlogAPIException(BlogAPIException exception,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, new Date(), exception.getMessage(),
				webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
				
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handlerException(Exception exception,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, new Date(), exception.getMessage(),
				webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	
				
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDetails> handlerException(AccessDeniedException exception,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.UNAUTHORIZED, new Date(), exception.getMessage(),
				webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.UNAUTHORIZED);
	
				
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
	    Map<String,String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error)->{
	      String fieldName =((FieldError)error).getField();
	      String message = error.getDefaultMessage();
	      errors.put(fieldName,message);
	    		  });
	    return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	    }
	

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerException(UsernameNotFoundException exception,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.UNAUTHORIZED, new Date(), exception.getMessage(),
				webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.UNAUTHORIZED);
	
				
	}
	

}
