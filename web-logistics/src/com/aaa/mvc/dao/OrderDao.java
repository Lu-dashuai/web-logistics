package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

public interface OrderDao {
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
	  * 审核订单页面的通过按钮
	  * @param id
	  * @return
	  */
	 int passOrder(int id);
	 /**
	  * 审核订单页面的退单按钮
	  * @param id
	  * @return
	  */
	 int backOrder(int id);
	 /**
	  * 我的订单页面的入库按钮
	  * @param id
	 * @param user 
	  * @return
	  */
	 int inkuOrder(int id, Object user);
	 /**
	  * 删除订单按照快递单号
	  * @param mailNumber
	  * @return
	  */
	 public int deleteOrderByMailNumber(Object mailNumber);
	 /**
	  * 邮寄单号验证
	  * @param map
	  * @return
	  */
	 public int checkMailnum(Map map);
	 /**
	  * 订单管理页面的添加菜单查询地址
	  * @return
	  */
	 public List<Map<String, Object>> getAdr();
	 /**
	  * 通过用户登陆查询门店
	  * @param user
	  * @return
	  */
	List<Map<String, Object>> getUserState(Object user);
	/**
	 * 订单入库页面的到达目的地方法
	 * @param user 
	 */
	int overStoreOrder(int id, Object user);
	/**
	 * 获取门店信息
	 * @return
	 */
	List<Map<String, Object>> getStore();
	
}
