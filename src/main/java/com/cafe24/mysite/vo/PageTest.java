package com.cafe24.mysite.vo;

import java.util.Scanner;

public class PageTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 페이지 번호 입력");
		int currentPage = sc.nextInt();
		int perPage = 5;
		
		int start = 0;
		int end = 0;
		
		start = ((int) Math.floor((currentPage-1)/perPage)*perPage)+1;;
		end	  = start+(perPage-1);
		
		System.out.println("start : "+ start);
		System.out.println("end : "+ end);
		sc.close();
	}

}
