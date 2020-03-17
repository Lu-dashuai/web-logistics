package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.QtOrderDao;
@Service
public class QtOrderServiceImpl implements QtOrderService {
	@Autowired
	private QtOrderDao qtOrderDao;
	
	@Override
	public int userAdd(Map map) {
		// TODO Auto-generated method stub
		return qtOrderDao.userAdd(map);
	}

	@Override
	public List<Map<String, Object>> selectOrder(Map map) {
		// TODO Auto-generated method stub
		return qtOrderDao.selectOrder(map);
	}

	@Override
	public List<Map<String, Object>> selectPhone(Map map) {
		// TODO Auto-generated method stub
		return qtOrderDao.selectPhone(map);
	}

	@Override
	public List<Map<String, Object>> selectHistory(Map map) {
		// TODO Auto-generated method stub
		return qtOrderDao.selectHistory(map);
	}

	@Override
	public List<Map<String, Object>> selectHistoryByNum(Map paramMap) {
		// TODO Auto-generated method stub
		return qtOrderDao.selectHistoryByNum(paramMap);
	}

	@Override
	public List<Map<String, Object>> selectHistoryPhoneNum(Map paramMap) {
		// TODO Auto-generated method stub
		return qtOrderDao.selectHistoryPhoneNum(paramMap);
	}

}
