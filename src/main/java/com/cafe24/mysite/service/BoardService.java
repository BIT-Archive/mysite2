package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public BoardVo getPost(int no) {
		return boardDao.getPost(no);
	}
	
	public BoardVo getGroup(int no) {
		return boardDao.getGroup(no);
	}
	
	public List<BoardVo> getList(){
		return boardDao.getList();
	}

	public void write_post(BoardVo boardVo) {
		boardDao.write_post(boardVo);
	}

	public void modify_post(BoardVo boardVo) {
		boardDao.modify_post(boardVo);
		
	}

	public void delete(BoardVo boardVo) {
		boardDao.delete(boardVo);
	}

	public void write_reply(BoardVo boardVo) {
		boardDao.write_reply(boardVo);
		
	}

	public void update_order(BoardVo boardVo) {
		boardDao.update_order(boardVo);
	}


}
