package com.lec.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_jdbc.BoardDAO;
import com_jdbc.ReplyDAO;
import com.sb.common.PagingUtil;

/**
 * Servlet implementation class Myboardserblet
 */
@WebServlet("/Myboard")
public class Myboardservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    Myboardservlet(){
//    	ServletContext context = getServletContext();
//    	String uploadPath = context.getInitParameter("MY_CTX_UPLOAD_PATH");
//    	int maxFileSize = Integer.parseInt(uploadPath).getInitParameter("MY_CTX_MAX_FILE_SIZE"));
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BoardDAO bmd = new BoardDAO();
		String gubun = request.getParameter("gubun");
		System.out.println("-" + gubun + "-");
		
//-------------------------------------------목록보기
		
		if (gubun == null || gubun.equals("")) {
			int currentPage = 1;
			String currentPageStr = request.getParameter("currentPage");
			if (currentPageStr != null && !currentPageStr.equals("")) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			int totRecord = bmd.select().size();
			int blockCount = 3;
			int blockPage = 2;
			
			PagingUtil pg = new PagingUtil("/Myboard", currentPage, totRecord, blockCount, blockPage);
			ArrayList<MyBoardVO> blist = bmd.select(pg.getStartSeq(), pg.getEndSeq());
			request.setAttribute("MY_KEY_PAGING_HTML", pg.getPagingHtml().toString());
			//----------------------------------------------------------------------
			request.setAttribute("MY_KEY_BLIST", blist);
			request.getRequestDispatcher("/sb/boardlist.jsp").forward(request, response);
			
			
			
//-------------------------------------------상세보기
			
		}else if (gubun.equals("T001")) {
			int bseq = 1;
			String bseqStr = request.getParameter("bseq");
			if (bseqStr != null && !bseqStr.equals("")) {
				bseq = Integer.parseInt(bseqStr);
				MyBoardVO bvo = bmd.select(bseq);
				request.setAttribute("MY_KEY_BVO", bvo); //해당 게시물의 상세 내용
				
				ReplyDAO rdao = new ReplyDAO();
				List<MyreplyVO> rlist = rdao.select(bseq);
				request.setAttribute("MY_KEY_RLIST", rlist); //해당게시물의 댓글 목록
				
				request.getRequestDispatcher("/sb/board_detail.jsp").forward(request, response);
			} else {
   				response.sendRedirect("/sb/500.html");
   			}
		} else if (gubun.equals("TR001")) {
				int bseq = 1;
				String bseqStr = request.getParameter("bseq");
				if (bseqStr != null && !bseqStr.equals("")) {
					bseq = Integer.parseInt(bseqStr);
					MyBoardVO bvo = bmd.select(bseq);
					request.setAttribute("MY_KEY_BVO_RLIST", bvo); //해당 게시물의 상세 내용
					
					request.getRequestDispatcher("/sb/board_detail2.jsp").forward(request, response);
				} else {
						response.sendRedirect("/sb/500.html");
					}
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		
		BoardDAO bmd = new BoardDAO();
		String gubun = request.getParameter("gubun");  
		
		System.out.println("-" + gubun + "-");
	
		
		if (gubun == null) {
			response.sendRedirect("/sb/500.html");
		
		
		//----------------------------------------입력폼
		
		} else if (gubun.equals("I001")) {
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			
			MyBoardVO mvo = new MyBoardVO();
			mvo.setTitle(title);
			mvo.setContents(contents);
			mvo.setRegid("kim");
			
			int res = bmd.insert(mvo);
			if (res > 0) {
				response.sendRedirect("/Myboard");
			}
			else {
				response.sendRedirect("/sb/500.html");
			}
   			
			
		} else if (gubun.equals("U001")){
			System.out.println("업데이트 진행 중");
			int bseq = 0;
			String bseqStr = request.getParameter("bseq");
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			
			if (bseqStr != null && !bseqStr.equals("")) {
				bseq = Integer.parseInt(bseqStr);
			
				int res1 = bmd.update(bseq, title, contents);
				
				if (res1 > 0) {
					System.out.println("업데이트 완료");
					response.sendRedirect("/Myboard?bseq=" + bseq + "&gubun=T001");
				}
				else {
					response.sendRedirect("/sb/500.html");
				}
			}
			else {
				response.sendRedirect("/sb/500.html");
			}
			
			
		} else if (gubun.equals("D001")){
			System.out.println("삭제 진행 중");
			int bseq = 0;
			String bseqStr = request.getParameter("bseq");
			if (bseqStr != null && !bseqStr.equals("")) {
				bseq = Integer.parseInt(bseqStr);
				int res2 = bmd.delete(bseq);
				response.sendRedirect("/Myboard");
				if (res2 > 0) {
					System.out.println("삭제 완료");
					response.sendRedirect("/Myboard");
				}else {
					response.sendRedirect("/sb/500.html");
				}
			}
		 	else {
				response.sendRedirect("/sb/500.html");
			}
		} else {
			response.sendRedirect("/sb/500.html");
		}
		
	}

}
