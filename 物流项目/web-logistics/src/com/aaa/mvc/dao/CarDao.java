package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface CarDao {
	
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
	 int carAdd(Map map);
	int carDel(String id);
	int carUpdate(Map paramMap);
	List<Map<String, Object>> select();
}
