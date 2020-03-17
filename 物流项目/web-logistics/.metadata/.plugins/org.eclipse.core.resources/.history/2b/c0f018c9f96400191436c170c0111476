package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;



public interface QtOrderService {
	 /**
	  * 用户添加
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
		List<Map<String, Object>> selectHistoryByNum(Map paramMap);
		List<Map<String, Object>> selectHistoryPhoneNum(Map paramMap);
}
