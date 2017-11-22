package io.github.seccoding.web.pager.mvc.service;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.TestModel;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;
import io.github.seccoding.web.pager.mvc.dao.Dao;

import java.util.List;

public class Service {

    private Dao dao;

    public Service() {
        dao = new Dao();
    }

    public PageExplorer getSomeData(String pageNumber) {

        Pager pager = PagerFactory.getPager(Pager.ORACLE);
        // 페이지 번호 셋팅
        pager.setPageNumber(pageNumber);

        // 조회할 대상 개수 셋팅
        pager.setTotalArticleCount(dao.someCount());

        // 페이지 정보를 가지는 객체 생성
        PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class);

        if ( pager.getTotalArticleCount() > 0 ) {
            // 리스트 조회
            List<TestModel> someList = dao.someData(pager);

            // 페이지 객체에 리스트 셋팅
            pageExplorer.setList(someList);
        }

        return pageExplorer;
    }

}
