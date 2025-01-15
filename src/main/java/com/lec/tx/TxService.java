package com.lec.tx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TxService {
	public void svcInsert(MyBoardVO bvo);
	public List<MyBoardVO> svcSelect();
}
