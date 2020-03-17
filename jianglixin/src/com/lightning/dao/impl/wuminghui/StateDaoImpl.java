package com.lightning.dao.impl.wuminghui;

import java.util.List;

import com.lightning.bean.wuminghui.State;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wuminghui.StateDao;

public class StateDaoImpl implements StateDao{

	@Override
	public void insertState(State state) {
		String sql="insert into State(state_id,state_name) values(?,?)";
		BaseDao.update(sql, new Object[]{
				state.getState_id(),state.getState_name()
		});
		
	}

	@Override
	public void deleteState(State state) {
		String sql="delete from state where state_id=? ";
		BaseDao.update(sql, new Object[] {state.getState_id()});
		
	}

	@Override
	public void updateState(State state) {
		String sql="update state set state_name=? where state_id=?";
		BaseDao.update(sql, new Object[] {state.getState_name(),state.getState_id()});
		
	}

	@Override
	public List findState() {
		String sql="select state_id,state_name from state";
		return BaseDao.query(sql, null);
	}

	@Override
	public List findOneState(State state) {
		String sql="select state_id,state_name from state where state_id=?";
		return BaseDao.query(sql, new Object[] {state.getState_id()});
	}

}
