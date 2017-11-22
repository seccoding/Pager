# Pager
Java &amp; JSP Pagination 유틸리티

## Release Note

* 1.1.1
  * PageExplorer에 List 추가.
  * PageExplorer 와 List를 동시에 리턴해야 할 경우가 빈번해 PageExplorer에 List를 넣을 수 있도록 변경
  * MVC 테스트 코드 추가.
  
* 1.1.0
  * jdk 1.8 미만 버젼 지원 하지 않음.
  * Pager UI 변경 기능 추가
    * PageExplorer.highlight(Function<String, String> f)
    * PageExplorer.prevGroup(BiFunction<Integer, String, String> f)
    * PageExplorer.nextGroup(BiFunction<Integer, String, String> f)
    * PageExplorer.pages(BiFunction<Integer, String, String> f)
    
* 1.0.0
  * 최초등록

## 개발중인 기능
* (1.1.2) JSONPageExplorer
* (1.1.2) XMLPageExplorer

## 사용 방법
* maven dependency에 Pager-1.1.1.jar 파일을 추가할 경우 
   > (jdk 1.8 이상, 그 이하의 버젼은 Pager-1.0.0.jar 를 사용하세요.)
   1. Pager-1.1.1.jar파일을 C:\에 복사합니다.
   1. Maven 명령어를 이용해 .m2 Repository 에 Pager-1.1.1.jar 를 설치(저장)합니다.<pre>mvn install:install-file -Dfile=C:\Pager-1.1.1.jar -DgroupId=io.github.seccoding -DartifactId=Pager -Dversion=1.1.1 -Dpackaging=jar</pre>
   1. 본인의 Project/pom.xml 에 dependency를 추가합니다.<pre>
	&lt;dependency&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;io.github.seccoding&lt;/groupId&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;Pager&lt;/artifactId&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;1.1.1&lt;/version&gt;
	&lt;/dependency&gt;
</pre>

*  소스코드를 사용할 경우 
   > (jdk 1.8 이상 해당, 그 이하 버젼은 지원하지 않습니다.)
   1. Clone or Download 를 클릭합니다.
   1. Download ZIP 을 클릭해 소스코드를 다운로드 받습니다.
   1. Pager/pom.xml의 dependencies를 본인의 Project/pom.xml 에 붙혀넣습니다.
   1. Pager/src 이하의 자바코드를 본인의 Project에 붙혀넣습니다. 
---
## Pagination 사용하기
* Java (Servlet or Controller)  
  > 1. SampleCode 참고하세요.
  > 1. https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/PagerTest.java
  > 1. (MVC::Controller) https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/mvc/web/Controller.java
  > 1. (MVC::Service) https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/mvc/service/Service.java
  > 1. (MVC::Dao) https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/mvc/dao/Dao.java
  > 1. (MVC::JSP) https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/mvc/jsp/view.jsp

* JSP
  > 1. String pagenation = pager.makePageExplorer(ListPageExplorer.class)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.setData("pageNo", "[@]", "이전", "다음", "form")
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.make();
  > 1. pagenation 을 JSP 로 전송.
  > 1. setData메소드의 마지막 파라미터("form")를 Form의 ID 로 사용.<pre>
&lt;form id="form"&gt;
&nbsp;&nbsp;&nbsp;&nbsp;${pagenation} // pagenation 을 el로 표현
&lt;/form&gt;
</pre>
