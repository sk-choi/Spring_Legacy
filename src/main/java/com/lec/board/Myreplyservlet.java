package com.lec.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_jdbc.ReplyDAO;

/**
 * Servlet implementation class Myreplyservlet
 */
@WebServlet("/Myreply")
public class Myreplyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myreplyservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		ReplyDAO rmd = new ReplyDAO();
		String gubun = request.getParameter("gubun");
		
		if (gubun == null) {
			response.sendRedirect("/sb/500.html");
		}
		
		//------------------------------------ 댓글입력
		else if (gubun.equals("RI001")) {
			
			int bseq = 0;
			
			String bseqStr = request.getParameter("bseq");
			String reply = request.getParameter("reply");
			System.out.println(reply);
			
			if (bseqStr != null &&!bseqStr.equals("")) {
				bseq = Integer.parseInt(bseqStr);
				
				MyreplyVO rvo = new MyreplyVO();
				rvo.setReply(reply);
				rvo.setRegid("guest");
				rvo.setBseq(bseq);
				System.out.println("댓글 출력:" + rvo.getReply());
				
				int res = rmd.insert(rvo);
				
				if (res > 0) {
					response.sendRedirect("/Myboard?bseq="+bseq+"&gubun=T001");
				}
				else {
					response.sendRedirect("/sb/500.html");
				}
			} else {
				response.sendRedirect("/sb/500.html");
			}
			
		} else if (gubun.equals("RD001")) {
   			
   			int bseq = 0;
   			int rseq = 0;
   			
			String bseqStr = request.getParameter("bseq");//원래 게시판에 돌아오는데 필요한 것.
			String rseqStr = request.getParameter("rseq");
			
			
			if(  (bseqStr != null && !bseqStr.equals("")) && (rseqStr != null && !rseqStr.equals("")) )  {
				bseq = Integer.parseInt(bseqStr);
				rseq = Integer.parseInt(rseqStr);
				
				int res = rmd.delete(rseq);
	   			//정상적으로 댓글이 삭제된 경우 --> 그자리에 머물러있기
				if(res > 0) {
	   				response.sendRedirect("/Myboard?bseq="+bseq+"&gubun=T001");
	   			} else {
	   				response.sendRedirect("/sb/500.html");
	   			}
			}else {
				response.sendRedirect("/sb/500.html");
			}
   		}
		
	}

}
