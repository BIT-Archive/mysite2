package com.cafe24.mysite.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptioHandler {


	@ExceptionHandler( Exception.class )
	public void HandlerDAOException( HttpServletRequest request,
									   HttpServletResponse response,
									   Exception e) throws Exception {
		
		//1. 로깅
		e.printStackTrace();
		StringWriter errors = new StringWriter();
		
		e.printStackTrace(new PrintWriter(errors));
		
		//log.error(erros.toString());
		
		System.out.println(errors.toString());

		//2. 안내페이지 가기 + 정상종료
		request.setAttribute("uri", request.getRequestURI());
		request.setAttribute("exception", errors);

		request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, response);
		
	}

	
	
	
}
