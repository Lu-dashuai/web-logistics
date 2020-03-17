package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;


public interface IndexDao {
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 */
	List<Map<String, Object>> getEmpMsg(Object user);

}
