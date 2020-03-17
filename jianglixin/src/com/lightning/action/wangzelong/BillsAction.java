package com.lightning.action.wangzelong;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.makui.Users;
import com.lightning.bean.wangzelong.Bills;
import com.lightning.bean.wangzelong.Cargo;
import com.lightning.bean.yuhaiyang.Indent;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wangzelong.BillsDaoImpl;
import com.lightning.dao.impl.wangzelong.CargoDaoImpl;
import com.lightning.dao.impl.yuhaiyang.IndentDaoImpl;
import com.lightning.dao.wangzelong.BillsDao;
import com.lightning.dao.wangzelong.CargoDao;
import com.lightning.dao.yuhaiyang.IndentDao;
@Namespace("/Bills")
public class BillsAction extends BaseAction{
	private Bills bills=new Bills();
	private BillsDao billsdao=new BillsDaoImpl();
	private List<List> tabBills;
	private List rowBills;
	private String params;
	@Action(value="judgeUsers",
			results= {@Result(type="redirect",location="/before/wangzelong/showUsersIndentBefore.jsp"),
			@Result(type="redirect",name="Error",location="/before/makui/Userslogin.jsp")})
	public String judgeUsers() {
		//通过判断用户是否登录
		Users users=null;
		users=(Users) getSession().get("users");
		if(users!=null) {
			return "success";
		}else {
			return "Error";
		}
	}
	@Action(value="findBills")
	public String findBills() {
		//通过用户查询给用户的所有订单详情
		Users users=null;
		users=(Users) getSession().get("users");
		if(users!=null) {
			bills.setBills_users(users.getUsers_id());
			List<List> tabIndent=billsdao.findBills(bills);
			CargoDao cargodao=new CargoDaoImpl();
			List JSONCargo=new ArrayList();
			Cargo cargo=new Cargo();
			for(List row:tabIndent) {
				if(row.get(2).equals(1)) {
					cargo.setCargo_indent((int)row.get(0));
					JSONCargo.add(cargodao.findOneCargo(cargo).get(0));
				}
			}
			print(JSON.toJSONString(JSONCargo));
		}
		return null;
	}
	
	@Action(value="findOneBills")
	public String findOneBills() {
		//通过bills_indent获取单个信息
		tabBills=billsdao.findOneBills(bills);
		print(JSON.toJSONString(tabBills));
		return null;
	}
	
	public Bills getBills() {
		return bills;
	}
	public void setBills(Bills bills) {
		this.bills = bills;
	}
	public BillsDao getBillsdao() {
		return billsdao;
	}
	public void setBillsdao(BillsDao billsdao) {
		this.billsdao = billsdao;
	}
	public List<List> getTabBills() {
		return tabBills;
	}
	public void setTabBills(List<List> tabBills) {
		this.tabBills = tabBills;
	}
	public List getRowBills() {
		return rowBills;
	}
	public void setRowBills(List rowBills) {
		this.rowBills = rowBills;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
}
