package com.cafe24.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.UserVo;

@Repository
public class UserDao {
	
	
	
	public UserDao() {
		System.out.println("UserDAO constructor");
	}

	public UserVo get(Long no){
		UserVo result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "select no, name, email from user where no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				Long num = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				
				result = new UserVo();
				
				result.setNo(num);
				result.setName(name);
				result.setEmail(email);
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return result;
	}
	
	public UserVo get(String email, String password){
		UserVo result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "select no, name, email from user where email=? and password=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String mail = rs.getString(3);
				
				result = new UserVo();
				
				result.setNo(no);
				result.setName(name);
				result.setEmail(mail);
				
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return result;
	}	
	
	public boolean insert(UserVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql ="insert into user values(null,?,?,?,?, now() )";
			
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getGender());

			int count = psmt.executeUpdate();
			result = count == 1;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error:"+ e);
		} finally {
			try {
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean update(UserVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql ="update user set name=?, email=?, password=?, gender=? where no=?";
			
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getGender());
			
			psmt.setLong(5, vo.getNo());

			int count = psmt.executeUpdate();
			result = count == 1;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error:"+ e);
		} finally {
			try {
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
		
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.56:3307/guestbook";
			conn = DriverManager.getConnection(url, "guestbook", "guestbook");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}

	public boolean update(Long userNo, UserVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql ="update user set name=?, email=?, password=?, gender=? where no=?";
			
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getGender());
			
			psmt.setLong(5, userNo);

			int count = psmt.executeUpdate();
			result = count == 1;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error:"+ e);
		} finally {
			try {
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
		
		
	}

	

}
