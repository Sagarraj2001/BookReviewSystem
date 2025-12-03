package com.backend.Backend.Exception;

public class RecordAlreadyExistsException extends RuntimeException {
	public RecordAlreadyExistsException(String message) {
		super(message);
	}
}
