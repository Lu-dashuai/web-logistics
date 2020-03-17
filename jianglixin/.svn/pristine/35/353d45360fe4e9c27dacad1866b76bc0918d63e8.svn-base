package com.lightning.dao.impl.yuhaiyang;

import java.util.List;

import com.lightning.bean.yuhaiyang.Time;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.yuhaiyang.TimeDao;

public class TimeDaoImpl implements TimeDao {

	BaseDao base=new BaseDao();
	/**
	 * 根据车辆id增加一条数据对于time表
	 * @param time
	 * @return
	 */
	@Override
	public int insertTime(Time time) {
		// TODO Auto-generated method stub
		String sql="insert into time(time_car_id,time_start,time_date) values(?,?,?)";
		try {
			base.update(sql, new Object[] {time.getTime_car_id(),time.getTime_start(),time.getTime_date()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	/**
	 * 根据车辆id查询time表中的发车时间
	 * @param time
	 * @return
	 */
	@Override
	public List selectTime(Time time) {
		// TODO Auto-generated method stub
		String sql="select time_start,time_date from time where time_car_id=? and time_end is null";
		try {
			List list=base.query(sql, new Object[] {time.getTime_car_id()});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据车辆id将到达时间添加进去
	 * @param time
	 * @return
	 */
	@Override
	public int updateTime(Time time) {
		String sql="update time set time_end=? where time_car_id=? and time_end is null";
		base.update(sql, new Object[] {time.getTime_end(),time.getTime_car_id()});
		return -1;
	}

}
