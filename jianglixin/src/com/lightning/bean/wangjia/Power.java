package com.lightning.bean.wangjia;

public class Power {
	private int power_id;//权限ID(不是null)(主键)
	private String power_type;//权限类型
	private Integer power_parent;
	
	
	
	public int getPower_id() {
		return power_id;
	}
	public void setPower_id(int power_id) {
		this.power_id = power_id;
	}
	public String getPower_type() {
		return power_type;
	}
	public void setPower_type(String power_type) {
		this.power_type = power_type;
	}
	public Power(int power_id, String power_type, Integer power_parent) {
		super();
		this.power_id = power_id;
		this.power_type = power_type;
		this.power_parent = power_parent;
	}
	public Integer getPower_parent() {
		return power_parent;
	}
	public void setPower_parent(Integer power_parent) {
		this.power_parent = power_parent;
	}
	public Power() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
