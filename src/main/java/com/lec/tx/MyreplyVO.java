package com.lec.tx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter 대신(직렬화 안할 거면)
@AllArgsConstructor
@NoArgsConstructor
public class MyreplyVO {

	private int rseq;
	private String reply;
	private String regid;
	private String regdate;
	private int bseq;

}
