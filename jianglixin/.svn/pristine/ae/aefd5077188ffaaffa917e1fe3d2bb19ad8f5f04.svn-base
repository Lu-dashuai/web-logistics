package com.lightning.bean.util;

public class Page {
	private int startIndex = 0;// 开始条数下标
	private Integer max;// 最大条数
	private Integer currPage;// 当前页码
	private Integer maxPage;
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	//从前台传递过来的数据库是：offset：从哪一条开始查询，刚好是startIndex
	public Page(int startIndex, Integer max) {
		super();
		this.startIndex = startIndex;
		this.max = max;
	}
	
	
	
	public int getStartIndex() {
		if(this.startIndex>0) {
			return this.startIndex;
		}
		return (getCurrPage()-1)*getMax();
	}



	public Integer getMax() {
		return max==null?10:max;
	}



	public void setMax(Integer max) {
		this.max = max;
	}



	public Integer getCurrPage() {
		return currPage==null||currPage<=0?1:currPage;
	}



	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	
	
}
