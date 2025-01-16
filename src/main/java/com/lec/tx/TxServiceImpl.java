package com.lec.tx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.tx.mapper.BoardMapper;

@Service
public class TxServiceImpl implements TxService{
	
	@Autowired
	BoardMapper mapper;
	
	@Override
	public void svcInsert(MyBoardVO bvo)  {
		System.out.println("Service svcInsert()호출");
		//int row = dao.boardInsert(bvo);
		int row = mapper.boardInsert(bvo);
//		dao.svcInsert(bvo);
//		dao.svcInsert(bvo); //강제 에러 유발
		                
		System.out.println(row + "건 입력");
	}
	
	@Override
	public MyBoardVO svcDetail(int vbseq) {
		// TODO Auto-generated method stub
		
		//MyBoardVO bvo = dao.boardDetail(vbseq);
		MyBoardVO bvo = mapper.boardDetail(vbseq);
		
		return bvo;
	}
	
	@Override
	public List<MyBoardVO> svcSelect(){
		System.out.println("Service svcSelect()호출");
		//List<MyBoardVO> blist = dao.boardList();
		List<MyBoardVO> blist = mapper.boardList();
		//ArrayList<MyBoardVO> list =  new ArrayList<MyBoardVO>();
		return blist;
		//return list;
	}

	@Override
	public void svcUpdate(MyBoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("Service svcUpdate()호출");
		//dao.boardUpdate(bvo);
		mapper.boardUpdate(bvo);
	}

	@Override
	public void svcDelete(int bseq) {
		// TODO Auto-generated method stub
		System.out.println("Service svcDelete()호출");
		//dao.boardDelete(bseq);
		mapper.boardDelete(bseq);
		
	}

}
