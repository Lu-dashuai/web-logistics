package com.aaa.mvc.service;

import java.util.Map;

public interface EmpService {

	int getPageCount(Map paramMap);

	Object getPage(Map paramMap);

	int empAdd(Map paramMap);

	int empDel(String id);

	int empUpdate(Map paramMap);


	/**
	 * 批量保存角色和权限
	 * @param map
	 * @return
	 */
	int saveRoleAndPower(Map map);

	Object getRolePage(Map paramMap);

	int getRolePageCount(Map paramMap);

	

}
