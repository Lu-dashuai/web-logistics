package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

public interface StoreService {
	/**
	 * 获取分页数据
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getPage(Map map);
	
	/**
	 * 获取分页数据总数量
	 * @param map
	 * @return
	 */
	int getPageCount(Map map);
	/**
	  * 用户添加
	  * @param map
	  * @return
	  */
	 int storeAdd(Map map);
	 /**
	  * 订单更新
	  * @param id
	  * @return
	  */
	 int updateStore(int id,Map map);
	 /**
	  * 订单删除
	  * @param id
	  * @return
	  */
	 int deleteStore(int id);
	 /**
	 * 省，市，县插入数据库
	*/
	void insert(Map map);
}
