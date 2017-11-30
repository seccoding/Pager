package io.github.seccoding.web.pager.mvc.dao;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.TestModel;
import io.github.seccoding.web.pager.TestSearchVO;

import java.util.Arrays;
import java.util.List;

public class Dao {

    public int someCount() {
        return 200;
    }

    public List<TestModel> someData(TestSearchVO testSearchVO) {

        /*
         * 아래 두 라인은 필요에 따라서 Search를 위한 객체를 만들어 사용해야할 때도 있습니다.
         */
        // 페이징처리시 사용할 게시글 끝 번호
        System.out.println("EndRow : " + testSearchVO.getEndRow());

        // 페이징처리시 사용할 게시글 시작 번호
        System.out.println("StartRow : " + testSearchVO.getStartRow());

        return Arrays.asList(new TestModel("JMC"), new TestModel("JMS"));
    }
}
