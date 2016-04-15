package com.aggregatorlibrary.exceptions;

@SuppressWarnings("serial")
public class CyclicGraphException extends RuntimeException {

	public CyclicGraphException() {
		// TODO Auto-generated constructor stub
	}

	public CyclicGraphException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CyclicGraphException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CyclicGraphException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CyclicGraphException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
