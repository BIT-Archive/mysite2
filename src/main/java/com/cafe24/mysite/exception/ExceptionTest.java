package com.cafe24.mysite.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			int a = 0;
			int k = 1000000/a;
			System.out.println("some codes...");
			System.out.println("more codes 1");
			System.out.println("more codes 2");
		}catch(ArithmeticException e) {
			
			System.out.println("error:"+e);
			
			System.out.println("죄송합니다 예기치않게 종료되었습니다.");

			return;
			
			//안되면 프린트스택.
//			e.printStackTrace();
		}
		

	}

}
