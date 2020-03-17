package com.lightning.dao.impl.wangjia;

import java.util.List;

import com.lightning.bean.wangjia.Power;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangjia.PowerDao;

public class PowerDaoImpl implements PowerDao{
	//增加权限类型
	@Override
	public void insertPower(Power power) {
		String sql="insert into power(power_id,power_type,power_parent) values(?,?,?)";
		BaseDao.update(sql, new Object[]{power.getPower_id(),power.getPower_type(),power.getPower_parent()});
	}
	//删除权限类型
	@Override
	public int deletePower(Power power) {
		String delpower="select power_parent from power where power_id != ?";//"select power_id from power where power_parent =?";
		List<List> powerList=BaseDao.query(delpower, new Object[] {power.getPower_id()});
		int count =0;
		for(List colpower : powerList) {
			for(Object obj : colpower) {
				if(obj.equals(power.getPower_id())) {
					count++;
				}
			}
		}
		if(count==0) {
			
			String sql="delete from power where power_id= ?";
			BaseDao.update(sql, new Object[] {power.getPower_id()});	
		}
		return count;
	}
	//修改权限类型
	@Override
	public void updatePower(Power power) {
		String sql="update power set power_id=?,power_type=?,power_parent=? where power_id=?";
		BaseDao.update(sql, new Object[] {power.getPower_id(),power.getPower_type(),power.getPower_parent(),power.getPower_id()});
	}
	//修改用   查询一条
	@Override
	public List findOnePower(Power power) {
		String sql="select * from power where power_id";
		return BaseDao.query(sql, new Object[] {power.getPower_id()});
	}
	//查询全部
	@Override
	public List findPower() {
		String sql="select * from power";
		return BaseDao.queryMap(sql, null);
	}
	//查询的当前登录这的权限
	@Override
	public List findWorkerPower(int workerid) {
		String sql="select po.* from worker wo left join role ro on ro.role_worker=wo.worker_id "
				+ "left join post ps on ps.post_id=ro.role_post left join allow al on al.allow_post=ps.post_id "
				+ "left join power po on po.power_id=al.allow_power where wo.worker_id=?";
		return BaseDao.queryMap(sql,new Object[] {workerid});
	}
}
