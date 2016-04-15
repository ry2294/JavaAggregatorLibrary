package com.aggregatorlibrary.exceptions;

@SuppressWarnings("serial")
public class CyclicGraphException extends RuntimeException {

	public CyclicGraphException() {
	}

	public CyclicGraphException(String message) {
		super(message);
	}

	public CyclicGraphException(Throwable cause) {
		super(cause);
	}

	public CyclicGraphException(String message, Throwable cause) {
		super(message, cause);
	}

	public CyclicGraphException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
