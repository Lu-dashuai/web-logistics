package com.lightning.dao.impl.wuminghui;

import java.util.List;

import com.lightning.bean.wuminghui.Way;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wuminghui.WayDao;

public class WayDaoImpl implements WayDao{

	@Override
	public void insertWay(Way way) {
		String sql="insert into Way(way_car,way_direction,way_km) values(?,?,?)";
		BaseDao.update(sql, new Object[]{
				way.getWay_car(),way.getWay_direction(),way.getWay_km()
		});
	}

	@Override
	public void deleteWay(Way way) {
		String sql="delete from way where way_car=?";
		BaseDao.update(sql, new Object[] {way.getWay_car()});
		
	}

	@Override
	public void updateWay(Way way) {
		String sql="update way set way_direction=?,way_km=? where way_car=?";
		BaseDao.update(sql, new Object[] {way.getWay_direction(),way.getWay_km(),way.getWay_car()});
		
	}

	@Override
	public List findWay() {
		String sql="select way_car,way_direction,way_km from way";
		return BaseDao.query(sql, null);
	}

	@Override
	public List findOneWay(Way way) {
		String sql="select way_car,way_direction,way_km from way where way_car=?";
		return BaseDao.query(sql, new Object[] {way.getWay_car()});
	}
	
	//查来车方法，勿动
	@Override
	public List findCarOnWay(Way way) {
		String sql="select way_car from way where way_direction=?";
		return BaseDao.query(sql, new Object[] {way.getWay_direction()});
	}
	//查询自己来车并且状态是3的车辆
	@Override
	public List findCarOnStation(int belong) {
		String sql="select * from car where car_belong_station=? and car_state=3";
		return BaseDao.queryMap(sql, new Object[] {belong});
	}
	@Override
	public List findKmOnWay(int star,int end) {
		String sql="select wa.way_km from car ca left join way wa on wa.way_car=ca.car_id where ca.car_belong_station=? and wa.way_direction=?";
		return BaseDao.query(sql, new Object[] {star,end});
	}
}
