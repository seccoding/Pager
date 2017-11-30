package io.github.seccoding.web.pager;

import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.ListPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;
import io.github.seccoding.web.pager.explorer.PageOption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PagerTest {

	public static void main(String[] args) {
		PagerTest pagerTest = new PagerTest();
		pagerTest.makeClassicPageExplorer();
		pagerTest.makeListPageExplorer();

		pagerTest.makeClassicPageExplorerWithSearchObject();
		pagerTest.makeListPageExplorerWithSearchObject();

		pagerTest.makePageExplorerAndSettingList();
		pagerTest.makePagerBasic();

		pagerTest.makePagerCustom();
		pagerTest.makePagerCustomUsePageOption();

		pagerTest.makePagerUICustom();
	}

	/**
	 * Classic 타입의 페이지 익스플로러 만들기
	 */
	public void makeClassicPageExplorer() {
		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class);

		printPageExplorerInfo("makeClassicPageExplorer", pageExplorer);
	}

	/**
	 * Google 페이져형태의 페이지 익스플로러 만들기
	 */
	public void makeListPageExplorer() {
		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ListPageExplorer.class);

		printPageExplorerInfo("makeListPageExplorer", pageExplorer);
	}

	/**
	 * Classic 타입의 페이지 익스플로러 만들기
	 * 검색을 위한 객체가 있을 경우 사용함.
	 */
	public void makeClassicPageExplorerWithSearchObject() {
		// 클래스 내용 참고!
		TestSearchVO testSearchVO = new TestSearchVO();

		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, testSearchVO);

		printPageExplorerInfoWithSearchObject("makeClassicPageExplorerWithSearchObject", pageExplorer, testSearchVO);
	}

	/**
	 * Google 페이져형태의 페이지 익스플로러 만들기
	 * 검색을 위한 객체가 있을 경우 사용함.
	 */
	public void makeListPageExplorerWithSearchObject() {
		// 클래스 내용 참고!
		TestSearchVO testSearchVO = new TestSearchVO();

		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ListPageExplorer.class, testSearchVO);

		printPageExplorerInfoWithSearchObject("makeListPageExplorerWithSearchObject", pageExplorer, testSearchVO);
	}

	/**
	 * PageExplorer에 Query 결과 넣기
	 */
	public void makePageExplorerAndSettingList() {
		// 클래스 내용 참고!
		TestSearchVO testSearchVO = new TestSearchVO();

		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ListPageExplorer.class, testSearchVO);

		// PageExplorer에 Query 결과 넣기
		List<TestModel> list = Arrays.asList(new TestModel("JMC"), new TestModel("JMS"));
		pageExplorer.setList(list);

		printPageExplorerInfoWithSearchObject("makePageExplorerAndSettingList", pageExplorer, testSearchVO);
	}

	/**
	 * Page Navigation 만들기
	 */
	public void makePagerBasic() {
		TestSearchVO testSearchVO = new TestSearchVO();

		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, testSearchVO);

		List<TestModel> list = Arrays.asList(new TestModel("JMC"), new TestModel("JMS"));
		pageExplorer.setList(list);

		//Page Navigation 만들기
		String navigagtion = pageExplorer.make();
		printPageExplorerInfoWithSearchObject("makePagerBasic", pageExplorer, testSearchVO);
		System.out.println("pageExplorer.make() : " + navigagtion);
		System.out.println();
	}

	/**
	 * Page Navigation 만들기
	 */
	public void makePagerCustom() {
		TestSearchVO testSearchVO = new TestSearchVO();

		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, testSearchVO);

		List<TestModel> list = Arrays.asList(new TestModel("JMC"), new TestModel("JMS"));
		pageExplorer.setList(list);

		//Custom 하기 & Page Navigation 만들기
		String navigagtion = pageExplorer.setData("pageNo", "@", "이전", "다음", "searchForm")
										 .make();
		printPageExplorerInfoWithSearchObject("makePagerCustom", pageExplorer, testSearchVO);
		System.out.println("pageExplorer.make() : " + navigagtion);
		System.out.println();
	}

	/**
	 * Page Navigation 만들기
	 */
	public void makePagerCustomUsePageOption() {
		TestSearchVO testSearchVO = new TestSearchVO();

		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, testSearchVO);

		List<TestModel> list = Arrays.asList(new TestModel("JMC"), new TestModel("JMS"));
		pageExplorer.setList(list);

		// 커스텀 하기 - 원하는 것만 수정할 수 있다
		// link, formId, pageFormat, prev, next
		PageOption option = new PageOption()
								.link("pageNumber")
								.pageFormat(" [@] ");

		//Page Navigation 만들기
		String navigagtion = pageExplorer.setData(option)
										 .make();
		printPageExplorerInfoWithSearchObject("makePagerCustomUsePageOption", pageExplorer, testSearchVO);
		System.out.println("pageExplorer.make() : " + navigagtion);
		System.out.println();
	}

	public void makePagerUICustom() {
		TestSearchVO testSearchVO = new TestSearchVO();

		Pager pager = PagerFactory.getPager(Pager.ORACLE, "17", 220);
		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, testSearchVO);

		List<TestModel> list = Arrays.asList(new TestModel("JMC"), new TestModel("JMS"));
		pageExplorer.setList(list);

		// 커스텀 하기 - 원하는 것만 수정할 수 있다
		// link, formId, pageFormat, prev, next
		PageOption option = new PageOption()
				.link("pageNumber")
				.pageFormat(" [@] ");

		//Page Navigation 만들기
		String navigagtion = pageExplorer.setData(option)
				// UI Custom, 원형은 "Decorator" 클래스에 있음.
				// 아래 4개 중 원하는 것만 선택할 수 있음
				// 이전 버튼
				.prevGroup((prevGroupPageNumber, prev) -> {
					return "<div onclick=\"movePage('" + prevGroupPageNumber + "')\">" + prev + "</div>";
				})
				// 다음 버튼
				.nextGroup((nextGroupPageNumber, next) -> {
					return "<div onclick=\"movePage('" + nextGroupPageNumber + "')\">" + next + "</div>";
				})
				// 페이지 버튼
				.pages((pageNo, pageFormat) -> {
					return "<div onclick=\"movePage('" + pageNo + "')\">" + pageFormat + "</div>";
				})
				// 현재 선택된 버튼
				.highlight(pageNo -> {
					return "<div>"+pageNo+"</div>";
				})
				.make();
		printPageExplorerInfoWithSearchObject("makePagerUICustom", pageExplorer, testSearchVO);
		System.out.println("pageExplorer.make() : " + navigagtion);
		System.out.println();
	}

	private void printPageExplorerInfo(String methodName, PageExplorer pageExplorer) {
		System.out.println("===============" + methodName + "===============");
		System.out.println("PageExplorer Type " + pageExplorer.getClass().getSimpleName());
		System.out.println("pageExplorer.getTotalCount() : " + pageExplorer.getTotalCount());
		List<TestModel> list = pageExplorer.getList();
		if ( list != null ) {
			list.forEach(testModel -> {
				System.out.println("pageExplorer.getList() : " + testModel.getName());
			});
		}
		System.out.println();
	}

	private void printPageExplorerInfoWithSearchObject(String methodName, PageExplorer pageExplorer, TestSearchVO testSearchVO) {
		System.out.println("===============" + methodName + "===============");
		System.out.println("PageExplorer Type " + pageExplorer.getClass().getSimpleName());
		System.out.println("pageExplorer.getTotalCount() : " + pageExplorer.getTotalCount());
		System.out.println("testSearchVO.getStartRow() : " + testSearchVO.getStartRow());
		System.out.println("testSearchVO.getEndRow() : " + testSearchVO.getEndRow());
		List<TestModel> list = pageExplorer.getList();
		if ( list != null ) {
			list.forEach(testModel -> {
				System.out.println("pageExplorer.getList() : " + testModel.getName());
			});
		}
		System.out.println();
	}


	
}
