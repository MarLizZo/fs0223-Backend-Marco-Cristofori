package com.epicode.Main;

public class ExitException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;
	
	public ExitException(String _message) {
		super();
		this.message = _message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
