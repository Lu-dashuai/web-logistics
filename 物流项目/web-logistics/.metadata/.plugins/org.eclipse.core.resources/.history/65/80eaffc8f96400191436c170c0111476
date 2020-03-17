package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.AutoOrderDao;

@Service
public class AutoOrderServiceImpl implements AutoOrderService{
	@Autowired
	private AutoOrderDao autoOrderDao;
	/**
	 * 获取车辆信息
	 */

	@Override
	public List<Map<String, Object>> getCarMsg(String number,String user) {
		// TODO Auto-generated method stub
		return autoOrderDao.getCarMsg(number,user);
	}
	/**
	 * 获取门店信息
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getStroe(String user) {
		return autoOrderDao.getStroe(user);
	}
	/**
	 * 
	 * 查询装配表里的状态为待装配的订单，连接订单表查询。
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getWaitAuto(String user) {
		// TODO Auto-generated method stub
		return autoOrderDao.getWaitAuto(user);
	}
	 /**
		 * 装配管理页面的提交按钮
		 * @param paramsMap
		 * @param map
		 * @return
		 */
	@Override
	public int getAuto(Map paramsMap, Map map) {
		return autoOrderDao.getAuto(paramsMap, map);
	}
	/**
	 * 获取分页数据
	 * @param map
	 * @return
	 */
	@Override
	public Object getOrderPage(Map map) {
		int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
		int pageSize = map.get("pageSize")==null?10:Integer.valueOf(map.get("pageSize")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return autoOrderDao.getPage(start, pageSize, map);
	}
	/**
	 * 获取分页数据总数量
	 * @param map
	 * @return
	 */
	@Override
	public int getPageCount(Map map) {
		List<Map<String, Object>> pageCount = autoOrderDao.getPageCount(map);
		//判断集合，如果不为空，返回总数量
		if(pageCount!=null&&pageCount.size()>0){
			return Integer.valueOf(pageCount.get(0).get("cnt")+"");
		}
		return 0;
	}
	/**
	 * 装配管理界面的出库按钮
	 * @return 
	 */
	@Override
	public  int orderOutKu(Map paramsMap) {
		//1，订单表的订单状态改为出库5
		//2，车表的状态装配中已改过为运输中
		//3，装配表的状态已出库
		//4，状态详情表的状态改为已出库
		//5，历史记录表不用改
		int row = autoOrderDao.orderNumByCarNumOutKu(paramsMap);
		return row;
	}
	/**
	 * 装配管理页面的删除按钮
	 * @return
	 */
	@Override
	public int delOrderByOrderNum(Map paramsMap) {
		// TODO Auto-generated method stub
		return autoOrderDao.delOrderByOrderNum(paramsMap);
	}
	/**
	 * 通过车牌号获取装配详情表的信息
	 * @param paramMap
	 * @return
	 */
	public List<Map<String,Object>> getInCarOrder(Map paramMap){
		return autoOrderDao.getInCarOrder(paramMap);
	}
	/**
	 * 车辆装配的页面的详情的按钮的详情页面的删除按钮
	 * @param carCode
	 * @param orderCode
	 * @return
	 */
	@Override
	public int updateOrderByCarNum(String carCode, String orderCode) {
		int row = 0;
		//订单在订单表的订单状态改为入库
		autoOrderDao.updateOrderInKu(orderCode);
		//该订单在装配详情表的状态改为待装配
		autoOrderDao.updateAutoWait(orderCode);
		//该订单的装配详情表中的原先插入的字段更新为空值
		autoOrderDao.updateAutoNull(orderCode);
		//删除历史记录的该订单数据
		autoOrderDao.delHistoryByOrderCode(orderCode);
		//将装配表的订单数量减一
		row = autoOrderDao.delOneInOrderCount(carCode);
		//判断(查询)此时货车的订单是否为0，
		List<Map<String, Object>> list = autoOrderDao.selectCarIsOrderNum(carCode);
		String str = list.get(0).get("order_count")+"";
		Integer byOrderCount = Integer.valueOf(str);
		if(byOrderCount==0){
			//如果为0，将货车的状态改为空闲，
			autoOrderDao.ifOrderNotInCar(carCode);
			//删除装配表中的该货车数据
			autoOrderDao.delCarInAutoCar(carCode);
		}
		//如果不为空，不做修改。
		//成功是1,失败是0
		if(row==1){
			return 1;
		}
		return 0;
	}
	/**
	 * 装配管理页面的删除功能
	 * 
	 */
	@Override
	public int delAutoSuccCar(String carNumber,int orderCount) {
		int row = 0;
		//1,如果orderCount==0;
		if(orderCount==0){
			//（1）把装配表的该车的信息删除
			autoOrderDao.delCarInAutoCar(carNumber);
			//（2）在车辆表里将车辆状态改为1，空闲
			row = autoOrderDao.ifOrderNotInCar(carNumber);
		} else {//2,如果orderCount!=0;
			//（1）把装配表的该车的信息删除
			autoOrderDao.delAutoCarCarMsg(carNumber);
			//（2）在车辆表里将车辆状态改为1，空闲
			autoOrderDao.ifOrderNotInCar(carNumber);
			//通过车牌号查订单详情表的订单号
			List<Map<String, Object>> orderCodeList = autoOrderDao.selectOrderNumByCarCode(carNumber);
			for (Map<String, Object> map : orderCodeList) {
				String orderNumber = map.get("order_number")+"";
				//（3）更改订单详情表的订单状态改为待装配，车牌号改为null，下一站地址改为null，预计出发和到达时间改为null
				autoOrderDao.updateAutoWait(orderNumber);
				autoOrderDao.updateAutoNull(orderNumber);
				//（4）订单表的数据改为入库4
				autoOrderDao.updateOrderInKu(orderNumber);
				//（5）历史记录表的该订单数据删除
				row = autoOrderDao.delHistoryByOrderCode(orderNumber);
			}
		}
		if(row == 0|| row == 1){
			return 1;//成功是1
		}
		return 0;//失败是0
	}
	/**
	 * 将session域里的用户获得
	 * 
	 */
	@Override
	public String getUser(String user) {
		return autoOrderDao.getUser(user);
	}
	/**
	 * 车辆调度
	 */
	@Override
	public Object backCarOrder(Map paramMap) {
		// TODO Auto-generated method stub
		int pageNo = paramMap.get("pageNo")==null?1:Integer.valueOf(paramMap.get("pageNo")+"");
		int pageSize = paramMap.get("pageSize")==null?10:Integer.valueOf(paramMap.get("pageSize")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return autoOrderDao.backCarOrder(start, pageSize,paramMap);
	}
	/**
	 * 车辆调度的返程按钮
	 * @param paramsMap
	 * @return
	 */
	@Override
	public int backOrderCar(Map paramsMap) {
		// TODO Auto-generated method stub
		return autoOrderDao.backOrderCar(paramsMap);
	}
}
