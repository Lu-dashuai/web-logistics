package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.IndexDao;

@Service
public class IndexServiceImpl implements IndexService{
	@Autowired
	private IndexDao indexDao;
	/**
	 * 获取用户信息
	 */
	@Override
	public List<Map<String, Object>> getEmpMsg(Object user) {
		// TODO Auto-generated method stub
		return indexDao.getEmpMsg(user);
	}

}
