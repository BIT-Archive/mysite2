package com.cafe24.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.getList();
		
		model.addAttribute("list", list);
		
		return "guestbook/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(@ModelAttribute GuestbookVo vo) {
		
		guestbookService.insert(vo);
		
		return "redirect:/guestbook/list";
	}
	
	
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam(value="no", required=true) Long no) {
		
		GuestbookVo vo = guestbookService.get(no);
		model.addAttribute("vo", vo);
		
		return "guestbook/delete";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo) {

		if(guestbookService.delete(vo)) {
			return "redirect:/guestbook/list";
		}
		
		return "guestbook/delete";
	}

}
