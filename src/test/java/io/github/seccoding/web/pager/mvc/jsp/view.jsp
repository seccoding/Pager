<%@ page contentType="text/html; UTF-8" language="java" %>

<!--
// 기본 옵션 변경
PageOption option = new PageOption()
            .formId("pageForm")
            .link("pageNumber");

form의 ID는 "pageForm" 와 같아야 한다.
-->
<form id="pageForm">
    ${pageNavi}
    <!--
        필요한 검색값 입력 폼을 만든다.
        검색 값 전송을 위해서 movePage('0'); 을 호출한다.
    -->
</form>
