package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface EmpDao {
	
	/**
	 * 获取分页数据
	 * @param start  开始值
	 * @param rows  每页显示数量
	 * @param map  其他参数
	 * @return
	 */
	List<Map<String,Object>> getPage(int start,int rows,Map map);
	/**
	 * 获取分页数据的总数量
	 * @param map
	 * @return
	 */
	 List<Map<String, Object>> getPageCount(Map map);
	 
	 /**
	  * 用户添加
	  * @param map
	  * @return
	  */
	 int empAdd(Map map);
	int empDel(String id);
	int empUpdate(Map paramMap);
	 /**
	  * 保存角色权限关联
	  * @param roleId
	  * @param powerId
	  * @return
	  */
	 int addRoleAndPowers(String roleId,String powerId);
	 /**
	  * 根据角色ID删除所有关联权限
	  * @param roleId
	  * @return
	  */
	 int deletePowersByRoleId(String roleId);
	Object getRolePage(int start, int pageSize, Map map);
	List<Map<String, Object>> getRolePageCount(Map map);
	 
}
