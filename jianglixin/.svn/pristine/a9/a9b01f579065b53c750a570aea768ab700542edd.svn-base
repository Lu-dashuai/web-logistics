package com.lightning.dao.impl.wuminghui;

import java.util.List;

import com.lightning.bean.util.Page;
import com.lightning.bean.wuminghui.Station;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wuminghui.StationDao;

public class StationDaoImpl implements StationDao{
	/**
	 * 增加网点
	 * */
	@Override
	public void insertStation(Station station) {
		String sql="insert into Station(station_name,station_address,station_admin,station_phone) values(?,?,?,?)";
		BaseDao.update(sql, new Object[]{
				station.getStation_name(),station.getStation_address(),station.getStation_admin(),station.getStation_phone()
		});
	}
	/**
	 * 删除一条网点信息
	 * */
	@Override
	public void deleteStation(Station station) {
		String sql="delete from Station where station_id=?";
		BaseDao.update(sql, new Object[]{
				station.getStation_id()
		});
		
	}
	/**
	 * 修改一个网点信息
	 * */
	@Override
	public void updateStation(Station station) {
		String sql="update station set station_name=?,station_address=?,station_admin=?,station_phone=? where station_id= ?";
		BaseDao.update(sql, new Object[]{
				station.getStation_name(),station.getStation_address(),station.getStation_admin(),station.getStation_phone(),station.getStation_id()
		});
	}
	/**
	 * 查询所有网点信息
	 * */
	@Override
	public List findStation() {
		String sql="select station_id,station_name,station_address,station_admin,station_phone from station";
		return BaseDao.query(sql, null);
	}
	
	/**
	 * 查询网点经理
	 * */
	public List findAdminStation() {
		String sql="select wor.worker_id,wor.worker_name from worker wor left join post post on wor.worker_post=post.post_id where post.post_name=\"网点经理\"";
		return BaseDao.query(sql, null);
	}
	
	/**
	 * 查询一条进行修改
	 * */
	@Override
	public List findOneStation(Station station) {
		String sql="select station_id,station_name,station_address,station_admin,station_phone from station where station_id=?";
		return BaseDao.query(sql, new Object[] {station.getStation_id()});
	}

	/* (non-Javadoc)
	 * @see com.lightning.dao.wuminghui.StationDao#findCountStation()
	 */
	@Override
	public List findCountStation() {
		String sql="select count(*) from station";
		return BaseDao.query(sql, null);
	}
 
	/* (non-Javadoc)
	 * @see com.lightning.dao.wuminghui.StationDao#findlimitStation(com.lightning.bean.util.Page)
	 */
	/**
	 * 分页查询
	 * */
	@Override
	public List findlimitStation(Page page) {
		String sql="select sta.station_id,sta.station_name,"
				+ "sta.station_address,wo.worker_name,"
				+ "sta.station_phone from station sta left join "
				+ "worker wo on wo.worker_id=sta.station_admin limit ?,? ";
		return BaseDao.query(sql, new Object[] {page.getStartIndex(),page.getMax()});
	}

	/* (non-Javadoc)
	 * @see com.lightning.dao.wuminghui.StationDao#findlimitWay(com.lightning.bean.util.Page)
	 */

}
