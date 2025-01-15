/**
 * 
 */
package com.lec.tx;
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
public class TxController {
	
	@Autowired
	private TxService svc;
	
	private static Logger logger = LoggerFactory.getLogger(TxController.class);
	@RequestMapping(value = "/blist", method = RequestMethod.GET)
	public String ctlList(Model model) {
		//BoardDAO bdao = new BoardDAO();
	
		ArrayList<MyBoardVO> blist = svc.svcSelect();
		model.addAttribute("MY_KEY_BLIST", blist);
		
		return "tx/board_list";
	}
	
	@RequestMapping(value = "/binsert", method = RequestMethod.POST)
	public String ctlInsert(
			@RequestParam("title") String vtitle,
			@RequestParam("contents") String vcontents,
			@RequestParam("regid") String vregid
			) {
		
		MyBoardVO bvo = new MyBoardVO();
		bvo.setTitle(vtitle);
		bvo.setContents(vcontents);
		bvo.setRegid(vregid);
		svc.svcInsert(bvo);
		
		
		return "redirect:/blist";
	}

}
