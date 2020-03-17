package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Override
	public List<Map<String, Object>> adminLogin() {
		return BaseDao.selectMap("select username,password from tb_admin", null);
	}
}



