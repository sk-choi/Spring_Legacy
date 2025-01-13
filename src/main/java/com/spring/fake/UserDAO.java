package com.spring.fake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	public UserVO getUser(UserVO vo) {
		try {
			conn = DBManager.getConnection();
			String sql = "select name from mvcuser where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setName(rs.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return vo;
	}
}
