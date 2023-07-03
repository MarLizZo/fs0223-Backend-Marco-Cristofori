package com.epicode.ex_3;

public class BancaException extends Exception {
	private String message;
	public BancaException(String msg) {
		super(msg);
		this.message = msg;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}
