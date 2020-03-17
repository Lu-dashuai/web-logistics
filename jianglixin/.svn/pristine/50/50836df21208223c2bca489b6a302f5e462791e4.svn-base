package com.lightning.action.makui;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.makui.Company;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.makui.CompanyDaoImpl;
import com.lightning.dao.makui.CompanyDao;
@Namespace("/Company")
public class CompanyAction extends BaseAction{
	private Company company;
	private CompanyDao companydao = new CompanyDaoImpl();
	private List tabCompany;
	private List rowCompany;
	//添加公司信息
	@Action(value="insertCompany",results={@Result(location="/later/makui/showCompany.jsp")})
	public String insertCompany(){
		companydao.insertCompany(company);
		return showUser();
	}
	private String showUser() {
		tabCompany = companydao.findCompany();
		return "success";
	}
	//查询所有的公司信息
	@Action(value="findCompany")
	public String findCompany() {
		List<List> tabCompany = companydao.findCompany();
		print(JSON.toJSONString(tabCompany));
		return null;
	}
	//修改一条公司信息
	public String updateUser(){
		companydao.updateCompany(company);
	return showUser();
	}
	//查询一条公司信息
	public String findone(){
		tabCompany=companydao.findOneCompany(company);
		rowCompany=(List) tabCompany.get(0);
		return "findone";
	}
	//删除一条公司信息
	public String delete(){
		companydao.deleteCompany(company);
		return showUser();
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public CompanyDao getCompanydao() {
		return companydao;
	}
	public void setCompanydao(CompanyDao companydao) {
		this.companydao = companydao;
	}
	public List getTabCompany() {
		return tabCompany;
	}
	public void setTabCompany(List tabCompany) {
		this.tabCompany = tabCompany;
	}
	public List getRowCompany() {
		return rowCompany;
	}
	public void setRowCompany(List rowCompany) {
		this.rowCompany = rowCompany;
	}

}
