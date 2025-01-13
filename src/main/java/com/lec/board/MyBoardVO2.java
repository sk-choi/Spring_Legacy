package com.lec.board;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@Data // getter, setter 대신(직렬화 안할 거면)
@AllArgsConstructor
@NoArgsConstructor

public class MyBoardVO2 {
	
	private int bseq;
	private String title;
	private String contents;
	private String regid;
	private String regdate;

	private ArrayList<MyreplyVO> rlist;
	
}
