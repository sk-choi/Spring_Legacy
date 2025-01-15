package com.lec.tx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TxServiceImpl implements TxService{
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public void svcInsert(MyBoardVO bvo)  {
		System.out.println("Service svcInsert()호출");
		int row = dao.svcInsert(bvo);
		dao.svcInsert(bvo);
		dao.svcInsert(bvo);
		                
		System.out.println(row + "건 입력");
	}
	
	@Override
	public List<MyBoardVO> svcSelect(){
		System.out.println("Service svcSelect()호출");
		//ArrayList<MyBoardVO> list =  new ArrayList<MyBoardVO>();
		return dao.svcSelect();
		//return list;
	}

	
}
