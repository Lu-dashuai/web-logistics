package com.lightning.dao.impl.wuminghui;

import java.util.List;

import com.lightning.bean.wuminghui.Driver;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wuminghui.DriverDao;

public class DriverDaoImpl implements DriverDao {

	@Override
	public void insertDriver(Driver driver) {
		String sql="insert into driver(driver_worker,driver_car) values(?,?)";
		BaseDao.update(sql, new Object[]{
				driver.getDriver_worker(),driver.getDriver_car()
		});
	}

	@Override
	public void deleteDriver(Driver driver) {
		String sql="delete from driver where driver_worker=?";
		BaseDao.update(sql, new Object[] {driver.getDriver_worker()});
	}

	@Override
	public void updateDriver(Driver driver) {
		String sql="update driver set driver_car=? where driver_worker=?";
		BaseDao.update(sql, new Object[] {driver.getDriver_car(),driver.getDriver_worker()});
		
	}

	@Override
	public List findDriver() {
		String sql="select wor.worker_id,wor.worker_name from worker wor left join post post on wor.worker_post=post.post_id where post.post_name=\"司机\"";
		return BaseDao.query(sql, null);
	}
	@Override
	public List findAllDriver() {
		String sql="select worker.worker_name,car.car_type from driver  " + 
				" left join car on driver.driver_car=car.car_id " + 
				" left join worker on driver.driver_worker=worker.worker_id " + 
				" left join post on worker.worker_post=post.post_id " + 
				" where post.post_name=\"司机\"";
		return BaseDao.query(sql, null);
	}
	@Override
	public List findOneDriver(Driver driver) {
		String sql="select driver_worker,driver_car from driver where driver_worker=?";	
		return BaseDao.query(sql, new Object[] {driver.getDriver_worker()});
	}

}
