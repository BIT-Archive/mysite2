package com.cafe24.mysite.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private SqlSession sqlSession;
	
	public BoardVo getPost(int no) {
		BoardVo vo = sqlSession.selectOne("board.getByNo", no);
		return vo;
	}

	public List<BoardVo> getList() {
		List<BoardVo> list = sqlSession.selectList("board.getList");
		return list;
	}

	public boolean write_post(BoardVo boardVo) {
		
		int count = sqlSession.insert("board.insert_post", boardVo);
		
		return 1==count;
		
	}

	public boolean modify_post(BoardVo boardVo) {
		
		int count = sqlSession.update("board.update_post", boardVo);
		
		return 1==count;
	}

	public BoardVo getGroup(int no) {
		BoardVo vo = sqlSession.selectOne("board.getGroup", no);
		return vo;
	}

	public void delete(BoardVo boardVo) {
		sqlSession.update("board.delete", boardVo);
		
	}

	public boolean write_reply(BoardVo boardVo) {
		int count = sqlSession.insert("board.insert_reply", boardVo);
		
		return 1==count;
	}

	public void update_order(BoardVo boardVo) {
		sqlSession.update("board.update_order", boardVo);
	}

}
