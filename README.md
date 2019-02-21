[ ![Download](https://api.bintray.com/packages/mcjang1116/io.github.seccoding/Pagination/images/download.svg?version=1.1.2.1) ](https://bintray.com/mcjang1116/io.github.seccoding/Pagination/1.1.2.1/link)

# Pager
Java &amp; JSP Pagination 유틸리티

## Release Note
* 1.1.2.1 (2017.11.30)
  * Pager
    * makePageExplorer(Class<? extends PageExplorer> cls, Object searchObject) 추가
  * Paging Query 를 위한 Annotation 추가
    * https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/TestSearchVO.java
    * EndRow
    * StartRow
  * Test case 추가
    * PagerFactoryTest
      * https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/PagerFactoryTest.java
    * PagerTest
      * https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/PagerTest.java

* 1.1.2 (2017.11.23)
  * PageExplorer에 totalCount 추가
    * PageExplorer.getTotalCount() 사용할 수 있음.
  
            
* 1.1.1 (2017.11.23)
  * PageExplorer에 List 추가.
  * PageExplorer 와 List를 동시에 리턴해야 할 경우가 빈번해 PageExplorer에 List를 넣을 수 있도록 변경
  * MVC 테스트 코드 추가.
  * PageOption 추가
    * PageExplorer.setData() 사용없이 .make() 호출 가능.
      * 기본값
        * formId = "searchForm"
        * link = "pageNo"
        * pageFormat = "[@]"
        * prev = "Prev"
        * next = "Next"
      * 필요에 의해 PageExplorer.setData(pageOption) 으로 사용 가능.
        * 변경이 필요한 값만 셋팅할 수 있음.
  
  
* 1.1.0 (2017.11.22)
  * .getPagingList("pageNo", "[@]", "이전", "다음", "form") 삭제.
  * .setData("pageNo", "[@]", "이전", "다음", "form").make()로 대체됨.
  * jdk 1.8 미만 버젼 지원 하지 않음.
  * Pager UI 변경 기능 추가
    * PageExplorer.highlight(Function<String, String> f)
    * PageExplorer.prevGroup(BiFunction<Integer, String, String> f)
    * PageExplorer.nextGroup(BiFunction<Integer, String, String> f)
    * PageExplorer.pages(BiFunction<Integer, String, String> f)
  
    
* 1.0.0 (2017.06.09)
  * 최초등록


## 개발중인 기능
* (1.1.3) JSONPageExplorer
* (1.1.3) XMLPageExplorer

## 사용 방법
### maven 사용
1. Repository 추가<pre>
   &lt;repositories&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;repository&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;id&gt;bintray&lt;/id&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;url&gt;http://jcenter.bintray.com</url&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;snapshots&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;enabled&gt;false&lt;/enabled&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/snapshots&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;/repository&gt;
&lt;/repositories&gt;
   </pre>
   
1. dependency 추가<pre>
   &lt;dependency&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;io.github.seccoding&lt;/groupId&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;Pagination&lt;/artifactId&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;1.1.2.1&lt;/version&gt;
	&lt;/dependency&gt;
   </pre>
   
### maven dependency에 Pager-1.1.2.1.jar 파일을 추가할 경우 
   > jdk 1.8 미만 버젼 https://github.com/seccoding/Pager/tree/1.0.0
   1. Pager-1.1.2.1.jar파일을 C:\에 복사합니다.
   1. Maven 명령어를 이용해 .m2 Repository 에 Pager-1.1.2.1.jar 를 설치(저장)합니다.<pre>mvn install:install-file -Dfile=C:\Pager-1.1.2.1jar -DgroupId=io.github.seccoding -DartifactId=Pager -Dversion=1.1.2.1 -Dpackaging=jar</pre>
   1. 본인의 Project/pom.xml 에 dependency를 추가합니다.<pre>
	&lt;dependency&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;io.github.seccoding&lt;/groupId&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;Pager&lt;/artifactId&gt;
	&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;1.1.2.1&lt;/version&gt;
	&lt;/dependency&gt;
</pre>

### 소스코드를 사용할 경우 
   > jdk 1.8 미만 버젼 https://github.com/seccoding/Pager/tree/1.0.0
   1. Clone or Download 를 클릭합니다.
   1. Download ZIP 을 클릭해 소스코드를 다운로드 받습니다.
   1. Pager/pom.xml의 dependencies를 본인의 Project/pom.xml 에 붙여넣습니다.
   1. Pager/src 이하의 자바코드를 본인의 Project에 붙여넣습니다. 

## Pagination 사용하기
* Java (Servlet or Controller)
  > 1. PagerFactoryTest https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/PagerFactoryTest.java 
  > 1. PagerTest https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/PagerTest.java
  > 1. (MVC::Controller) https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/mvc/web/Controller.java
  > 1. (MVC::Service) https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/mvc/service/Service.java
  > 1. (MVC::Dao) https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/mvc/dao/Dao.java
  > 1. (MVC::JSP) https://github.com/seccoding/Pager/blob/master/src/test/java/io/github/seccoding/web/pager/mvc/jsp/view.jsp

* JSP
  > 1. String pagenation = pager.makePageExplorer(ListPageExplorer.class)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.setData("pageNo", "[@]", "이전", "다음", "form")<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.make();
  > 1. pagenation 을 JSP 로 전송.
  > 1. setData메소드의 마지막 파라미터("form")를 Form의 ID 로 사용.<pre>
&lt;form id="form"&gt;
&nbsp;&nbsp;&nbsp;&nbsp;${pagenation} // pagenation 을 el로 표현
&lt;/form&gt;
</pre>

* 영구적인 Pager UI 변경을 하려면 `io.github.seccoding.web.pager.decorator.Decorator.java` 내용을 수정하세요.
  * https://github.com/seccoding/Pager/blob/master/src/main/java/io/github/seccoding/web/pager/decorator/Decorator.java
