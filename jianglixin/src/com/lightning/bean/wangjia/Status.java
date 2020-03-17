package com.lightning.bean.wangjia;

public class Status {
	private int status_id;//状态id(不是null)(是主键)
	private String status_name;//状态信息
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public Status(String status_name) {
		super();
		this.status_name = status_name;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status(int status_id, String status_name) {
		super();
		this.status_id = status_id;
		this.status_name = status_name;
	}
}
