package com.aaa.mvc.entity;

import java.util.List;

public class StoreTreeNode {
	 private int id;
	 private String text;
	 private int parentId;
	 private String state;
	 private String iconCls;
	 private String url;	 
	 /**
	  * 门店权限树有参构造
	  * @param id
	  * @param text
	  * @param parentId
	  * @param state
	  * @param iconCls
	  * @param url
	  */
	
	public StoreTreeNode(int id, String text, int parentId, String state,
			String iconCls, String url) {
		super();
		this.id = id;
		this.text = text;
		this.parentId = parentId;
		this.state = state;
		this.iconCls = iconCls;
		this.url = url;
	}
	/**
	 * 无参构造
	 */
	public StoreTreeNode(){};
	
	private List<StoreTreeNode> children;
	public List<StoreTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<StoreTreeNode> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}