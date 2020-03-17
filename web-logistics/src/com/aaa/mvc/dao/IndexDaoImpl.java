package com.aaa.mvc.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

@Repository
public class IndexDaoImpl implements IndexDao {
	/**
	 * 获取用户信息
	 */
	@Override
	public List<Map<String, Object>> getEmpMsg(Object user) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
	}

}
