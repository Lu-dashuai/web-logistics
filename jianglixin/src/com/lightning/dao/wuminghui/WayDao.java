package com.lightning.dao.wuminghui;

import java.util.List;

import com.lightning.bean.wuminghui.Way;

public interface WayDao {
	void insertWay(Way way);
	void deleteWay(Way way);
	void updateWay(Way way);
	List findWay(); 
	List findOneWay(Way way);
	/**
	 * @param way
	 * @return
	 */
	List findCarOnWay(Way way);
	List findKmOnWay(int star, int end);
	//查询3状态的车辆并且属于本网点
	List findCarOnStation(int belong);
}
