package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getList(){
		return guestbookDao.getList();
	}

	public GuestbookVo get(Long no) {
		return guestbookDao.get(no);
	}
	
	public void insert(GuestbookVo vo) {
		guestbookDao.insert(vo);
	}

	public boolean delete(GuestbookVo vo) {
		return guestbookDao.delete(vo);
	}

}
