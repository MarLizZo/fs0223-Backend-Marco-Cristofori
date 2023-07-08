package com.epicode.Main;

public class ExitException extends Exception {
	String message;
	
	public ExitException(String _message) {
		this.message = _message;
	}
}
