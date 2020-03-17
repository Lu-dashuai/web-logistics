package com.lightning.bean.wangzelong;

public class Bills {
	private int bills_indent;//订单id
	private String bills_users;//用户id
	private int bills_shape;//订单是否删除的状态  1为未处理 2为已删除
	
	public Bills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bills(int bills_indent, String bills_users, int bills_shape) {
		super();
		this.bills_indent = bills_indent;
		this.bills_users = bills_users;
		this.bills_shape = bills_shape;
	}
	public Bills(String bills_users, int bills_shape) {
		super();
		this.bills_users = bills_users;
		this.bills_shape = bills_shape;
	}
	public Bills(int bills_indent) {
		super();
		this.bills_indent = bills_indent;
	}
	
	
	public int getBills_indent() {
		return bills_indent;
	}
	public void setBills_indent(int bills_indent) {
		this.bills_indent = bills_indent;
	}
	public String getBills_users() {
		return bills_users;
	}
	public void setBills_users(String bills_users) {
		this.bills_users = bills_users;
	}
	public int getBills_shape() {
		return bills_shape;
	}
	public void setBills_shape(int bills_shape) {
		this.bills_shape = bills_shape;
	}
	
}
