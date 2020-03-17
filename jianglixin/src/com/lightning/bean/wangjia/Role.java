package com.lightning.bean.wangjia;

public class Role {
	private int role_worker;//员工的编号(不是null)(是主键)
	private int role_post;//职位的编号
	public Role(int role_post) {
		super();
		this.role_post = role_post;
	}
	public Role(int role_worker, int role_post) {
		super();
		this.role_worker = role_worker;
		this.role_post = role_post;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRole_worker() {
		return role_worker;
	}
	public void setRole_worker(int role_worker) {
		this.role_worker = role_worker;
	}
	public int getRole_post() {
		return role_post;
	}
	public void setRole_post(int role_post) {
		this.role_post = role_post;
	}
}