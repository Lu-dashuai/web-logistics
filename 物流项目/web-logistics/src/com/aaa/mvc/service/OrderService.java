package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
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
	  * 审核订单页面的通过按钮
	  * @param idsStr
	  * @return
	  */
	 int passOrder(String idsStr);
	 /**
	  * 审核订单页面的退单按钮
	  * @param idsStr
	  * @return
	  */
	 int backOrder(String idsStr);
	 /**
	  * 我的订单页面的入库按钮
	  * @param idsStr
	 * @param user 
	  * @return
	  */
	int inkuOrder(String idsStr, Object user);
	/**
	  * 验证邮寄单
	  * @param map
	  * @return
	  */
	 int checkMailnum(Map map);
	 /**
	  * 订单管理页面的添加菜单查询地址
	  * @return
	  */
	 List<Map<String,Object>> getAdr();
	 /**
		 * 添加订单查询用户门店
		 */
	List<Map<String, Object>> getUserState(Object user);
	/**
	 * 到达目的地站方法
	 * @param idsStr
	 * @param user
	 * @return
	 */
	int overStoreOrder(String idsStr, Object user);
	/**
	 * 获取门店信息
	 * @return
	 */
	List<Map<String, Object>> getStore();
	
	
}
