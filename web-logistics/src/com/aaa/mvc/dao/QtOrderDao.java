package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface QtOrderDao {
	/**
	 * 前台添加
	 * @param map
	 * @return
	 */
	int userAdd(Map map);
	/**
	 * 通过订单号查询用户
	 * @param map
	 * @return
	 */
	 List<Map<String,Object>> selectOrder(Map map);
	 	/**
		 * 通过手机号查询用户
		 * @param map
		 * @return
		 */
	 List<Map<String,Object>> selectPhone(Map map);
	 /**
	  * 下单成功后从后台获取数据	
	  * @param map 
	  * @return
	  */
	 List<Map<String, Object>> selectHistory(Map map);
	 /**
	  * 从前台查询历史订单
	  * @param map
	  * @return
	  *//*
	 List<Map<String, Object>> selectHt(Map map);*/
	List<Map<String, Object>> selectHistoryByNum(Map paramMap);
	List<Map<String, Object>> selectHistoryPhoneNum(Map paramMap);
	 
	 
}
