package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

public interface GetArrdessService {
	/**
	 * 获取省
	 * @return
	 */
	List<Map<String, Object>> getProvince();
	List<Map<String, Object>> getProvince1();
	/**
	 * 获取市
	 * @return
	 */
	List<Map<String, Object>> getCity(String provinceId);
	List<Map<String, Object>> getCity1(String provinceId);
	/**
	 * 获取区
	 * @param cityId
	 * @return
	 */
	List<Map<String, Object>> getArea(String cityId);
	List<Map<String, Object>> getArea1(String cityId);

}
