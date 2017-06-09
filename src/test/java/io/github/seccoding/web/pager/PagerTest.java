package io.github.seccoding.web.pager;

import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.ListPageExplorer;

public class PagerTest {

	public static void main(String[] args) {
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(17);
		pager.setTotalArticleCount(220);
		
		PageExplorer pageExplorer1 = new ListPageExplorer(pager);
		String page1 = pageExplorer1.getPagingList("pageNo", "[@]", "이전", "다음", "form");
		System.out.println(page1);
		
		PageExplorer pageExplorer2 = new ClassicPageExplorer(pager);
		String page2 = pageExplorer2.getPagingList("pageNo", "[@]", "이전", "다음", "form");
		System.out.println(page2);
		
	}
	
}
