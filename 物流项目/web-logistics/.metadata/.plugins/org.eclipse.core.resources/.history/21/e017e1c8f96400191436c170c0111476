package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;
import com.aaa.mvc.util.RandomCount;
@Repository
public class QtOrderDaoImpl implements QtOrderDao {

	/**
	  * 订单添加
	  * @param map
	  * @return
	  */
	@Override
	public int userAdd(Map map) {
		// TODO Auto-generated method stub
		String weight1 = map.get("goods_weight")+"";
		String orderNum = RandomCount.getOrderIdByTime();
		if(!"".equals(weight1)&&!"null".equals(weight1)&&weight1!=null){
			double weight = Integer.parseInt(weight1)*0.3;
			return BaseDao.insertAndUpdateAndDelete("insert into tb_order (order_time,order_mailnum,sender_name,sender_phone,sender_adr,accepter_name,accepter_phone, accepter_adr,accepter_zipcode, goods_name,goods_type,goods_weight,goods_remarks,goods_status,goods_value,goods_supportvalue,goods_ifsupportvalue,goods_cost,cost_type,order_now_store) values(NOW(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new Object[]{orderNum,map.get("sender_name"),map.get("sender_phone"),map.get("sender_adr"),map.get("accepter_name"),map.get("accepter_phone"),map.get("accepter_adr"),map.get("accepter_zipcode"),map.get("goods_name"),map.get("goods_type"),map.get("goods_weight"),map.get("goods_remarks"),20,map.get("goods_value"),map.get("goods_supportvalue"),1,weight,map.get("cost_type"),map.get("order_now_store")});
		}
		return 0;
	}
	/**
	 * 按订单号查询
	 */
	@Override
	public   List<Map<String, Object>> selectOrder(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select order_mailnum,goods_name,sender_name,sender_phone,sender_adr,accepter_name,accepter_phone,accepter_adr,goods_status from tb_order where order_mailnum=?",
				new Object[]{map.get("order_mailnum")});
	}
	/**
	 * 按手机号查询
	 */
	@Override
	public List<Map<String, Object>> selectPhone(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select order_mailnum,goods_name,sender_name,sender_phone,sender_adr,accepter_name,accepter_phone,accepter_adr,goods_status from tb_order where sender_phone=?",
				new Object[]{map.get("sender_phone")});
	}
	
	/**
	 * 下单成功后从后台获取数据
	 */
	@Override
	public List<Map<String, Object>> selectHistory(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select * from tb_order where sender_phone=?",new Object[]{map.get("sender_phone")});
	}

	/**
	 * 通过订单号对历史表查询
	 */
	@Override
	public List<Map<String, Object>> selectHistoryByNum(Map paramMap) {
		// TODO Auto-generated method stub
		String orderNum = paramMap.get("orderNumber")+"";
		return BaseDao.selectMap("select history_order_number,history_car_number,history_store,history_time from tb_history where history_order_number=?", new Object[]{orderNum});
	}
	/**
	 * 通过手机号对历史表查询
	 */
	@Override
	public List<Map<String, Object>> selectHistoryPhoneNum(Map paramMap) {
		// TODO Auto-generated method stub
		String phoneNum = paramMap.get("phoneNumber")+"";
		return BaseDao.selectMap("select h.history_order_number,h.history_car_number,h.history_store,h.history_time from tb_order o join tb_history h on h.history_order_number = o.order_mailnum where o.sender_phone =?", new Object[]{phoneNum});
	}
}
