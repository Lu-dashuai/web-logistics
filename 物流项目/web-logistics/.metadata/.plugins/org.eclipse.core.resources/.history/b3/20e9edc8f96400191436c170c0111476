package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface WrongOrderDao {
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
	  * 订单添加
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
	  * 根据订单id获得订单信息
	  * @param paramMap
	  * @return
	  */
	List<Map<String, Object>> getOrderPage(Map paramMap);
}
