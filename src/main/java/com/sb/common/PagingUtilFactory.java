package com.sb.common;

import org.springframework.stereotype.Component;

@Component
public class PagingUtilFactory {
	public PagingUtil getInstancePagingUtil(String url, int currentPage, int totRecord, int blockCount, int blockPage) {
		return new PagingUtil(url, currentPage, totRecord, blockCount, blockPage);
	}
}