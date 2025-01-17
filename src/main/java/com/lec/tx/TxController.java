/**
 * 
 */
package com.lec.tx;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
		List<MyBoardVO> blist = svc.svcSelect();
		model.addAttribute("MY_KEY_BLIST", blist);
		
		return "tx/board_list";
	}
	
	@RequestMapping(value = "/btest", method = RequestMethod.GET)
	public String ctlTest(Model model) {
		System.out.println("TxController ctlList 실행 >>> ");
		svc.svcTest();
		
		return "tx/test";
	}
	
//	@RequestMapping(value = "/binsert", method = RequestMethod.POST)
//	public String ctlInsert(
//			@RequestParam("title") String vtitle,
//			@RequestParam("contents") String vcontents,
//			@RequestParam("regid") String vregid
//			) {	
//		MyBoardVO bvo = new MyBoardVO();
//		bvo.setTitle(vtitle);
//		bvo.setContents(vcontents);
//		bvo.setRegid(vregid);
//		svc.svcInsert(bvo);
//		
//		
//		return "redirect:/blist";
//	}
//	
	@RequestMapping(value = "/binsert", method = RequestMethod.POST)
	public String ctlInsert(
			@ModelAttribute MyBoardVO bvo
			) {	
		svc.svcInsert(bvo); //정상작동insert
		//unchecked exception에는 관여한다.
//		try {
//			svc.svcInsertRuntimeErrorFunc(bvo); // 밖에 에러 메세지 출력하지 말라고 try catch 사용
//		} catch(RuntimeException e) {
//			System.out.println("txctl RuntimeException catch........");
//		}
		
		//checked exception에는 관여 안한다.
//		try {
//			svc.svcInsertSQLErrorFunc(bvo); // 얘는 필수
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("txctl SQLException catch........");
//		}
		return "redirect:/blist";
	}
	
	
	
	@RequestMapping(value = "/bdetail", method = RequestMethod.GET)
	public String ctlDetail(Model model, @RequestParam("bseq") int vbseq) {
		
		MyBoardVO bvo = svc.svcDetail(vbseq);
		System.out.println(bvo.toString());
		model.addAttribute("MY_KEY_BVO", bvo);
		
		return "tx/board_detail";
	}
	
	@RequestMapping(value = "/bupdate", method = RequestMethod.POST)
	public String ctlUpdate(
			@ModelAttribute MyBoardVO bvo
			) {
		
		svc.svcUpdate(bvo);
		
		
		return "redirect:/bdetail?bseq=" + bvo.getBseq();
	}
	
	@RequestMapping(value = "/bdelete", method = RequestMethod.POST)
	public String ctlDelete(
			@RequestParam("bseq") int bseq
			) {
		svc.svcDelete(bseq);
		
		
		return "redirect:/blist";
	}

}
