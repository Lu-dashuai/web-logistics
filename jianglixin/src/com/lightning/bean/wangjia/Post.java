package com.lightning.bean.wangjia;

public class Post {
	private int post_id;//职位编号(不是null)(长度11)
	private String post_name;//职位名字
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(String post_name) {
		super();
		this.post_name = post_name;
	}
	public Post(int post_id, String post_name) {
		super();
		this.post_id = post_id;
		this.post_name = post_name;
	}
	public int getPost_id() {
		return post_id;
	}
	public Post(int post_id) {
		super();
		this.post_id = post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
}
