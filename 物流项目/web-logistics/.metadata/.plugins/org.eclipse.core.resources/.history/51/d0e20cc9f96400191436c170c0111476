package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.GetArrdessDao;

@Service
public class GetArrdessServiceImpl implements GetArrdessService{
	@Autowired
	private GetArrdessDao getArrdessDao;
	/**
	 * 获取省
	 */
	@Override
	public List<Map<String, Object>> getProvince() {
		// TODO Auto-generated method stub
		return getArrdessDao.getProvince();
	}
	/**
	 * 获取市
	 */
	@Override
	public List<Map<String, Object>> getCity(String provinceId) {
		// TODO Auto-generated method stub
		return getArrdessDao.getCity(provinceId);
	}
	/**
	 * 获取区
	 */
	@Override
	public List<Map<String, Object>> getArea(String cityId) {
		// TODO Auto-generated method stub
		return getArrdessDao.getArea(cityId);
	}
	@Override
	public List<Map<String, Object>> getProvince1() {
		// TODO Auto-generated method stub
		return getArrdessDao.getProvince1();
	}
	@Override
	public List<Map<String, Object>> getCity1(String provinceId) {
		// TODO Auto-generated method stub
		return getArrdessDao.getCity1(provinceId);
	}
	@Override
	public List<Map<String, Object>> getArea1(String cityId) {
		// TODO Auto-generated method stub
		return getArrdessDao.getArea1(cityId);
	}
}
