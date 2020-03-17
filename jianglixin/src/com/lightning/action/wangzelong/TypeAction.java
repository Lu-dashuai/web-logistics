package com.lightning.action.wangzelong;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangzelong.Type;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wangzelong.TypeDaoImpl;
import com.lightning.dao.wangzelong.TypeDao;
@Namespace("/Type")
public class TypeAction extends BaseAction{
	private Type type;
	private TypeDao typedao=new TypeDaoImpl();
	private List tabType;
	private List rowType;
	@Action(value="inserType",results= {@Result(type="redirect",location="/before/wangzelong/showPrice.jsp")})
	public String insertType(){//添加货物类型表
		typedao.insertType(type);
		return "success";
	}
	
	@Action(value="findType")
	public String findType(){//查询并反馈货物类型
		tabType=typedao.findType();
		print(JSON.toJSONString(tabType));
		return null;
	}
	
	@Action(value="updateType",results= {@Result(type="redirect",location="/before/wangzelong/showPrice.jsp")})
	public String updateType() {
		typedao.updateType(type);
		return "success";
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public TypeDao getTypedao() {
		return typedao;
	}
	public void setTypedao(TypeDao typedao) {
		this.typedao = typedao;
	}
	public List getTabType() {
		return tabType;
	}
	public void setTabType(List tabType) {
		this.tabType = tabType;
	}
	public List getRowType() {
		return rowType;
	}
	public void setRowType(List rowType) {
		this.rowType = rowType;
	}
	
	
}
