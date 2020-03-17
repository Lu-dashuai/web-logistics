package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface StoreDao {

	List<Map<String, Object>> getPage(int start, int pageSize, Map map);

	List<Map<String, Object>> getPageCount(Map map);
	 /**
	  * 订单添加
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
