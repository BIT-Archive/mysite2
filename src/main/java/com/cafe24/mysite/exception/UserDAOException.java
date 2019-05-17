package com.cafe24.mysite.exception;

public class UserDAOException extends RuntimeException{
	
	public UserDAOException() {
		super("UserDAOException Occur!");
	}
	
	public UserDAOException(String msg) {
		super(msg);
	}

}
