package com.ezen.movie.comm;

@SuppressWarnings("serial")
public class ValueException extends Exception {

	public ValueException() {
		
	}

	public ValueException(String message) {
		super(message);
		System.err.println(message);
	}
	
}
