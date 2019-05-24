package com.cafe24.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.service.BoardService;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
//	@Autowired
//	private Page page;
	
	
	@RequestMapping(value= {"/list", ""})
	public String list(HttpSession session, Model model ) {
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		List<BoardVo> list = boardService.getList();
		
		
		model.addAttribute("list", list);
		model.addAttribute("authUser", authUser);
		
		return "board/list";
	}

	@RequestMapping(value= "/view")
	public String view(@RequestParam(value="no", required=true) int no,
										Model model,
										HttpSession session) {
		
		BoardVo vo = boardService.getPost(no);
		
		model.addAttribute("boardVo", vo);
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		model.addAttribute("authUser", authUser);
		
		return "board/view";
	}
	
	
	
	@RequestMapping(value= "/write", method=RequestMethod.GET)
	public String write(HttpSession session, Model model) {

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser == null) {
			return "user/login";
		}
		
		model.addAttribute("authUser", authUser);
		
		return "board/write";
	}
	
	@RequestMapping(value= "/write", method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo) {

		boardService.write_post(boardVo);
		
		return "redirect:/board/list";
	}
	
	@Auth
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(@AuthUser UserVo authUser, 
						 Model model,
						 @RequestParam(value="no", required=true) int no) {
		
		BoardVo boardVo = boardService.getPost(no);
		
		if( authUser == null || authUser.getNo() != boardVo.getUser_no()) {
			return "user/login";
		}
		
		
		
		model.addAttribute("authUser",authUser);
		model.addAttribute("boardVo", boardVo);
		
		return "board/modify";
		
	}

	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute BoardVo vo, Model model) {
		
		boardService.modify_post(vo);
		
		model.addAttribute("boardVo", vo);
		
		return "redirect:/board/view?no="+vo.getNo();
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(value="no" , required=true) int no,
						HttpSession session) {
		
		System.out.println("delete get");

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		BoardVo boardVo = boardService.getGroup(no);
		
		if( authUser == null || authUser.getNo() != boardVo.getUser_no()) {
			return "user/login";
		}
		
		boardService.delete(boardVo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.GET)
	public String reply(HttpSession session, Model model,
						@RequestParam(value="no", required=true) int no) {
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			return "user/login";
		}
		
		BoardVo boardVo = boardService.getPost(no);
		
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("authUser", authUser);

		return "board/reply";
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public String reply(HttpSession session, @ModelAttribute BoardVo boardVo) {
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			return "user/login";
		}
		
		System.out.println("parent : "+boardVo.getParent_no());
		System.out.println("no : "+boardVo.getNo());
		
		boardService.write_reply(boardVo);
		
		boardService.update_order(boardVo);

		return "redirect:/board/list";
	}

}
