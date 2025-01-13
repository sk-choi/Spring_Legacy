/**
 * 
 */
package com.lec.board;
import java.util.ArrayList;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sb.common.PagingUtil;
import com.sb.common.PagingUtilFactory;

/**
 * Description : 클래스에 대한 설명을 입력해주세요.<br>
 * Date : 2025. 1. 10.<br>
 * History :<br>
 * - 작성자 : Kosta, 날짜 : 2025. 1. 10., 설명 : 최초작성<br>
 *
 * @author Kosta
 * @version 1.0
 */
@Controller
public class MyBoardController {
	
	@Autowired
	private BoardDAO bdao;
	
	@Autowired
	private PagingUtilFactory factory;
	
	private static Logger logger = LoggerFactory.getLogger(MyBoardController.class);
	@RequestMapping(value = "/Myboard", method = RequestMethod.GET)
	public String home(Model model
				, @RequestParam(value="currentPage", defaultValue="1") int currentPage   ) {
		
		logger.info("My test 현재페이지........... {}", currentPage);
		
		//BoardDAO bdao = new BoardDAO();
		int totRecord = bdao.select().size();
		int blockCount = 3; 
		int blockPage = 2;
		
		
		PagingUtil pg = factory.getInstancePagingUtil("/Myboard", currentPage, totRecord, blockCount, blockPage);
		//pg = new PagingUtil("/Myboard", currentPage, totRecord, blockCount, blockPage);
		model.addAttribute("MY_KEY_PAGING_HTML", pg.getPagingHtml().toString());
		//----------------------------------------------------------------------------
		
		ArrayList<MyBoardVO> blist = bdao.select( pg.getStartSeq(), pg.getEndSeq());
		model.addAttribute("MY_KEY_BLIST", blist);
		
		return "sb/boardlist";
	}

}
