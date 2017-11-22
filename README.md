# Pager
Java &amp; JSP Pagination 유틸리티

## 사용 방법
### maven dependency에 Pager-1.0.0.jar 파일을 추가할 경우
1. Pager-1.0.0.jar파일을 C:\에 복사합니다.
1. Maven 명령어를 이용해 .m2 Repository 에 Pager-1.0.0.jar 를 설치(저장)합니다.<pre>mvn install:install-file -Dfile=C:\Pager-1.0.0.jar -DgroupId=io.github.seccoding -DartifactId=Pager -Dversion=1.0.0 -Dpackaging=jar</pre>
1. 본인의 Project/pom.xml 에 dependency를 추가합니다.<pre>
	&lt;dependency&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;io.github.seccoding&lt;/groupId&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;Pager&lt;/artifactId&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;1.0.0&lt;/version&gt;
	&lt;/dependency&gt;
</pre>

### 소스코드를 사용할 경우
1. Clone or Download 를 클릭합니다.
1. Download ZIP 을 클릭해 소스코드를 다운로드 받습니다.
1. Pager/pom.xml의 dependencies를 본인의 Project/pom.xml 에 붙혀넣습니다.
1. Pager/src 이하의 자바코드를 본인의 Project에 붙혀넣습니다. 
---
## Pagination 사용하기
### Java (Servlet or Controller)
<pre>
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.ListPageExplorer;

public class PagerTest {

	public static void main(String[] args) {
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(17);
		pager.setTotalArticleCount(220);
		
		// 기본 타입
		String page1 = pager.makePageExplorer(ListPageExplorer.class)
							.setData("pageNo", "[@]", "이전", "다음", "form")
							.make();
		// 기본 타입
		String page2 = pager.makePageExplorer(ClassicPageExplorer.class)
							.setData("pageNo", "[@]", "이전", "다음", "form")
							.make();
		
		// UI 변경
		String page3 = pager.makePageExplorer(ListPageExplorer.class)
							.setData("pageNo", "[@]", "이전", "다음", "form")
							.prevGroup((prevGroupPageNumber, prev) -> {
								return "<div href=\"javascript:movePage('" + prevGroupPageNumber + "')\">" + prev + "</div>";
							})
							.nextGroup((nextGroupPageNumber, next) -> {
								return "<div href=\"javascript:movePage('" + nextGroupPageNumber + "')\">" + next + "</div>";
							})
							.pages((pageNo, pageFormat) -> {
								return "<div onclick=\"javascript:movePage('" + pageNo + "')\">" + pageFormat + "</div>";
							})
							.highlight(pageNo -> {
								return "<div>"+pageNo+"</div>";
							})
							.make();
		
		// UI 변경
		String page4 = pager.makePageExplorer(ClassicPageExplorer.class)
							.setData("pageNo", "[@]", "이전", "다음", "form")
							.prevGroup((prevGroupPageNumber, prev) -> {
								return "<div href=\"javascript:movePage('" + prevGroupPageNumber + "')\">" + prev + "</div>";
							})
							.nextGroup((nextGroupPageNumber, next) -> {
								return "<div href=\"javascript:movePage('" + nextGroupPageNumber + "')\">" + next + "</div>";
							})
							.pages((pageNo, pageFormat) -> {
								return "<div onclick=\"javascript:movePage('" + pageNo + "')\">" + pageFormat + "</div>";
							})
							.highlight(pageNo -> {
								return "<div>"+pageNo+"</div>";
							})
							.make();
		
		System.out.println(page1);
		System.out.println(page2);
		System.out.println(page3);
		System.out.println(page4);
		
	}
	
}
</pre>

### JSP
> String pagenation = pager.makePageExplorer(ListPageExplorer.class)
							.setData("pageNo", "[@]", "이전", "다음", "form")
							.make();
> pagenation 을 JSP 로 전송.<br/>
> setData메소드의 마지막 파라미터("form")를 Form의 ID 로 사용.

<pre>
&lt;form id="form"&gt;
	${pagenation} // pagenation 을 el로 표현
&lt;/form&gt;
</pre>
