package com.lec.tx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lec.tx.MyBoardVO;

@Repository
@Mapper
public interface BoardMapper {
	
	public List<MyBoardVO>boardList();
	public MyBoardVO boardDetail(int bseq);
	public int boardInsert(MyBoardVO bvo);
	public int boardUpdate(MyBoardVO bvo);
	public int boardDelete(int bseq);
}
//-----------------------------------------------

//public List<MyBoardVO> boardList() { 
//		
//		System.out.println("DAO_select 호출");
//		
//		return session.selectList(".boardList");
//	}
//	
//	public MyBoardVO boardDetail(int bseq) {
//		System.out.println("DAO_detail 호출");
//		
//		return session.selectOne(".boardDetail", bseq);
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
//}