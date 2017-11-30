package io.github.seccoding.web.pager.mvc.web;

import io.github.seccoding.web.pager.TestModel;
import io.github.seccoding.web.pager.TestSearchVO;
import io.github.seccoding.web.pager.explorer.PageExplorer;
import io.github.seccoding.web.pager.explorer.PageOption;
import io.github.seccoding.web.pager.mvc.service.Service;

import java.util.List;

public class Controller {

    private Service service;

    public Controller() {
        service = new Service();
    }

    public void viewPage() {

        TestSearchVO testSearchVO = new TestSearchVO();
        testSearchVO.setPageNo("0");

        PageExplorer pageExplorer = service.getSomeData(testSearchVO);

        List<TestModel> dataList = pageExplorer.getList();

        int totalCount = pageExplorer.getTotalCount();
        System.out.println("totalCount : " + totalCount);

        // 기본 옵션
        // 기본 값은 "PageOption" 클래스 참고.
        String defaultPage = pageExplorer.make();

        // 기본 옵션 변경
        PageOption option = new PageOption()
                .formId("pageForm")
                .link("pageNumber");

        // 페이지네이션 생성
        String pageNavi = pageExplorer.setData(option).make();

        dataList.forEach(tm -> {
            System.out.println("Data : " + tm.getName());
        });

        System.out.println(pageNavi);
    }

    public static void main(String[] args) {
        new Controller().viewPage();
    }

}
