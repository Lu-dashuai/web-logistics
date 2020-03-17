package com.lightning.bean.yuhaiyang;

public class Comein {
	private Integer comein_id;//入库ID
	private Integer comein_indent;//订单编号
	private String comein_time;//入库时间
	private Integer comein_station;//网点ID（所属网点）
	
	
	
	public Comein() {
		super();
	}
	public Comein(Integer comein_id, Integer comein_indent, String comein_time, Integer comein_station) {
		super();
		this.comein_id = comein_id;
		this.comein_indent = comein_indent;
		this.comein_time = comein_time;
		this.comein_station = comein_station;
	}
	public Integer getComein_id() {
		return comein_id;
	}
	public void setComein_id(Integer comein_id) {
		this.comein_id = comein_id;
	}
	public Integer getComein_indent() {
		return comein_indent;
	}
	public void setComein_indent(Integer comein_indent) {
		this.comein_indent = comein_indent;
	}
	public String getComein_time() {
		return comein_time;
	}
	public void setComein_time(String comein_time) {
		this.comein_time = comein_time;
	}
	public Integer getComein_station() {
		return comein_station;
	}
	public void setComein_station(Integer comein_station) {
		this.comein_station = comein_station;
	}
	
}
