package com.lec.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Getter
//@Setter
//@ToString
@Data // getter, setter 대신(직렬화 안할 거면)
@AllArgsConstructor
@NoArgsConstructor

public class MyBoardVO {
	
	private int bseq;
	private String title;
	private String contents;
	private String regid;
	private String regdate;

	//MyBoardVO(String bseq, String contents, String regid, String regdate){}
	
	
}
