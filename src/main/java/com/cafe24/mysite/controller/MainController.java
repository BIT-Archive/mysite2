package com.cafe24.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.vo.UserVo;

@Controller
public class MainController {
	
	
	@RequestMapping({"/","/main"})
	public String main() {
		return "main/index";
	}
	
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "<h1>안녕하세여</h1>";
	}

	@RequestMapping("/json")
	public @ResponseBody UserVo json() {
		
		UserVo vo = new UserVo();
		vo.setNo(3L);
		vo.setEmail("redgee49@gmail.com");
		vo.setGender("male");
		vo.setName("harry");
		vo.setPassword("1234567");
		
		return vo;
	}

}
