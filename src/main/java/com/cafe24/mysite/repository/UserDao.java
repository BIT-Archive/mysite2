package com.cafe24.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.exception.UserDAOException;
import com.cafe24.mysite.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private DataSource datasource;
	
	public UserDao() {
		System.out.println("UserDAO constructor");
	}
	
	
	
	/***** UserGet By UserNo ****/
	public UserVo get(Long no) {
		UserVo vo = sqlSession.selectOne("user.getByNo", no);
		return vo;
	}
	
	
	/***** UserGet By Email And PassWord ****/
	public UserVo get(String email, String password) throws UserDAOException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		
		UserVo userVo = sqlSession.selectOne("user.getByEmailAndPassword", map);
		
		return userVo;
	}
	
	/***** User JOIN ****/
	public boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		System.out.println(vo);
		return 1==count;
	}
	
	/***** User to UPDATE VO ****/
	public boolean update(UserVo vo) {
		System.out.println("User VO before update" + vo);
		int count = sqlSession.update("user.update", vo);
		System.out.println(vo);
		
		return 1==count;
	}
	
}
