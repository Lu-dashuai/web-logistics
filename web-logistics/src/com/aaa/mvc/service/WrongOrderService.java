package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

public interface WrongOrderService {
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
	 int userAdd(Map map);
	 /**
	  * 订单更新
	  * @param id
	  * @return
	  */
	 int updateOrder(int id,Map map);
	 /**
	  * 订单删除
	  * @param id
	  * @return
	  */
	 int deleteOrder(int id);
	 /**
	  * 根据订单号获得订单
	  * @param paramMap
	  * @return
	  */
	List<Map<String, Object>> getOrderPage(Map paramMap);
}
