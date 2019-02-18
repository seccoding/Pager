# Pager
Java &amp; JSP Pagination 유틸리티

jQuery가 필요합니다.

<pre>
package io.github.seccoding.web.pager;

public class PagingTest {

	public static void main(String[] args) {
		
		Paging paginate = new Paging();
		paginate.setPageNumber("0"); // 0번 페이지
		paginate.setTotalArticleCount(100);
		
		// 탐색 시작 Row
		int startRow = paginate.getStartArticleNumber();
		
		// 탐색 끝 Row
		int endRow = paginate.getEndArticleNumber();
		
		// 총 게시글 수
		int totalArticleCount = paginate.getTotalArticleCount();
		
		System.out.println(startRow);
		System.out.println(endRow);
		System.out.println(totalArticleCount);
		
		// 페이지네이트 HTML
		String paginateHTML = paginate.getPagingList("pageNo", "[@]", "이전", "다음", "searchForm");
		
		System.out.println(paginateHTML);
		
	}
	
}
</pre>