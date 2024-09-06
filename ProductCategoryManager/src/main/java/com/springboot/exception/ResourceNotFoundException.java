package com.springboot.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5838724299916785889L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}