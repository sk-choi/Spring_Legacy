package com.lec.tx.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lec.tx.MyBoardVO;

public interface TestMapper {
	public int insertKeyTest11(MyBoardVO bvo);
	public int insertKeyTest22(MyBoardVO bvo);
	public MyBoardVO selectTest33(int bseq);
	public MyBoardVO boardAndReply(int bseq);
	List<MyBoardVO> boardListBySearch11(Map map);
	List<MyBoardVO> boardListBySearch22(Map map);
	List<MyBoardVO> boardListBySearch33(@Param("bseq") int bseq, @Param("regid") String regid);
	List<MyBoardVO> boardListBySQL();
	List<MyBoardVO> testCdata();
}
