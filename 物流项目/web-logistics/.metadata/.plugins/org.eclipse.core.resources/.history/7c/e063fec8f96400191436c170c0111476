package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

public interface AutoOrderService {
	/**
	 * 获取车辆信息
	 * @return
	 */
	List<Map<String,Object>> getCarMsg(String number,String user);
	/**
	 * 获取门店信息
	 * @param user 
	 * @return
	 */
	List<Map<String,Object>> getStroe(String user);
	/**
	 * 
	 * 查询装配表里的状态为待装配的订单，连接订单表查询。
	 * @return
	 */
	List<Map<String,Object>> getWaitAuto(String user);
	 /**
	 * 装配管理页面的提交按钮
	 * @param paramsMap
	 * @param map
	 * @return
	 */
	int getAuto(Map paramsMap,Map map);
	/**
	 * 获取分页数据
	 * @param map
	 * @return
	 */
	Object getOrderPage(Map paramMap);
	/**
	 * 获取分页数据总数量
	 * @param map
	 * @return
	 */
	int getPageCount(Map paramMap);
	/**
	 * 装配管理界面的出库按钮
	 * @param paramsMap
	 */
	int orderOutKu(Map paramsMap);
	/**
	 * 装配管理页面的删除按钮
	 * @return
	 */
	int delOrderByOrderNum(Map paramsMap);
	/**
	 * 通过车牌号获取装配详情表的信息
	 * @param paramMap
	 * @return
	 */
	List<Map<String,Object>> getInCarOrder(Map paramMap);
	/**
	 * 车辆装配的页面的详情的按钮的详情页面的删除按钮
	 * @param carCode
	 * @param orderCode
	 * @return
	 */
	int updateOrderByCarNum(String carCode, String orderCode);
	/**
	 * 装配管理页面的删除功能
	 * 
	 */
	int delAutoSuccCar(String carNumber,int orderCount);
	/**
	 * 将session域里的用户获得
	 * 
	 */
	String getUser(String user);
	/**
	 * 车辆调度
	 * @param paramMap
	 * @return
	 */
	Object backCarOrder(Map paramMap);
	/**
	 * 车辆调度的返程按钮
	 * @param paramsMap
	 * @return
	 */
	int backOrderCar(Map paramsMap);
}
