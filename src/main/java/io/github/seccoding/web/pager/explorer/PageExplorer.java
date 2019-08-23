package io.github.seccoding.web.pager.explorer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.decorator.Decorator;

public abstract class PageExplorer {

	protected boolean isSetData;
	protected Pager pager;
	protected Decorator decorator;
	
	protected String formId;
	protected String link;
	protected String pageFormat;
	protected String prev;
	protected String next;
	
	protected Function<String, String> makeHighlight;
	protected BiFunction<Integer, String, String> makePrevGroup;
	protected BiFunction<Integer, String, String> makeNextGroup;
	protected BiFunction<Integer, String, String> makePageLinks;

	private int totalCount;

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public PageExplorer setData(PageOption pageOption) {
		return setData(pageOption.link(), pageOption.pageFormat(), pageOption.prev(), pageOption.next(), pageOption.formId());
	}

	/**
	 * JSP에서 Paging 결과를 보여준다.
	 * @param link Page 번호를 전달할 Parameter Name
	 * @param pageFormat Page 번호를 보여줄 패턴 @(at)가 페이지 번호로 치환된다. [@]로 작성할 경우 [1] [2] [3] 처럼 보여진다.
	 * @param prev 이전 페이지 그룹으로 가는 버튼의 이름을 작성한다.
	 * @param next 다음 페이지 그룹으로 가는 버튼의 이름을 작성한다.
	 * @param formId 서버에게 전달될 Form 의 아이디를 작성한다.
	 * @return PageExplorer
	 */
	public PageExplorer setData(String link, String pageFormat, String prev, String next, String formId) {
		this.isSetData = true;
		this.formId = formId;
		this.link = link;
		this.pageFormat = pageFormat;
		this.prev = prev;
		this.next = next;
		return this;
	}
	
	public String make() {
		if ( !isSetData ) {
			setData(new PageOption());
		}
		
        StringBuffer buffer = decorator.makeForm(formId, link);
        
		return generate(buffer);
	}
	
	protected abstract String generate(StringBuffer pagenation);
	
	/**
	 * 현재 선택된 페이지 하이라이팅
	 * <dl><dd>
	 * "&lt;b&gt;" + pageNo + "&lt;/b&gt;"
	 * </dd></dl>
	 * @param f 1. 현재 선택된 페이지 번호(pageNo)
	 * @return PageExplorer
	 */
	public PageExplorer highlight(Function<String, String> f) {
		this.makeHighlight = f;
		return this;
	}
	
	/**
	 * 이전 그룹/페이지로 이동하는 링크 만들기
	 * <dl><dd>
	 * "&lt;a href=\"javascript:movePage('" + prevGroupPageNumber + "')\"&gt;" + prev + "&lt;/a&gt;";
	 * </dd></dl>
	 * @param f 1. 이전 그룹번호/페이지 번호(prevGroupPageNumber), 2. 링크 명(prev)
	 * @return PageExplorer
	 */
	public PageExplorer prevGroup(BiFunction<Integer, String, String> f) {
		this.makePrevGroup = f;
		return this;
	}
	
	/**
	 * 다음 그룹/페이지로 이동하는 링크 만들기
	 * <dl><dd>
	 * "&lt;a href=\"javascript:movePage('" + nextGroupPageNumber + "')\"&gt;" + next + "&lt;/a&gt;";
	 * </dd></dl>
	 * @param f 1. 다음 그룹번호/페이지 번호(nextGroupPageNumber) 2. 링크(next)
	 * @return PageExplorer
	 */
	public PageExplorer nextGroup(BiFunction<Integer, String, String> f) {
		this.makeNextGroup = f;
		return this;
	}
	
	/**
	 * 페이지 네비게이터 만들기(1,2,3,4,....)
	 * <dl><dd>
	 * "&lt;a href=\"javascript:movePage('" + pageNo + "')\"&gt;" + pageFormat + "&lt;/a&gt;";
	 * </dd></dl>
	 * @param f 1. 페이지 번호(pageNo), 2. 페이지 포멧(pageFormat)
	 * @return PageExplorer
	 */
	public PageExplorer pages(BiFunction<Integer, String, String> f) {
		this.makePageLinks = f;
		return this;
	}
	
	
	protected String makePrevGroup(int prevGroupPageNumber) {
		if(makePrevGroup == null) {
			return decorator.makePrevGroup(prevGroupPageNumber, prev);
		}
		else {
			return makePrevGroup.apply(prevGroupPageNumber, prev);
		}
	}
	
	protected String makeHighlightNowPageNumber(String pageNumber) {
		if ( makeHighlight == null ) {
			return decorator.makeHighlightNowPageNumber(pageNumber);
		}
		else {
			return makeHighlight.apply(pageNumber);
		}
	}
	
	protected String makePageNumbers(int i, String pageNumber) {
		if ( makePageLinks == null ) {
	    	return decorator.makePageNumbers(i, pageNumber);
	    }
	    else {
	    	return makePageLinks.apply(i, pageNumber);
	    }
	}
	
	protected String makeNextGroup(int nextGroupPageNumber) {
		if ( makeNextGroup == null ) {
			return decorator.makeNextGroup(nextGroupPageNumber, next);
		}
		else {
			return makeNextGroup.apply(nextGroupPageNumber, next);
		}
	}

	public List<? extends Object> list;

	public PageExplorer setList(List<? extends Object> list) {
		this.list = list;
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getList(Class<? extends Object> cls) {
		
		if ( this.list == null ) {
			return new ArrayList<>();
		}
		
		final List<T> result = new LinkedList<T>();
		this.list.forEach(obj -> {
			result.add((T) obj);
		});
		
		return result;
	}

}



