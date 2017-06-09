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
		
		// Oracle을 제외한 RDB가 처리하는 페이징 방법이 다르기 때문에, 현재 사용중인 RDB 를 작성합니다.
		// Oracle을 사용할 경우 Pager.ORACLE
		// Oracle을 제외한 RDB를 사용할 경우 Pager.OTHER 를 사용합니다.
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(17);
		pager.setTotalArticleCount(220);
		
		// pager 는 startArticleNumber와 endArticleNumber를 계산합니다.
		// Query 에서 페이징 쿼리를 작성할 때 사용합니다.
		// 페이징 시작 번호
		System.out.println(pager.getStartArticleNumber());
		// 페이징 끝 번호(Oracle의 경우)
		// 페이징 조회 개수(Oracle을 제외한 RDB의 경우)
		System.out.println(pager.getEndArticleNumber());
		
		PageExplorer pageExplorer1 = new ListPageExplorer(pager);
		String page1 = pageExplorer1.getPagingList("pageNo", "[@]", "이전", "다음", "form");
		System.out.println(page1);
		
		PageExplorer pageExplorer2 = new ClassicPageExplorer(pager);
		String page2 = pageExplorer2.getPagingList("pageNo", "[@]", "이전", "다음", "form");
		System.out.println(page2);
		
	}
	
}
</pre>

### JSP
> String page1 = pageExplorer1.getPagingList("pageNo", "[@]", "이전", "다음", "form");<br/>
> page1 을 JSP 로 전송.<br/>
> getPagingList메소드의 마지막 파라미터를 Form의 ID 로 사용.

<pre>
&lt;form id="form"&gt;
	${pager} // page1 을 el로 표현
&lt;/form&gt;
</pre>
