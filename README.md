# Pager
Java &amp; JSP Pagination 유틸리티

## 사용 방법
### maven dependency에 Pager-1.1.0.jar 파일을 추가할 경우 (jdk 1.8 이상, 그 이하의 버젼은 Pager-1.0.0.jar 를 사용하세요,)
1. Pager-1.1.0.jar파일을 C:\에 복사합니다.
1. Maven 명령어를 이용해 .m2 Repository 에 Pager-1.1.0.jar 를 설치(저장)합니다.<pre>mvn install:install-file -Dfile=C:\Pager-1.1.0.jar -DgroupId=io.github.seccoding -DartifactId=Pager -Dversion=1.1.0 -Dpackaging=jar</pre>
1. 본인의 Project/pom.xml 에 dependency를 추가합니다.<pre>
	&lt;dependency&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;io.github.seccoding&lt;/groupId&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;Pager&lt;/artifactId&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;1.1.0&lt;/version&gt;
	&lt;/dependency&gt;
</pre>

### 소스코드를 사용할 경우 (jdk 1.8 이상 해당, 그 이하 버젼은 지원하지 않습니다.)
1. Clone or Download 를 클릭합니다.
1. Download ZIP 을 클릭해 소스코드를 다운로드 받습니다.
1. Pager/pom.xml의 dependencies를 본인의 Project/pom.xml 에 붙혀넣습니다.
1. Pager/src 이하의 자바코드를 본인의 Project에 붙혀넣습니다. 
---
## Pagination 사용하기
### Java (Servlet or Controller)
> SampleCode 참고하세요.
> https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/PagerTest.java

### JSP
> String pagenation = pager.makePageExplorer(ListPageExplorer.class)<br/>
			   .setData("pageNo", "[@]", "이전", "다음", "form")<br/>
			   .make();
> pagenation 을 JSP 로 전송.<br/>
> setData메소드의 마지막 파라미터("form")를 Form의 ID 로 사용.

<pre>
&lt;form id="form"&gt;
	${pagenation} // pagenation 을 el로 표현
&lt;/form&gt;
</pre>
