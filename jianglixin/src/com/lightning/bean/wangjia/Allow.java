package com.lightning.bean.wangjia;

public class Allow {
	private int allow_power;//外联power_id(不是null)
	private int allow_post;//外联post_id
	public int getAllow_power() {
		return allow_power;
	}
	public void setAllow_power(int allow_power) {
		this.allow_power = allow_power;
	}
	public int getAllow_post() {
		return allow_post;
	}
	public void setAllow_post(int allow_post) {
		this.allow_post = allow_post;
	}
	public Allow(int allow_post) {
		super();
		this.allow_post = allow_post;
	}
	public Allow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Allow(int allow_power, int allow_post) {
		super();
		this.allow_power = allow_power;
		this.allow_post = allow_post;
	}
}
