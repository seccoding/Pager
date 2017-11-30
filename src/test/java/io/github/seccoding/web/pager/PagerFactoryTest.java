package io.github.seccoding.web.pager;


public class PagerFactoryTest {

    public static void main(String[] args) {
        PagerFactoryTest pagerFactoryTest = new PagerFactoryTest();
        pagerFactoryTest.makeOraclePager();
        pagerFactoryTest.makeOtherPager();

        pagerFactoryTest.makeOraclePagerWithPagerOption();
        pagerFactoryTest.makeOtherPagerWithPagerOption();

        pagerFactoryTest.makeOraclePagerWithPagerOptionAndPageInfo();
        pagerFactoryTest.makeOtherPagerWithPagerOptionAndPageInfo();

        pagerFactoryTest.makeOraclePagerWithPagerOptionAndPageInfoAndCount();
        pagerFactoryTest.makeOtherPagerWithPagerOptionAndPageInfoAndCount();
    }

    /**
     * 오라클용 페이저 만들기
     */
    public void makeOraclePager() {
        Pager pager = PagerFactory.getPager(Pager.ORACLE);
        pager.setPageNumber("0");
        pager.setTotalArticleCount(200);
        printPagerInfo("makeOraclePager", pager);
    }

    /**
     * 비오라클(MySQL, MSSQL 등)용 페이저 만들기
     */
    public void makeOtherPager() {
        Pager pager = PagerFactory.getPager(Pager.OTHER);
        pager.setPageNumber("0");
        pager.setTotalArticleCount(200);
        printPagerInfo("makeOtherPager", pager);
    }

    /**
     * 오라클용 페이저 만들기
     * 페이지별 게시글 수와 그룹별 페이지수를 지정함.
     */
    public void makeOraclePagerWithPagerOption() {
        Pager pager = PagerFactory.getPager(Pager.ORACLE, 10, 10);
        pager.setPageNumber("0");
        pager.setTotalArticleCount(200);
        printPagerInfo("makeOraclePagerWithPagerOption", pager);
    }

    /**
     * 비오라클(MySQL, MSSQL 등)용 페이저 만들기
     * 페이지별 게시글 수와 그룹별 페이지수를 지정함.
     */
    public void makeOtherPagerWithPagerOption() {
        Pager pager = PagerFactory.getPager(Pager.OTHER, 10, 10);
        pager.setPageNumber("0");
        pager.setTotalArticleCount(200);
        printPagerInfo("makeOtherPagerWithPagerOption", pager);
    }

    /**
     * 오라클용 페이저 만들기
     * 페이지 번호, 페이지별 게시글 수와 그룹별 페이지수를 지정함.
     */
    public void makeOraclePagerWithPagerOptionAndPageInfo() {
        Pager pager = PagerFactory.getPager(Pager.ORACLE, "0", 10, 10);
        pager.setTotalArticleCount(200);
        printPagerInfo("makeOraclePagerWithPagerOptionAndPageInfo", pager);
    }

    /**
     * 비오라클(MySQL, MSSQL 등)용 페이저 만들기
     * 페이지 번호, 페이지별 게시글 수와 그룹별 페이지수를 지정함.
     */
    public void makeOtherPagerWithPagerOptionAndPageInfo() {
        Pager pager = PagerFactory.getPager(Pager.OTHER, "0", 10, 10);
        pager.setTotalArticleCount(200);
        printPagerInfo("makeOtherPagerWithPagerOptionAndPageInfo", pager);
    }

    /**
     * 오라클용 페이저 만들기
     * 페이지 번호, 총 게시글 수, 페이지별 게시글 수와 그룹별 페이지수를 지정함.
     */
    public void makeOraclePagerWithPagerOptionAndPageInfoAndCount() {
        Pager pager = PagerFactory.getPager(Pager.ORACLE, "0", 100, 10, 10);
        printPagerInfo("makeOraclePagerWithPagerOptionAndPageInfoAndCount", pager);
    }

    /**
     * 비오라클(MySQL, MSSQL 등)용 페이저 만들기
     * 페이지 번호, 총 게시글 수, 페이지별 게시글 수와 그룹별 페이지수를 지정함.
     */
    public void makeOtherPagerWithPagerOptionAndPageInfoAndCount() {
        Pager pager = PagerFactory.getPager(Pager.OTHER, "0", 100, 10, 10);
        printPagerInfo("makeOtherPagerWithPagerOptionAndPageInfoAndCount", pager);
    }

    private void printPagerInfo(String methodName, Pager pager) {
        System.out.println("===============" + methodName + "===============");
        System.out.println("Pager Type : " + pager.getClass().getSimpleName());
        System.out.println("pager.getTotalArticleCount() : " + pager.getTotalArticleCount());
        System.out.println("pager.getStartArticleNumber() : " + pager.getStartArticleNumber());
        System.out.println("pager.getEndArticleNumber() : " + pager.getEndArticleNumber());
        System.out.println();
    }

}
