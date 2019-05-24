package com.cafe24.mysite.vo;

public class Page {
	

	private int perPage;
	private int lastPage;
	
	private int start;
	private int end;
	

	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	public void makePageList(int currentPage) {
		start = ((int) Math.floor((currentPage-1)/perPage)*perPage)+1;;
		end	  = start+(perPage-1);
	}
	
	public void getLastPage(int Listsize) {
		if( Listsize % perPage == 0) {
			lastPage = (int)Math.floor(Listsize/perPage);
		}else {
			lastPage = (int)Math.floor(Listsize/perPage)+1;
		}
	}
	
}
