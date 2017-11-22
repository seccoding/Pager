package io.github.seccoding.web.pager.explorer;

public class PageOption {

    /**
     * 서버에게 전달될 Form 의 아이디를 작성한다.<br/>
     * 기본값 : searchForm
     */
    private String formId = "searchForm";

    /**
     * Page 번호를 전달할 Parameter Name<br/>
     * 기본값 : pageNo
     */
    private String link = "pageNo";

    /**
     * Page 번호를 보여줄 패턴 @(at)가 페이지 번호로 치환된다. [@]로 작성할 경우 [1] [2] [3] 처럼 보여진다.<br/>
     * 기본값 : [@]
     */
    private String pageFormat = "[@]";

    /**
     * 이전 페이지 그룹으로 가는 버튼의 이름을 작성한다.<br/>
     * 기본값 : Prev
     */
    private String prev = "Prev";

    /**
     * 다음 페이지 그룹으로 가는 버튼의 이름을 작성한다.<br/>
     * 기본값 : Next
     */
    private String next = "Next";

    public String formId() {
        return formId;
    }

    public PageOption formId(String formId) {
        this.formId = formId;
        return this;
    }

    public String link() {
        return link;
    }

    public PageOption link(String link) {
        this.link = link;
        return this;
    }

    public String pageFormat() {
        return pageFormat;
    }

    public PageOption pageFormat(String pageFormat) {
        this.pageFormat = pageFormat;
        return this;
    }

    public String prev() {
        return prev;
    }

    public PageOption prev(String prev) {
        this.prev = prev;
        return this;
    }

    public String next() {
        return next;
    }

    public PageOption next(String next) {
        this.next = next;
        return this;
    }
}
