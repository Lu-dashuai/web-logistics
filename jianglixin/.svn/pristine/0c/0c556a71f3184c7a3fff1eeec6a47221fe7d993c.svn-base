package com.lightning.action.wuminghui;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.lightning.action.base.BaseAction;
import com.lightning.bean.wuminghui.State;
import com.lightning.dao.impl.wuminghui.StateDaoImpl;
import com.lightning.dao.wuminghui.StateDao;

@Namespace("/State")
public class StateAction extends BaseAction{
	private State state;
	private List tabState;
	private List rowState;
	private StateDao statedao=new StateDaoImpl();

	/**
	 * 增加一条车辆状态信息
	 * */
	@Action(value="insertState",results= {@Result(location="/before/wuminghui/showState.jsp")})
	public String insertState(){
		statedao.insertState(state);
		return findState();
	}
	/**
	 * 删除一条车辆信息，一般不进行此操作
	 * @return
	 */
	@Action(value="deleteState",results= {@Result(location="/before/wuminghui/showState.jsp")})
	public String deleteState() {
		statedao.deleteState(state);
		return findState();
	}
	/**
	 * 查询所有车辆状态
	 * @return
	 */
	@Action(value="findState",results= {@Result(location="/before/wuminghui/showState.jsp")})
	public String findState() {
		tabState=statedao.findState();
		return "success";
	}
	/**
	 * 根据ID查询到一条车辆状态进行修改
	 * @return
	 */
	@Action(value="findOneState",results= {@Result(name="updateState",location="/before/wuminghui/updateState.jsp")})
	public String findOneState() {
		tabState=statedao.findOneState(state);
		rowState=(List) tabState.get(0);
		return "updateState";
	}
	/**
	 * 修改信息
	 * @return
	 */
	@Action(value="updateState",results= {@Result(location="/before/wuminghui/showState.jsp")})
	public String updateState() {
		statedao.updateState(state);
		return findState();
	}
	
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List getTabState() {
		return tabState;
	}

	public void setTabState(List tabState) {
		this.tabState = tabState;
	}

	public List getRowState() {
		return rowState;
	}

	public void setRowState(List rowState) {
		this.rowState = rowState;
	}

	public StateDao getStatedao() {
		return statedao;
	}

	public void setStatedao(StateDao statedao) {
		this.statedao = statedao;
	}

	
}
