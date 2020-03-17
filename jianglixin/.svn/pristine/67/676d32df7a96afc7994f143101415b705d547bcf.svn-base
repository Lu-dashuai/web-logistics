package com.lightning.dao.impl.wangjia;

import java.util.ArrayList;
import java.util.List;

import com.lightning.bean.wangjia.Status;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangjia.StatusDao;

public class StatusDaoImpl implements StatusDao{
	//员工状态添加方法
	@Override
	public void insertStatus(Status status) {
		String sql="insert into status(status_id,status_name) values(?,?)";
		BaseDao.update(sql, new Object[]{status.getStatus_id(),status.getStatus_name()});
	}
	//员工状态删除方法		没啥用
	@Override
	public int deleteStatus(Status status) {
		// TODO Auto-generated method stub
		return 0;
	}
	//修改也没用
	@Override
	public void updateStatus(Status status) {
		// TODO Auto-generated method stub
		
	}
	//没用
	@Override
	public List findOneStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}
	//查询所有员工状态
	@Override
	public List findStatus() {
		String sql="select status_id,status_name from status";
		return BaseDao.query(sql, null);
	}
	
	//后台首页统计在职员工数量
	public List countWorker() {
		String countWorker="select count(worker_id) as worker_id from worker where worker_status!=2";
		String countStation="select count(station_id) as station_id from station";
		String countUsers="select count(users_id) as users_id from users";
		String countCar="select count(car_id) as car_id from car";
		List countListWorker=BaseDao.queryMap(countWorker, null);
		List countListStation=BaseDao.queryMap(countStation, null);
		List countListUsers=BaseDao.queryMap(countUsers, null);
		List countListCar=BaseDao.queryMap(countCar, null);
		List<List> countList=new ArrayList();
		countList.addAll(countListWorker);
		countList.addAll(countListStation);
		countList.addAll(countListUsers);
		countList.addAll(countListCar);
		return countList;
	}

}
