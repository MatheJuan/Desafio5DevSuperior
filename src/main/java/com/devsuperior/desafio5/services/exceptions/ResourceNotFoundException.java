package com.devsuperior.desafio5.services.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
  
	public ResourceNotFoundException(String message) {
		super(message);
		 
	}

	
}
