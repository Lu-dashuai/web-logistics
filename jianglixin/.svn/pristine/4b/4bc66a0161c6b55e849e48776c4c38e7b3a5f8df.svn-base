package com.lightning.dao.impl.wangjia;

import java.util.List;

import com.lightning.bean.wangjia.Allow;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangjia.AllowDao;

public class AllowDaoImpl implements AllowDao{

	@Override
	public void insertAllow(Allow allow) {
		String sql="insert into allow(allow_power,allow_post) values(?,?)";
		BaseDao.update(sql, new Object[]{allow.getAllow_power(),allow.getAllow_post()});
	}

	@Override
	public int deleteAllow(Allow allow) {
		
			String sql="delete from allow where allow_post=?";			
			
			return BaseDao.update(sql, new Object[] {allow.getAllow_post()});
	}
	
	public int deleteAllowPower(Allow allow) {
			String sql = "delete from allow where allow_power=?";
			return BaseDao.update(sql, new Object[] {allow.getAllow_power()});
	}
	

	@Override
	public void updateAllow(Allow allow) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List findOneAllow(Allow allow) {
		String sql = "select * from allow where allow_post=?";
		return BaseDao.queryMap(sql, new Object[] {allow.getAllow_post()});
	}

	@Override
	public List findAllow() {
		String sql="select allow_power,allow_post from allow";
		
		return BaseDao.queryMap(sql, null);
	}

	
}
