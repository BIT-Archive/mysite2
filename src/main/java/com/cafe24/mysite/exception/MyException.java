package com.cafe24.mysite.exception;

public class MyException extends Exception{

	
	public MyException() {
		super("MyException Occurs...");
	}
	
	public MyException(String msg) {
		super(msg);
	}
}
