package com.lightning.bean.wangzelong;

public class Price {
	private int price_id;//价格编号 
	private float price_km;//公里数每元 
	private float price_ton;//每吨多少钱
	private float price_piece;//每件多少钱
	private int price_province;//省内外多少钱
	private String price_explain;//价格说明填写栏
	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Price(int price_id, float price_km, float price_ton,
			float price_piece, int price_province, String price_explain) {
		super();
		this.price_id = price_id;
		this.price_km = price_km;
		this.price_ton = price_ton;
		this.price_piece = price_piece;
		this.price_province = price_province;
		this.price_explain = price_explain;
	}
	public Price(float price_km, float price_ton, float price_piece,
			int price_province, String price_explain) {
		super();
		this.price_km = price_km;
		this.price_ton = price_ton;
		this.price_piece = price_piece;
		this.price_province = price_province;
		this.price_explain = price_explain;
	}
	public Price(int price_id) {
		super();
		this.price_id = price_id;
	}
	public int getPrice_id() {
		return price_id;
	}
	public void setPrice_id(int price_id) {
		this.price_id = price_id;
	}
	public float getPrice_km() {
		return price_km;
	}
	public void setPrice_km(float price_km) {
		this.price_km = price_km;
	}
	public float getPrice_ton() {
		return price_ton;
	}
	public void setPrice_ton(float price_ton) {
		this.price_ton = price_ton;
	}
	public float getPrice_piece() {
		return price_piece;
	}
	public void setPrice_piece(float price_piece) {
		this.price_piece = price_piece;
	}
	public int getPrice_province() {
		return price_province;
	}
	public void setPrice_province(int price_province) {
		this.price_province = price_province;
	}
	public String getPrice_explain() {
		return price_explain;
	}
	public void setPrice_explain(String price_explain) {
		this.price_explain = price_explain;
	}
	
}
