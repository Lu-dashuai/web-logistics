package com.lightning.action.wangjia;

import java.util.List;

import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangjia.Role;
import com.lightning.bean.wangjia.Worker;
import com.lightning.dao.impl.wangjia.RoleDaoImpl;
import com.lightning.dao.impl.wangjia.WorkerDaoImpl;
import com.lightning.dao.wangjia.RoleDao;
import com.lightning.dao.wangjia.WorkerDao;

public class RoleAction extends BaseAction{
	private Role role;
	private List rowRole;
	private List tabRole;
	private RoleDao roledao=new RoleDaoImpl();
	
	
	private Worker worker;
	private WorkerDao workerdao=new WorkerDaoImpl();
	
	
	public String insertRole(){
		int key=workerdao.insertWoker(worker);
		role.setRole_worker(key);
		roledao.insertRole(role);
		return "success";
	}

	public List getRowRole() {
		return rowRole;
	}

	public void setRowRole(List rowRole) {
		this.rowRole = rowRole;
	}

	public List getTabRole() {
		return tabRole;
	}

	public void setTabRole(List tabRole) {
		this.tabRole = tabRole;
	}

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleDao getRoledao() {
		return roledao;
	}

	public void setRoledao(RoleDao roledao) {
		this.roledao = roledao;
	}
}
