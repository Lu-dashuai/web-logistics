package com.lightning.dao.wuminghui;

import java.util.List;

import com.lightning.bean.wuminghui.State;

public interface StateDao {
	void insertState(State state);
	void deleteState(State state);
	void updateState(State state);
	List findState();
	List findOneState(State state);
}
