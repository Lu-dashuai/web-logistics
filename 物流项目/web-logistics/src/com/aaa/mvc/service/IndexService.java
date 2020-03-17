package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

public interface IndexService {
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 */
	List<Map<String ,Object>> getEmpMsg(Object user);
}
