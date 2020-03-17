package com.lightning.dao.yuhaiyang;

import java.util.List;

import com.lightning.bean.yuhaiyang.Time;

public interface TimeDao {
	/**
	 * 根据车辆id增加一条数据对于time表
	 * @param time
	 * @return
	 */
	public int insertTime(Time time);
	/**
	 * 根据车辆id查询time表中的发车时间
	 * @param time
	 * @return
	 */
	public List selectTime(Time time);
	/**
	 * 根据车辆id将到达时间添加进去
	 * @param time
	 * @return
	 */
	public int updateTime(Time time);
}
