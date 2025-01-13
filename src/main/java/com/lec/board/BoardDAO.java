package com.lec.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository //DAO에만 붙인다.
public class BoardDAO {
	@Autowired
	DataSource ds;
	
	ArrayList<MyBoardVO> alist = new ArrayList<MyBoardVO>();
	
//	Connection conn = null;
//	PreparedStatement pstmt = null; //sql 점검
//	ResultSet rs = null; //결과 출력
	
	public ArrayList<MyBoardVO> select() {
		Connection conn = null;
		PreparedStatement pstmt = null; //sql 점검
		ResultSet rs = null; //결과 출력
		//DB_conn o = Ch15_conn_oracle.getInstance();
		//TODO
		String sql = "select * from myboard order by bseq asc";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			MyBoardVO empvo = null;
			while(rs.next()) { // 1줄 읽는 것. (반복문으로 여러 줄 읽음)
				int i = 0;
				empvo = new MyBoardVO();
				int bseq = rs.getInt("bseq");
				String title_ = rs.getString("title"); //컬럼명 넣어야 해서 "" 필수
				String contents = rs.getString("contents");
				String regid = rs.getString("regid");
				String regdate = rs.getString("regdate");
				empvo.setBseq(bseq);
				empvo.setTitle(title_);
				empvo.setContents(contents);
				empvo.setRegid(regid);
				empvo.setRegdate(regdate);
				alist.add(empvo);
				
				System.out.println(alist.get(i));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		finally {
//			System.out.println("TODO...dbcp close()......");
//		}
		//o.Close(conn, pstmt, rs);
		System.out.println("--내부 select * done--");
		return alist;
	}
	
	public ArrayList<MyBoardVO> select(int start, int end) {
		
		Connection conn = null;
		PreparedStatement pstmt = null; //sql 점검
		ResultSet rs = null; //결과 출력
		//TODO
		String sql = "select *\r\n"
				+ "from\r\n"
				+ "(\r\n"
				+ "select rownum as rnum, title, contents, regid, regdate\r\n"
				+ "from \r\n"
				+ "(select * from myboard order by bseq asc)\r\n"
				+ ")\r\n"
				+ "where rnum between ? and ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			MyBoardVO empvo = null;
			while(rs.next()) { // 1줄 읽는 것. (반복문으로 여러 줄 읽음)
				int i = 0;
				empvo = new MyBoardVO();
				int bseq = rs.getInt("rnum");
				String title_ = rs.getString("title"); //컬럼명 넣어야 해서 "" 필수
				String contents = rs.getString("contents");
				String regid = rs.getString("regid");
				String regdate = rs.getString("regdate");
				empvo.setBseq(bseq);
				empvo.setTitle(title_);
				empvo.setContents(contents);
				empvo.setRegid(regid);
				empvo.setRegdate(regdate);
				alist.add(empvo);
				
				System.out.println(alist.get(i));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--내부 select * done--");
		return alist;
	}

//	public MyBoardVO select(int bseq) {
//		
//		 DB_conn o = Ch15_conn_oracle.getInstance();
//		
//		//TODO
//		String sql = "select * from myboard where bseq=? order by bseq asc";
//		MyBoardVO empvo = null;
//		try {
//			conn = ds.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bseq);
//			rs = pstmt.executeQuery();
//			while(rs.next()) { // 1줄 읽는 것. (반복문으로 여러 줄 읽음)
//				int bseq_ = rs.getInt("bseq");
//				String title = rs.getString("title"); //컬럼명 넣어야 해서 "" 필수
//				String contents = rs.getString("contents");
//				String regid = rs.getString("regid");
//				String regdate = rs.getString("regdate");
//				
//				empvo = new MyBoardVO();
//				empvo.setBseq(bseq_);
//				empvo.setTitle(title);
//				empvo.setContents(contents);
//				empvo.setRegid(regid);
//				empvo.setRegdate(regdate);
//				//alist.add(empvo);
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		o.Close(conn, pstmt, rs);
//		System.out.println("--내부 select(int bseq) done--");
//		return empvo;
//	}
	
//	public ArrayList<MyBoardVO> select(int start, int end) {
//		
//		DB_conn o = Ch15_conn_oracle.getInstance();
//		//TODO
//		String sql = "select *\r\n"
//				+ "from\r\n"
//				+ "(\r\n"
//				+ "select rownum as rnum, title, contents, regid, regdate\r\n"
//				+ "from \r\n"
//				+ "(select * from myboard order by bseq asc)\r\n"
//				+ ")\r\n"
//				+ "where rnum between ? and ?";
//		try {
//			conn = o.cmain();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
//			rs = pstmt.executeQuery();
//			MyBoardVO empvo = null;
//			while(rs.next()) { // 1줄 읽는 것. (반복문으로 여러 줄 읽음)
//				int i = 0;
//				empvo = new MyBoardVO();
//				int bseq = rs.getInt("rnum");
//				String title_ = rs.getString("title"); //컬럼명 넣어야 해서 "" 필수
//				String contents = rs.getString("contents");
//				String regid = rs.getString("regid");
//				String regdate = rs.getString("regdate");
//				empvo.setBseq(bseq);
//				empvo.setTitle(title_);
//				empvo.setContents(contents);
//				empvo.setRegid(regid);
//				empvo.setRegdate(regdate);
//				alist.add(empvo);
//				
//				System.out.println(alist.get(i));
//				i++;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		o.Close(conn, pstmt, rs);
//		System.out.println("--내부 select * done--");
//		return alist;
//	}
//	
//	public ArrayList<MyBoardVO> select(String searchGubun, String searchStr) {
//		
//		DB_conn o = Ch15_conn_oracle.getInstance();
//		//TODO
//		String sql = "select * from myboard where " + searchGubun + " like ? order by regdate desc";
//		try {
//			//select * from myboard where title like '%뀨뀨%'
//			conn = o.cmain();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, '%'+searchStr+'%');
//			rs = pstmt.executeQuery();
//			MyBoardVO empvo = null;
//			while(rs.next()) { // 1줄 읽는 것. (반복문으로 여러 줄 읽음)
//				int i = 0;
//				empvo = new MyBoardVO();
//				int bseq = rs.getInt("bseq");
//				String title_ = rs.getString("title"); //컬럼명 넣어야 해서 "" 필수
//				String contents = rs.getString("contents");
//				String regid = rs.getString("regid");
//				String regdate = rs.getString("regdate");
//				empvo.setBseq(bseq);
//				empvo.setTitle(title_);
//				empvo.setContents(contents);
//				empvo.setRegid(regid);
//				empvo.setRegdate(regdate);
//				alist.add(empvo);
//				
//				System.out.println(alist.get(i));
//				i++;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		o.Close(conn, pstmt, rs);
//		System.out.println("--내부 select * done--");
//		return alist;
//	}
//	
//public MyBoardVO2 selectBoardReply(int bseq) {
//		
//		DB_conn o = Ch15_conn_oracle.getInstance();
//		//TODO
//		String sql = "select * \r\n"
//				+ "from (select * from myboard where bseq = 3) m, myreply r\r\n"
//				+ "where m.bseq = r.bseq;";
//		try {
//			conn = o.cmain();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bseq);
//			rs = pstmt.executeQuery();
//			ArrayList<MyreplyVO> rlist = new ArrayList<MyreplyVO>();
//			MyBoardVO2 bvo = new MyBoardVO2();
//			MyreplyVO rvo = new MyreplyVO();
//			
//			while(rs.next()) { // 1줄 읽는 것. (반복문으로 여러 줄 읽음)
//				if (bvo == null) {
//					
//					bvo = new MyBoardVO2();
//					bvo.setBseq(0);
//					bvo.setTitle(sql);
//					bvo.setTitle(sql);
//					bvo.setContents(sql);
//					bvo.setRegid(sql);
//					bvo.setRegdate(sql);
//					
//				}
//				rvo.setRseq(0);
//				rvo.setReply(sql);
//				rvo.setRegid(sql);
//				rvo.setRegdate(sql);
//				rvo.setBseq(0);
//				rlist.add(rvo);
//				
//			}
//			
//			bvo.setRlist(rlist);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		o.Close(conn, pstmt, rs);
//		System.out.println("--내부 select * done--");
//		return bvo;
//	}
//	
//
//	//public int insert(String title, String contents, String regid) {
//	public int insert(MyBoardVO empvo) {
//		DB_conn o = Ch15_conn_oracle.getInstance();
//		
//		//PreparedStatement pstmt = null;
//		int rows = 0;
//		//TODO
//		String sql = "insert into myboard(bseq, title, contents, regid, regdate) values(seq_myboard.nextval, ?, ?, ?,sysdate)";
//		
//		try {
//			conn = o.cmain();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, empvo.getTitle());
//			pstmt.setString(2, empvo.getContents());
//			pstmt.setString(3, empvo.getRegid());
//			//pstmt.setString(3, regid);
//			rows = pstmt.executeUpdate();
//			System.out.println("--Insert into myboard completed--");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//System.out.println("--내부 insert into myboard(bseq, title, contents, regid,  regdate) done--");
//		//o.Close(conn, pstmt);
//		return rows;
//	}
//	public int update(int bseq, String title, String contents) {
//
//		DB_conn o = Ch15_conn_oracle.getInstance();
//		
//		int rows = 1;
//		//TODO
//		String sql = "UPDATE myboard SET title = ?, contents = ? WHERE bseq = ?";
//	
//		try {
//			conn = o.cmain();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, title);
//			pstmt.setString(2, contents);
//			pstmt.setInt(3, bseq);
//			rows = pstmt.executeUpdate(); //시발...
//		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("--내부 myboard SET title = ?, contents = ? WHERE bseq = ? done--\n");
//		o.Close(conn, pstmt);
//		return rows;
//	}
//	
//	public int delete(int bseq) {
//		
//		DB_conn o = Ch15_conn_oracle.getInstance();
//		
//		int rows = 1;
//		//TODO
//		String sql = "DELETE FROM myboard WHERE bseq = ?";
//	
//		try {
//			conn = o.cmain();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bseq);
//			rows = pstmt.executeUpdate(); //시발...
//		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("--내부 DELETE FROM myboard WHERE bseq = ? done--\n");
//		o.Close(conn, pstmt);
//		return rows;
//	}	
	
	// --------- 호출 ---------
	public static void main(String[] args) throws InterruptedException  {
//		//메서드 호출
//		//return이 있을 경우 출력
//		BoardDAO oo = new BoardDAO();
//
//		MyBoardVO res1 = oo.select(2);
//		System.out.println("호출결과 :" + res1.getBseq() + "\t" + res1.getTitle());
//		
//		ArrayList<MyBoardVO> res2 = oo.select();
//		System.out.println("호출결과: select");
//		for(int i = 0; i < res2.size(); i++) {
//			System.out.println(res2.get(i).getBseq() + "\t" + res2.get(i).getTitle() + "\t" + res2.get(i).getRegid() + res2.get(i).getRegdate());
//			System.out.println(res2.get(i).getContents());
//		}
//		
//		MyBoardVO mm = new MyBoardVO();
//		mm.setTitle("title");
//		mm.setContents("ccccc");
//		mm.setRegid("hong");
//		
//		int res3 = oo.insert("안녕하세요", "JAVA", "kim");
//		System.out.println("호출결과3:" + res3 + "\n");
//		
//		int res4 = oo.update(11, "안녕하세요2");
//		System.out.println("호출결과4:" + res4 + "\n");
//		
//		int res5 = oo.delete(7733);
//		System.out.println("호출결과5:" + res5 + "\n");
//		
	}

	
}

