	package com.aaa.mvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;
import com.sun.org.apache.regexp.internal.recompile;

@Repository
public class AutoOrderDaoImpl implements AutoOrderDao{
	/**
	 * 查询车辆信息
	 */
	@Override
	public List<Map<String, Object>> getCarMsg(String number,String user) {
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		String store = adminOne.get(0).get("store")+"";
		//通过车牌号查车辆表的所属门店是否和登陆账号的所在门店相等
		/*List<Map<String, Object>> list = BaseDao.selectMap("select * from tb_store where store_name=?",new Object[]{store});
		String carStoreId = list.get(0).get("id")+"";*/
		
		// TODO Auto-generated method stub
		String str = "";
		if(number!=null) {
			str+=" and number = '"+number+"'";
		}
		//返回的是现地址在我这并且状态为空闲的车，参考orderDaoImpl的inkuOrder的更改车辆表该车的现在地址  方法
		return BaseDao.selectMap("select * from tb_car where 1=1 "+str+" and state=1 and address=?", new Object[]{store});
	}
	/**
	 * 获取门店信息
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getStroe(String user) {
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		String store = adminOne.get(0).get("store")+"";
		List<Map<String, Object>> admin = BaseDao.selectMap("select * from tb_store where store_name=?", new Object[]{store});
		String ids=admin.get(0).get("id")+"";
		String pids = admin.get(0).get("store_parentid")+"";
		int id = Integer.parseInt(ids);
		int pid=Integer.parseInt(pids);
		if(pid==0){
			return BaseDao.selectMap("select store_name from tb_store where store_parentid=0 or store_parentid=?", new Object[]{id});
		}else{
			return BaseDao.selectMap("select store_name from tb_store where id=? or store_parentid=?", new Object[]{pid,id});
		}
	}
	/**
	 * 
	 * 查询装配表里的状态为待装配的订单，连接订单表查询。
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getWaitAuto(String user) {
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		String store = adminOne.get(0).get("store")+"";
		return BaseDao.selectMap("select a.auto_status,o.order_mailnum,o.accepter_name,o.accepter_adr,o.order_time,o.goods_type,o.goods_weight,o.order_now_store,o.goods_remarks from tb_order o left join tb_auto a on o.order_mailnum = a.order_number where a.auto_status='待装配' and a.now_store=? and a.next_store is null", new Object[]{store});
	}
	/**
	 * 装配管理页面的提交按钮
	 * @param paramsMap
	 * @param map
	 * @return
	 */
	@Override
	public int getAuto(Map paramsMap, Map map) {
		//paramsMap中存放的是tb_car的number，type，driver，capacity，depart_time，arrive_time，next_store
		//map中存放的是被选择的订单号
		//Date depart_time = setDate1(paramsMap);
		//Date arrive_time = setDate2(paramsMap);
		//map中通过for循环拿出一个订单号，执行几次sql语句
		Object user = paramsMap.get("user");
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		String store = adminOne.get(0).get("store")+"";
		
		
		String deprtTime = paramsMap.get("departTime")+"";
		String arriveTime = paramsMap.get("arriveTime")+"";
		Date date1 = setDate(deprtTime);
		Date date2 = setDate(arriveTime);
		String nowStore ="";
		for (int i = 0; i < map.size(); i++) {
			String order_number = map.get("id"+i)+"";//订单号
			//查询订单表中的现在地址
			List<Map<String,Object>> list = BaseDao.selectMap("select order_now_store from tb_order where order_mailnum=?", new Object[]{order_number});
			nowStore = list.get(0).get("order_now_store")+"";
			//1，该订单在订单表的状态改变为装配4
			BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=? where order_mailnum=?", new Object[]{4,order_number});
			//2，该订单在装配表的状态改变为已装配，
			BaseDao.insertAndUpdateAndDelete("update tb_auto set auto_status=? where order_number=?", new Object[]{"已装配",order_number});
			//4，将页面该订单的number，type，driver，capacity，depart_time，arrive_time，next_store插入到装配详情表tb_auto中
			BaseDao.insertAndUpdateAndDelete("update tb_auto set car_number=?,next_store=?,depart_time=?,arrive_time=? where order_number = ? and now_store=?",new Object[]{paramsMap.get("number"),paramsMap.get("next_store"),date1,date2,order_number,store});
			//5，将该订单的历史记录记录到历史表中
			BaseDao.insertAndUpdateAndDelete("insert into tb_history (history_order_number,history_store,history_car_number,history_time) values (?,?,?,?)", new Object[]{order_number,nowStore,paramsMap.get("number"),date2});
		}
		//将车car-code,order_count,now_store,next_store,depart_time,arrive_time,auto_status插入tb_auto_car
		BaseDao.insertAndUpdateAndDelete("insert into tb_auto_car (car_code,order_count,now_store,next_store,depart_time,arrive_time,auto_status) values (?,?,?,?,?,?,?)", 
				new Object[]{paramsMap.get("number"),map.size(),nowStore,paramsMap.get("next_store"),date1,date2,"已装配"});
		//3，将该货车的状态改为运输中2
		return BaseDao.insertAndUpdateAndDelete("update tb_car set state=? where number=?", new Object[]{2,paramsMap.get("number")});
	}
	/**
	 * 设置时间日期格式
	 * @param time
	 */
	private Date setDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 获取装配管理页面的已装配的分页数据的总数量
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPageCount(Map map) {
		return  BaseDao.selectMap("select count(*) as cnt from tb_auto where auto_status = ? ", new Object[]{"已装配"});
	}
	/**
	 * 获取装配管理页面的已装配的分页数据
	 * @param start  开始值
	 * @param rows  每页显示数量
	 * @param map  其他参数
	 * @return
	 */
	@Override
	public Object getPage(int start, int rows, Map map) {
		Object user = map.get("user");
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		String store = adminOne.get(0).get("store")+"";
		return BaseDao.selectMap("select c.type,c.driver,u.car_code,u.next_store,u.order_count,u.depart_time,u.arrive_time,u.auto_status from tb_auto_car u left join tb_car c on u.car_code=c.number where auto_status=? and u.now_store=?"+" limit "+start+","+rows, new Object[]{"已装配",store});
	}
	/**
	 * 封装参数
	 * @param map
	 * @return
	 */
	private String setParams(Map map){
		     //查询参数
				String str1 = " where 1=1 ";
				Object empId = map.get("empId");
				//拼接empId
				if(empId!=null&&!"".equals(empId)){
					str1 += " and id ="+empId;
				}
				//拼接empNo
				Object empNo = map.get("empNo");
				//拼接empId
				if(empNo!=null&&!"".equals(empNo)){
					str1 += " and empno like '%"+empNo+"%'";
				}
				return str1;
	}
	
	
	
	/**
	 * 装配管理界面的出库按钮
	 * @param paramsMap
	 */
	/**
	 * 通过车牌号找到需要更改的订单
	 * @return
	 */
	@Override
	public int orderNumByCarNumOutKu(Map paramMap) {
		// TODO Auto-generated method stub
		String carNum = paramMap.get("carNumber")+"";
		//先查询出需要更改的订单号
		List<Map<String, Object>> orderNumList = BaseDao.selectMap("select a.order_number,a.car_number, a.next_store from tb_auto a left join tb_auto_car ac on a.car_number=ac.car_code where ac.car_code=?", new Object[]{carNum});
		for (Map<String, Object> map : orderNumList) {
			String orderNum = map.get("order_number")+"";//订单号
			String nextStore = map.get("next_store")+"";
			//1，订单表的订单状态改为待审核
			BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=?,order_now_store=? where order_mailnum=?", new Object[]{2,nextStore,orderNum});
		}
		//2，车表的状态装配中已改过为运输中
		//3，装配表的状态已出库
		BaseDao.insertAndUpdateAndDelete("update tb_auto_car set auto_status=? where car_code=?", new Object[]{"已出库",carNum});
		//4，状态详情表的状态改为已出库
		//5，历史记录表不用改
		 return BaseDao.insertAndUpdateAndDelete("update tb_auto set auto_status=? where car_number=? ", new Object[]{"已出库",carNum});
	}
	/**
	 * 装配管理页面的删除按钮
	 * @return
	 */
	@Override
	public int delOrderByOrderNum(Map paramsMap) {
		// TODO Auto-generated method stub
		//先改订单的状态为审核通过
		BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=? where order_mailnum=?", new Object[]{2,paramsMap.get("orderNum")});
		//把装配表详情表的该单删除tb_auto
		return BaseDao.insertAndUpdateAndDelete("delete from tb_auto where order_number=?", new Object[]{paramsMap.get("orderNum")});
	}
	/**
	 * 通过车牌号获取装配详情表的信息
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getInCarOrder(Map paramMap){
		Object user = paramMap.get("user");
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		String store = adminOne.get(0).get("store")+"";
		return BaseDao.selectMap("select c.number,c.type,c.driver,c.capacity,a.depart_time,a.arrive_time,a.next_store,o.order_mailnum,o.accepter_adr,o.accepter_name,o.order_time,o.goods_type,o.goods_weight,o.order_now_store,o.goods_remarks,o.goods_status from tb_auto a left join tb_order o on a.order_number=o.order_mailnum left join tb_car c on a.car_number=c.number where a.auto_status=? and c.number=? and a.now_store=? ", new Object[]{"已装配",paramMap.get("carNumber"),store});
	}
	/**
	 * //订单在订单表的订单状态改为入库
	 */
	@Override
	public int updateOrderInKu(String orderCode) {
		return BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status = ? where order_mailnum=? ", new Object[]{3,orderCode});
	}
	/**
	 * //该订单在装配详情表的状态改为待装配
	 * @param orderCode
	 * @return
	 */
	@Override
	public int updateAutoWait(String orderCode) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_auto set auto_status = ? where order_number=?", new Object[]{"待装配",orderCode});
	}
	/**
	 * 装配详情表中的原先插入的字段更新为空值
	 */
	@Override
	public int updateAutoNull(String orderCode) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_auto set car_number=?,next_store=?,depart_time=?,arrive_time=? where order_number = ?", new Object[]{null,null,null,null,orderCode});
	}
	/**
	 * 删除历史记录的该订单数据
	 * @param orderCode
	 */
	@Override
	public int delHistoryByOrderCode(String orderCode) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("delete from tb_history where history_order_number = ?", new Object[]{orderCode});
	}
	/**
	 * 判断(查询)此时货车的订单是否为0，
	 * @param carCode
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectCarIsOrderNum(String carCode) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select order_count from tb_auto_car where car_code=?", new Object[]{carCode});
	}
	/**
	 * /如果为0，将货车的状态改为空闲，在装配表中更新该车的数据为空，
	 */
	@Override
	public int ifOrderNotInCar(String carCode) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_car set state=? where number=?", new Object[]{1,carCode});
	}
	/**
	 * 通过车牌号删除装配表的那条数据
	 * 
	 */
	public int delAutoCarCarMsg(String carCode) {
		return BaseDao.insertAndUpdateAndDelete("delete from tb_auto_car where car_code=?", new Object[]{carCode});
	}
	/**
	 * 将装配表的订单数量减一
	 * @param carCode
	 */
	@Override
	public int delOneInOrderCount(String carCode) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = BaseDao.selectMap("select order_count from tb_auto_car where car_code=?", new Object[]{carCode});
		String str = list.get(0).get("order_count")+"";
		Integer count = Integer.valueOf(str);
		return BaseDao.insertAndUpdateAndDelete("update tb_auto_car set order_count = ? where car_code=?", new Object[]{count-1,carCode});
	}
	/**
	 * 删除货车订单为0装配表的数据
	 */
	@Override
	public int delCarInAutoCar(String carCode) {
		return BaseDao.insertAndUpdateAndDelete("delete from tb_auto_car where car_code=?", new Object[]{carCode});
	}
	/**
	 * 通过车牌号查订单详情表的订单号
	 * @param carNumber
	 * @return
	 */
	@Override
	public List<Map<String,Object>> selectOrderNumByCarCode(String carNumber) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select order_number from tb_auto where car_number=?", new Object[]{carNumber});
	}
	/**
	 * 将session域里的用户所在门店获得
	 * 
	 */
	@Override
	public String getUser(Object user) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		String store = adminOne.get(0).get("store")+"";
		return store;
	}
	/**
	 * 车辆调度页面数据查询
	 */
	@Override
	public Object backCarOrder(int start, int rows,Map paramMap) {
		// TODO Auto-generated method stub
		Object user = paramMap.get("user");
		List<Map<String, Object>> adminOne = BaseDao.selectMap("select * from tb_admin where username=?", new Object[]{user});
		//本站门店
		String store = adminOne.get(0).get("store")+"";
		//需要显示的是车辆表的车所在地为我本站，车的所属门店不是我本站，状态为空闲1的车
		//需要展示的字段所属门店，司机，类型车牌号，颜色，现所在地址，状态
		return BaseDao.selectMap("select s.store_name,c.driver,c.type,c.number,c.color,c.capacity,c.address,c.state from tb_car c left join tb_store s on c.store = s.id where address=? and store_name <> ? and state = ?"+" limit "+start+","+rows, new Object[]{store,store,1});
	}
	/**
	 * 车辆调度的返程按钮
	 * @param paramsMap
	 * @return
	 */
	@Override
	public int backOrderCar(Map paramsMap) {
		// TODO Auto-generated method stub
		//车牌号
		String carNum = paramsMap.get("carNum")+"";
		//车本来的地址
		String carStore = paramsMap.get("carStore")+"";
		//更改车辆表的车的address为车辆的本来的地址
		
		return BaseDao.insertAndUpdateAndDelete("update tb_car set address=? where number=?", new Object[]{carStore,carNum});
	}

	
}
