package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface OrdersDao {
	/** 获取分页数据
	 * @param statrt  开始值
	 * @param rows	 每页显示数量
	 * @param map		其他参数
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
	 * 统计所有门店订单
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getOrderECharts(String province,String city);
}
