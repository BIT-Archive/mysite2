package com.cafe24.mysite.exception;

public class Myclass {
	public void dangerousMethod() throws MyException{
		System.out.println("Normal State1");
		
		boolean isDanger = true;
		if(isDanger) {
			
			
			throw new MyException();
		}
		
		
		System.out.println("Normal State2");
		
	}
}
