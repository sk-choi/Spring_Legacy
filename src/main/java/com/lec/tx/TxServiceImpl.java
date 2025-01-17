package com.lec.tx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.tx.mapper.BoardMapper;
import com.lec.tx.mapper.TestMapper;

@Service
public class TxServiceImpl implements TxService{
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	TestMapper tmapper;
	
	public void svcTest() {
		System.out.println("______Service.svcTest() 호출");
		
		MyBoardVO bvo = new MyBoardVO();
		bvo.setTitle("테스트 제목");
		//bvo.setContents("테스트 내용");
		bvo.setRegid("테스트 내용");
		
		int rows = 0;
		
		rows = tmapper.insertKeyTest11(bvo);
		tmapper.insertKeyTest11(bvo);
		
		System.out.println(rows + "건 테스트 11 입력 --- 방금 전 들어간 bseq:" + bvo.getBseq());
		
		rows = tmapper.insertKeyTest22(bvo);
		System.out.println(rows + "건 테스트 11 입력 --- 방금 전 들어간 bseq:" + bvo.getBseq());
		
		MyBoardVO bvo2 = tmapper.selectTest33(3);
		System.out.println(bvo2.toString());
		
		MyBoardVO res = tmapper.boardAndReply(3);
		System.out.println(res.getBseq() + "," + res.getTitle());
		for (MyreplyVO rvo : res.getRlist()) {
			System.out.println(rvo.getRseq() + "," + rvo.getReply());
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchGubun", "regid");
		map.put("searchStr", "%kim%");
		List<MyBoardVO> list = tmapper.boardListBySearch11(map);
		
		//List<MyBoardVO> list = tmapper.boardListBySearch33(5, "kim");
		System.out.println(list.size());
	}
	
	public void svcInsertRuntimeErrorFunc(MyBoardVO bvo) throws RuntimeException {
		mapper.boardInsert(bvo);
		mapper.boardInsert(bvo);
		System.err.println("----------------- 모두 롤백처리 됨 ----------------");
		throw new RuntimeException("RuntimeException(Unchecked Exception) -- TxServiceImpl.svcInsertRuntimeErrorFunc() 강제 에러 발생");
	}
	public void svcInsertSQLErrorFunc(MyBoardVO bvo) throws SQLException {
		mapper.boardInsert(bvo);
		mapper.boardInsert(bvo);
		System.err.println("----------------- 모두 롤백처리 됨 ----------------");
		throw new SQLException("SQLException(Checked Exception) -- TxServiceImpl.svcInsertSQLErrorFunc() 강제 에러 발생");
	}
	
	
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
