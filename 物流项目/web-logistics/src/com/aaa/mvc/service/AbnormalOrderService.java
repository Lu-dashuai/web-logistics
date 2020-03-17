package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

/***
 *@className:AbnormalOrderService.java
 *@discripton:
 *@author:dujihu
 *@createTime:2018-10-21下午8:11:18
 *@version:1.0
 */

public interface AbnormalOrderService {
	/**
	 * 查询所有订单信息
	 * @return
	 */
	List<Map<String,Object>> getAllOrder(Map map);
	/**
	 * 查询所有异常单
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getAllBadOrder(Map map);
	
	/**
	 * 保存异常单
	 * @return
	 */
	int addBadOrder(Map map);
	/**
	 * 获取分页数据
	 * @param start  开始值
	 * @param rows  每页显示数量
	 * @param map  其他参数
	 * @return
	 */
	List<Map<String,Object>> getPage(Map map);
	/**
	 * 获取分页数据的总数量
	 * 
	 * @param map
	 * @return
	 */
	int getPageCount(Map map);
	/**
	 *更新状态 
	 * @return
	 */
	int updateState(Map map);
}
