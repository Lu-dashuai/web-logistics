package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface SelectUserDao {
	/**
	 * 查询添加用户列表
	 * @return
	 */
	List<Map<String,Object>> selectUser();
	/**
	 * 用户添加
	 * @return
	 */
	int userAdd(Map map);
	/**
	 * 用户删除
	 * @param id
	 * @return
	 */
	int userDel(int id);
	/**
	 * 用户更新
	 * @param paramMap
	 * @return
	 */
	int userUpdate(Map paramMap);
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
}
