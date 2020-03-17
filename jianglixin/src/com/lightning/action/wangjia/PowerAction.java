package com.lightning.action.wangjia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangjia.Allow;
import com.lightning.bean.wangjia.Power;
import com.lightning.dao.impl.wangjia.AllowDaoImpl;
import com.lightning.dao.impl.wangjia.PowerDaoImpl;
import com.lightning.dao.wangjia.AllowDao;
import com.lightning.dao.wangjia.PowerDao;
@Namespace("/Power")
public class PowerAction extends BaseAction{
	private Power power;
	private List tabPower;
	private List rowPower;
	private PowerDao powerdao=new PowerDaoImpl();
	
	private Allow allow=new Allow();
	private AllowDao allowdao=new AllowDaoImpl();

	@Action(value="insertPower")
	public String insertPower(){
		powerdao.insertPower(power);
		print("ok");
		return null;
	}
	
	@Action(value="deletePower")                       //,results= {@Result(location="/before/wangjia/showPower.jsp")}
	public String deletePower() {
		int count = powerdao.deletePower(power);
		allow.setAllow_power(power.getPower_id());
		allowdao.deleteAllowPower(allow);
		print(count+"");
		return null;
	}
	
	@Action(value="findOnePower",results= {@Result(name="updatePower",location="/before/wangjia/updatePower.jsp")})
	public String findOnePower() {
		tabPower=powerdao.findOnePower(power);
		rowPower=(List)tabPower.get(0);
		return "updatePower";
	}
	
	@Action(value="updatePower",results= {@Result(location="/before/wangjia/showPower.jsp")})
	public String updatePower() {
		powerdao.updatePower(power);
		return findAllPower();
	}
	
	@Action(value="findAllPower")
	public String findAllPower() {
		tabPower = powerdao.findPower();
		String jsonStr=JSON.toJSONString(tabPower);
		print(jsonStr);
		return null;
	}
	
	
	public List getTabPower() {
		return tabPower;
	}

	public void setTabPower(List tabPower) {
		this.tabPower = tabPower;
	}

	public List getRowPower() {
		return rowPower;
	}

	public void setRowPower(List rowPower) {
		this.rowPower = rowPower;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public PowerDao getPowerdao() {
		return powerdao;
	}

	public void setPowerdao(PowerDao powerdao) {
		this.powerdao = powerdao;
	}

	public Allow getAllow() {
		return allow;
	}

	public void setAllow(Allow allow) {
		this.allow = allow;
	}

	public AllowDao getAllowdao() {
		return allowdao;
	}

	public void setAllowdao(AllowDao allowdao) {
		this.allowdao = allowdao;
	}
	
}
