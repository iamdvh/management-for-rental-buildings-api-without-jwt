package com.iamdvh.exception;

public class FieldRequiredException extends RuntimeException{
	public FieldRequiredException(String errorMessage) {
		super(errorMessage);
	}
}
