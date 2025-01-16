//package com.lec.tx;
//
////import java.sql.Connection;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.*;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//
//@Repository //DAO에만 붙인다.
//public class BoardDAO {
//	@Autowired
//	SqlSession session;
//	//BasicDataSource ds;
//	//DataSource ds;
//	
//	public List<MyBoardVO> boardList() { 
//		
//		System.out.println("DAO_select 호출");
//		
//		return session.selectList("boardspace.boardList");
//	}
//	
//	public MyBoardVO boardDetail(int bseq) {
//		System.out.println("DAO_detail 호출");
//		
//		return session.selectOne("boardspace.boardDetail", bseq);
//	}
//	
//	public int boardInsert(MyBoardVO bvo) {
//		System.out.println("DAO_insert 호출");
//		
//		return session.insert("boardspace.boardInsert", bvo);
//	}
//	
//	public int boardUpdate(MyBoardVO bvo) {
//
//		System.out.println("DAO_update 호출");		
//		//TODO
//		return session.update("boardspace.boardUpdate", bvo);	
//	}
//	
//	public int boardDelete(int bseq) {
//		System.out.println("DAO_delete 호출");
//		
//		return session.delete("boardspace.boardDelete", bseq);
//	}
//	
//}
//
