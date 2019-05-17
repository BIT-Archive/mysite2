package com.cafe24.mysite.exception;

public class MyClassTest {
	
	public static void main(String[] args) {
		try {
			
			Myclass myClass = new Myclass();
			myClass.dangerousMethod(); //jdbc설정할때랑 비슷하다ㅏ
			
		}catch(MyException e) {
			e.printStackTrace();
		}
		
	}

}
