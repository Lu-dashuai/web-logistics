package com.lightning.bean.makui;

public class Company {
	private String company_name;//公司名称
	private String company_introduce;//公司简介
	private long company_phone;//公司电话
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_introduce() {
		return company_introduce;
	}
	public void setCompany_introduce(String company_introduce) {
		this.company_introduce = company_introduce;
	}
	public long getCompany_phone() {
		return company_phone;
	}
	public void setCompany_phone(long company_phone) {
		this.company_phone = company_phone;
	}
	public Company(String company_name, String company_introduce,
			long company_phone) {
		super();
		this.company_name = company_name;
		this.company_introduce = company_introduce;
		this.company_phone = company_phone;
	}
	public Company(String company_introduce, long company_phone) {
		super();
		this.company_introduce = company_introduce;
		this.company_phone = company_phone;
	}
	public Company(String company_name) {
		super();
		this.company_name = company_name;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
