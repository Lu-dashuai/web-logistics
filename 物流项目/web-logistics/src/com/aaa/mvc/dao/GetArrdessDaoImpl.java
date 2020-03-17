package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

@Repository
public class GetArrdessDaoImpl implements GetArrdessDao {
	/**
	 * 获取省
	 */
	@Override
	public List<Map<String, Object>> getProvince() {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select * from tb_province", null);
	}
	/**
	 * 获取市
	 */
	@Override
	public List<Map<String, Object>> getCity(String provinceId) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select * from tb_city where provincecode=?", new Object[]{provinceId});
	}
	/**
	 * 获取区
	 */
	@Override
	public List<Map<String, Object>> getArea(String cityId) {
		return BaseDao.selectMap("select * from tb_area where citycode=?", new Object[]{cityId});
	}		
	@Override
	public List<Map<String, Object>> getProvince1() {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select id,code,name from tb_province1", null);

	}
	@Override
	public List<Map<String, Object>> getCity1(String provinceId) {
		// TODO Auto-generated method stub
		Object[] params = {provinceId};
		return BaseDao.selectMap("select id,code,name,provincecode from tb_city1 where provincecode = ?", params);
	}
	@Override
	public List<Map<String, Object>> getArea1(String cityId) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select id,code,name,citycode from tb_area1 where citycode= ? ", new Object[]{cityId} );
	}

}
