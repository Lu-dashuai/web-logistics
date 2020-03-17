package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface AutoOrderDao {
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
	 * @param user 
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
	 * 获取分页数据的总数量
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPageCount(Map map);
	/**
	 * 获取分页数据
	 * @param start  开始值
	 * @param rows  每页显示数量
	 * @param map  其他参数
	 * @return
	 */
	Object getPage(int start, int pageSize, Map map);
	/**
	 * 装配管理界面的出库按钮
	 * @param paramsMap
	 */
	int orderNumByCarNumOutKu(Map paramMap);
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
	List<Map<String, Object>> getInCarOrder(Map paramMap);
	/**
	 * //订单在订单表的订单状态改为入库
	 * @param orderCode
	 */
	int updateOrderInKu(String orderCode);
	/**
	 * //该订单在装配详情表的状态改为待装配
	 * @param orderCode
	 * @return
	 */
	int updateAutoWait(String orderCode);
	/**
	 * 装配详情表中的原先插入的字段更新为空值
	 * @param orderCode
	 * @return
	 */
	int updateAutoNull(String orderCode);
	/**
	 * 删除历史记录的该订单数据
	 * @param orderCode
	 */
	int delHistoryByOrderCode(String orderCode);
	/**
	 * 判断(查询)此时货车的订单是否为0，
	 * @param carCode
	 * @return
	 */
	List<Map<String,Object>> selectCarIsOrderNum(String carCode);
	/**
	 * 如果为0，将货车的状态改为空闲，在装配表中更新该车的数据为空，
	 * @param carCode
	 */
	int ifOrderNotInCar(String carCode);
	/**
	 * 将装配表的订单数量减一
	 * @param carCode
	 */
	int delOneInOrderCount(String carCode);
	/**
	 * 删除装配表中该货车数据
	 * @param carCode
	 */
	int delCarInAutoCar(String carCode);
	/**
	 * 通过车牌号查订单详情表的订单号
	 * @param carNumber
	 * @return
	 */
	List<Map<String,Object>> selectOrderNumByCarCode(String carNumber);
	/**
	 * 通过车牌号删除装配表的那条数据
	 * 
	 */
	int delAutoCarCarMsg(String carCode);
	/**
	 * 将session域里的用户获得
	 * 
	 */
	String getUser(Object user);
	/**
	 * 车辆调度页面的查询
	 * @param paramMap
	 * @return
	 */
	Object backCarOrder(int start, int rows,Map paramMap);
	/**
	 * 车辆调度的返程按钮
	 * @param paramsMap
	 * @return
	 */
	int backOrderCar(Map paramsMap);


}
