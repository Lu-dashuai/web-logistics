package com.aaa.mvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;
@SuppressWarnings("unused")
@Repository
public class OrderDaoImpl implements OrderDao {
	/**
	 * 获取分页后的列表
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String, Object>> getPage(int start, int rows, Map map) {
		// TODO Auto-generated method stub
		//排序参数
		String str = "";
		if(map.get("sort")!=null){
			str = " order by "+map.get("sort")+" "+map.get("order");
		}
		//打印执行语句
		return BaseDao.selectMap("select * from tb_order"+setParams(map)+str+" limit "+start+","+rows, null);
	}

	/**
	 * 封装参数
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String setParams(Map map){
		     //查询参数
				String str1 = " where 1=1 ";
				//获取该用户
				Object user = map.get("user");
				//查询该用户的地址
				List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
				String store = adminOne.get(0).get("store")+"";
				
				Object overStore1 = map.get("overStore1");
				Object overStore0 = map.get("overStore0");
				Object overStore = map.get("overStore");
				Object accepter_phone = map.get("accepter_phone");
				Object order_mailnum = map.get("order_mailnum");
				Object status1 = map.get("status1");
				Object status2 = map.get("status2");
				Object status3 = map.get("status3");
				Object status4 = map.get("status4");
				Object status5 = map.get("status5");
				Object status6 = map.get("status6");
				Object status7 = map.get("status7");
				Object status8 = map.get("status8");
				Object status9 = map.get("status9");
				Object status10 = map.get("status10");
				Object status11 = map.get("status11");
				Object status66 = map.get("status66");
				
				if(overStore1!=null&&!"".equals(overStore1)){
					str1 += " and over_store is null";
				}
				if(overStore0!=null&&!"".equals(overStore0)){
					str1 += " and over_store <>'"+store+"'";
				}
				if(overStore!=null&&!"".equals(overStore)){
					str1 += " and over_store = '"+store+"'";
				}
				if(store!=null&&!"".equals(store)){
					str1 += " and order_now_store = '"+store+"'";
				}
				//拼接accepter_phone
				if(accepter_phone!=null&&!"".equals(accepter_phone)){
					str1 += " and accepter_phone ="+accepter_phone;
				}
				//拼接order_mailnum
				if(order_mailnum!=null&&!"".equals(order_mailnum)){
					str1 += " and order_mailnum ="+order_mailnum;
				}
				if(status1!=null&&!"".equals(status1)){
					str1 += " and goods_status ="+status1;
				}
				if(status2!=null&&!"".equals(status2)){
					str1 += " and goods_status ="+status2;
				}
				if(status3!=null&&!"".equals(status3)){
					str1 += " and goods_status ="+status3;
				}
				if(status4!=null&&!"".equals(status4)){
					str1 += " and goods_status ="+status4;
				}
				if(status5!=null&&!"".equals(status5)){
					str1 += " and goods_status ="+status5;
				}
				if(status6!=null&&!"".equals(status6)){
					str1 += " and goods_status ="+status6;
				}
				if(status7!=null&&!"".equals(status7)){
					str1 += " and goods_status ="+status7;
				}
				if(status8!=null&&!"".equals(status8)){
					str1 += " and goods_status ="+status8;
				}
				if(status9!=null&&!"".equals(status9)){
					str1 += " and goods_status ="+status9;
				}
				if(status10!=null&&!"".equals(status10)){
					str1 += " and goods_status ="+status10;
				}
				if(status11!=null&&!"".equals(status11)){
					str1 += " and goods_status ="+status11;
				}
				if(status66!=null&&!"".equals(status66)){
					str1 += " and goods_status ="+status66;
				}
				//拼接状态
				return str1;
	}
	
	/**
	 * 获取分页数据的总数量
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public  List<Map<String, Object>> getPageCount(Map map) {
		
		return  BaseDao.selectMap("select count(*) as cnt from tb_order "+setParams(map), null);
	}
	/**
	  * 订单添加
	  * @param map
	  * @return
	  */
	@SuppressWarnings("rawtypes")
	@Override
	public int userAdd(Map map) {
		// TODO Auto-generated method stub
		//调用设置日期方法
		String ss = map.get("order_time")+"";
		Date date = setDate(ss);
		return BaseDao.insertAndUpdateAndDelete("insert into tb_order (order_now_store,order_mailnum,order_time, sender_name, sender_phone, sender_adr, accepter_name, accepter_phone, accepter_adr, accepter_zipcode, goods_name, goods_type, goods_weight, goods_remarks, goods_status,goods_value,goods_supportvalue,goods_ifsupportvalue, goods_cost, cost_type,over_store) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{map.get("order_now_store"),map.get("order_mailnum"),date,map.get("sender_name"),map.get("sender_phone"),map.get("sender_adr"),map.get("accepter_name"),map.get("accepter_phone"),map.get("accepter_adr"),map.get("accepter_zipcode"),map.get("goods_name"),map.get("goods_type"),map.get("goods_weight"),map.get("goods_remarks"),map.get("goods_status"),map.get("goods_value"),map.get("goods_supportvalue"),map.get("goods_ifsupportvalue"),map.get("goods_cost"),map.get("cost_type"),map.get("over_store")});
	}
	/**
	 * 订单更改
	 */
	@Override
	public int updateOrder(int id,Map map) {
		// TODO Auto-generated method stub
		//调用设置日期方法
		String ss = map.get("order_time")+"";
		Date date = setDate(ss);
		return BaseDao.insertAndUpdateAndDelete("update tb_order set order_now_store=?,order_mailnum=?,order_time=?,sender_name=?,sender_phone=?,sender_adr=?,accepter_name=?,accepter_phone=?,accepter_adr=?,accepter_zipcode=?,goods_name=?,goods_type=?,goods_weight=?,goods_remarks=?,goods_status=?,goods_value=?,goods_supportvalue=?,goods_ifsupportvalue=?,goods_cost=?,cost_type=?,over_store=? where id=?",
				new Object[]{map.get("order_now_store"),map.get("order_mailnum"),date,map.get("sender_name"),map.get("sender_phone"),map.get("sender_adr"),map.get("accepter_name"),map.get("accepter_phone"),map.get("accepter_adr"),map.get("accepter_zipcode"),map.get("goods_name"),map.get("goods_type"),map.get("goods_weight"),map.get("goods_remarks"),map.get("goods_status"),map.get("goods_value"),map.get("goods_supportvalue"),map.get("goods_ifsupportvalue"),map.get("goods_cost"),map.get("cost_type"),map.get("over_store"),id});
	}
	/**
	 * 订单删除
	 */
	@Override
	public int deleteOrder(int id) {
		return BaseDao.insertAndUpdateAndDelete("delete from tb_order where id = ?", new Object[]{id});
	}
	/**
	 * 按照快递单号去删除订单
	 * @param mailNumber
	 * @return
	 */
	public int deleteOrderByMailNumber(Object mailNumber){
		if(!"".equals(mailNumber)){
			return BaseDao.insertAndUpdateAndDelete("delete from tb_order where mailNumber = ?", new Object[]{mailNumber});
		}
		return 0;
	}
	/**
	 * 设置时间日期格式
	 * @param time
	 */
	private Date setDate(String ss){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(ss);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	  * 审核订单页面的通过按钮
	  * @param id
	  * @return
	  */
	@Override
	public int passOrder(int id) {
		return BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=? where id=?", new Object[]{2,id});
	}
	/**
	 * 退单
	 *//*
	@Override
	public int backOrder(int id) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=? where id=?", new Object[]{2,id});
	}*/
	/**
	 * 入库管理的入库按钮
	 */
	@Override
	public int inkuOrder(int id,Object user) {
		int row=0;
		//先改订单的状态为入库
		BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=? where id=?", new Object[]{3,id});
		//把订单表的‘单号’，‘现地址’--插入--装配表的‘订单号’，‘现在地’中
		List<Map<String, Object>> list = BaseDao.selectMap("select order_mailnum,order_now_store from tb_order where id=?", new Object[]{id});
		BaseDao.insertAndUpdateAndDelete("insert into tb_auto (order_number,now_store) values (?,?)", new Object[]{list.get(0).get("order_mailnum"),list.get(0).get("order_now_store")});
		//把装配表中的该单的状态设置为待装配
		row = BaseDao.insertAndUpdateAndDelete("update tb_auto set auto_status='待装配' where order_number=?", new Object[]{list.get(0).get("order_mailnum")});
		//从历史表中拿出该订单号是否为空用作判断是否为始发站，空说明是始发站
		List<Map<String, Object>> historyList = BaseDao.selectMap("select * from tb_history where history_order_number = ?", new Object[]{list.get(0).get("order_mailnum")});
		//String orderNumber = historyList.get(0).get("history_order_number")+"";
		//如果不是始发站
		if(historyList.size()!=0){
			String orderNum = list.get(0).get("order_mailnum")+"";
			//通过用户查询用户表所在门店
			List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
			//账号门店
			String store = adminOne.get(0).get("store")+"";
			//通过订单号查车牌
			List<Map<String, Object>> carList = BaseDao.selectMap("select car_number from tb_auto where order_number=? and next_store=?", new Object[]{orderNum,store});
			//车牌号
			String carCode = carList.get(0).get("car_number")+"";
			//更改车辆表该车的现在地址
			BaseDao.insertAndUpdateAndDelete("update tb_car set address=? where number=?", new Object[]{store,carCode});
			//调用订单减一的方法
			AutoOrderDao autoOrderDao = new AutoOrderDaoImpl();
			//先减一
			autoOrderDao.delOneInOrderCount(carCode);
			//获取该车上的订单号
			List<Map<String, Object>> list1 = autoOrderDao.selectCarIsOrderNum(carCode);
			String str = list1.get(0).get("order_count")+"";
			Integer byOrderCount = Integer.valueOf(str);
			if(byOrderCount==0){
				//如果为0，将货车的状态改为空闲，
				autoOrderDao.ifOrderNotInCar(carCode);
				//删除装配表中的该货车数据
				autoOrderDao.delCarInAutoCar(carCode);
			}
		}
		//如果不为空，不做修改。
		//成功是1,失败是0
		if(row!=0){
			return 1;
		}
		return 0;
	}
	/**
	 * 邮寄单号验证
	 */
	@Override
	public int checkMailnum(Map map) {
		List<Map<String,Object>> selectMap = BaseDao.selectMap("select * from tb_order", null);
		for (int i = 0; i < selectMap.size(); i++) {
			String str1 = map.get("ol")+"";
			if((selectMap.get(i).get("order_mailnum")+"").equals(str1)){
				return 1;//false
			}
		}
		return 0;//true
	}
	/**
	  * 订单管理页面的添加菜单查询地址
	  * @return
	  */
	@Override
	public List<Map<String, Object>> getAdr() {
		
		return BaseDao.selectMap("select * from tb_adr", null);
	}
	/**
	 * 退单，审核未通过
	 */
	@Override
	public int backOrder(int id) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=? where id = ?", new Object[]{66,id});
	}
	/**
	 * 通过用户登陆查询门店信息
	 */
	@Override
	public List<Map<String, Object>> getUserState(Object user) {
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		String store = adminOne.get(0).get("store")+"";
		return BaseDao.selectMap("select * from tb_admin where store=?", new Object[]{store});
	}
	
	
	
	
	
	/**
	 * 订单入库页面的到达目的地方法
	 */
	@Override
	public int overStoreOrder(int id,Object user) {
		int row=0;
		//先改订单的状态为目的地站
		BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=? where id=?", new Object[]{6,id});
		//把订单表的‘单号’，‘现地址’--插入--装配表的‘订单号’，‘现在地’中
		List<Map<String, Object>> list = BaseDao.selectMap("select order_mailnum,order_now_store from tb_order where id=?", new Object[]{id});
		BaseDao.insertAndUpdateAndDelete("insert into tb_auto (order_number,now_store) values (?,?)", new Object[]{list.get(0).get("order_mailnum"),list.get(0).get("order_now_store")});
		//把装配表中的该单的状态设置为目的地站
		row = BaseDao.insertAndUpdateAndDelete("update tb_auto set auto_status='目的地站' where order_number=?", new Object[]{list.get(0).get("order_mailnum")});
		//从历史表中拿出该订单号是否为空用作判断是否为始发站，空说明是始发站
		List<Map<String, Object>> historyList = BaseDao.selectMap("select * from tb_history where history_order_number = ?", new Object[]{list.get(0).get("order_mailnum")});
		//String orderNumber = historyList.get(0).get("history_order_number")+"";
		//如果不是始发站
		if(historyList.size()!=0){
			String orderNum = list.get(0).get("order_mailnum")+"";
			//通过用户查询用户表所在门店
			List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
			//账号门店
			String store = adminOne.get(0).get("store")+"";
			//通过订单号查车牌
			List<Map<String, Object>> carList = BaseDao.selectMap("select car_number from tb_auto where order_number=? and next_store=?", new Object[]{orderNum,store});
			//车牌号
			String carCode = carList.get(0).get("car_number")+"";
			//更改车辆表该车的现在地址
			BaseDao.insertAndUpdateAndDelete("update tb_car set address=? where number=?", new Object[]{store,carCode});
			//调用订单减一的方法
			AutoOrderDao autoOrderDao = new AutoOrderDaoImpl();
			//先减一
			autoOrderDao.delOneInOrderCount(carCode);
			//获取该车上的订单号
			List<Map<String, Object>> list1 = autoOrderDao.selectCarIsOrderNum(carCode);
			String str = list1.get(0).get("order_count")+"";
			Integer byOrderCount = Integer.valueOf(str);
			if(byOrderCount==0){
				//如果为0，将货车的状态改为空闲，
				autoOrderDao.ifOrderNotInCar(carCode);
				//删除装配表中的该货车数据
				autoOrderDao.delCarInAutoCar(carCode);
			}
	}
		//如果不为空，不做修改。
				//成功是1,失败是0
				if(row!=0){
					return 1;
				}
				return 0;
	}

	/**
	 * 获取门店信息
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getStore() {
		return BaseDao.selectMap("select * from tb_store", null);
	}
	
}
