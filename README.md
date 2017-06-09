# Pager
Java &amp; JSP Pagenation 유틸리티

## 사용 방법
### maven dependency에 Pager-1.0.0.jar 파일을 추가할 경우
1. Pager-1.0.0.jar파일을 C:\에 복사합니다.
1. Maven 명령어를 이용해 .m2 Repository 에 Pager-1.0.0.jar 를 설치(저장)합니다.
1. <pre>mvn install:install-file -Dfile=C:\Pager-1.0.0.jar -DgroupId=io.github.seccoding -DartifactId=Pager -Dversion=1.0.0 -Dpackaging=jar</pre>
1. 본인의 Project/pom.xml 에 dependency를 추가합니다.
1. <pre>
	&lt;dependency&gt;
		&lt;groupId&gt;io.github.seccoding&lt;/groupId&gt;
		&lt;artifactId&gt;Pager&lt;/artifactId&gt;
		&lt;version&gt;1.0.0&lt;/version&gt;
	&lt;/dependency&gt;
</pre>

### 소스코드를 사용할 경우
1. Clone or Download 를 클릭합니다.
1. Download ZIP 을 클릭해 소스코드를 다운로드 받습니다.
1. Pager/pom.xml의 dependencies를 본인의 Project/pom.xml 에 붙혀넣습니다.
1. Pager/src 이하의 자바코드를 본인의 Project에 붙혀넣습니다. 
---
## Pagenation 사용하기
<pre>
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
</pre>