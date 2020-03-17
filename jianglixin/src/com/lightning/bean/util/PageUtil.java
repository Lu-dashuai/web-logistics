package com.lightning.bean.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
	private int total=0;//记录条数
	private List rows=new ArrayList();
	
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageUtil(int total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
