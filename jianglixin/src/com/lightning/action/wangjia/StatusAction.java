package com.lightning.action.wangjia;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangjia.Status;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wangjia.StatusDaoImpl;
import com.lightning.dao.wangjia.StatusDao;


@Namespace("/Status")
public class StatusAction extends BaseAction{
	private Status status;
	private List tabStatus;
	private List rowStatus;
	private StatusDao statusdao=new StatusDaoImpl();
	
	public String insertStatus(){
		statusdao.insertStatus(status);
		target="/before/wangjia/showStatus";
		return "success";
	}

	@Action(value="countList")
	public String countList() {
		statusdao.countWorker();
		String str=JSON.toJSONString(statusdao.countWorker());
		print(str);
		return null; 
		
	}
	
	@Action(value="findStatus")
	public String findStatus() {
		List<List> tabStatus=statusdao.findStatus();
		print(JSON.toJSONString(tabStatus));
		return null;
		
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public StatusDao getStatusdao() {
		return statusdao;
	}



	public List getTabStatus() {
		return tabStatus;
	}

	public void setTabStatus(List tabStatus) {
		this.tabStatus = tabStatus;
	}

	public List getRowStatus() {
		return rowStatus;
	}

	public void setRowStatus(List rowStatus) {
		this.rowStatus = rowStatus;
	}

	public void setStatusdao(StatusDao statusdao) {
		this.statusdao = statusdao;
	}

	
}
