package com.aaa.mvc.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa.mvc.util.BaseDao;
@SuppressWarnings("unused")
@Repository
public class WrongOrderDaoImpl implements WrongOrderDao {
	@Autowired
	private OrderDao orderDao;
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
		return BaseDao.selectMap("select * from tb_wrongorder"+setParams(map)+str+" limit "+start+","+rows, null);
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
				Object order_mailnum = map.get("order_mailnum");
				Object wrongorder_satus = map.get("wrongorder_satus");
				//拼接order_mailnum
				if(order_mailnum!=null&&!"".equals(order_mailnum)){
					str1 += " and order_mailnum ="+order_mailnum;
				}else if(wrongorder_satus!=null&&!"".equals(wrongorder_satus)){
					str1 += " and wrongorder_satus ="+wrongorder_satus;
				}
				return str1;
	}
	
	/**
	 * 获取分页数据的总数量
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public  List<Map<String, Object>> getPageCount(Map map) {
		
		return  BaseDao.selectMap("select count(*) as cnt from tb_wrongorder "+setParams(map), null);
	}
	/**
	  * 异常订单添加
	  * @param map
	  * @return
	  */
	@SuppressWarnings("rawtypes")
	@Override
	public int userAdd(Map map) {
		//先去删除订单表的数据按照快递单号
		orderDao.deleteOrderByMailNumber(map.get("order_mailnum"));
		//调用设置日期方法
		Date date = setDate(map);
		return BaseDao.insertAndUpdateAndDelete("insert into tb_wrongorder (order_time, sender_name, sender_phone, goods_supportvalue, goods_ifsupportvalue, wrongorder_type, wrongorder_satus, goods_name, goods_type,goods_cost,badpay,badreason) values (?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{date,map.get("sender_name"),map.get("sender_phone"),map.get("goods_supportvalue"),map.get("goods_ifsupportvalue"),map.get("wrongorder_type"),map.get("wrongorder_satus") ,map.get("goods_name"),map.get("goods_type"),map.get("goods_cost"),map.get("badpay"),map.get("badreason") });
	}
	/**
	 * 订单更改
	 */
	@Override
	public int updateOrder(int id,Map map) {
		//调用设置日期方法
		Date date = setDate(map);
		return BaseDao.insertAndUpdateAndDelete("update tb_wrongorder set order_time=?,sender_name=?,sender_phone=?,goods_supportvalue=?,goods_ifsupportvalue=?,wrongorder_type=?,wrongorder_satus=? ,goods_name=?,goods_type=?,goods_cost=? where id=?",
				new Object[]{date,map.get("sender_name"),map.get("sender_phone"),map.get("goods_supportvalue"),map.get("goods_ifsupportvalue"),map.get("wrongorder_type"),map.get("wrongorder_satus") ,map.get("goods_name"),map.get("goods_type"),map.get("goods_cost") ,id});
	}
	/**
	 * 订单删除
	 */
	@Override
	public int deleteOrder(int id) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("delete from tb_wrongorder where id = ?", new Object[]{id});
	}
	/**
	 * 设置时间日期格式
	 * @param time
	 */
	private Date setDate(Map map){
		//下单时期不为null再去执行
		if(map.get("order_time")!=null){
		String ss = map.get("order_time")+"";
		
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
		return null;
	}
	/**
	 * 获取下拉框的list数组
	 * @param paramMap
	 * @return
	 */
	public Object getXiaLaKuang(String caocuo) {
				if("1".equals(caocuo)){
					return BaseDao.selectMap("select * from tb_wrongorder_satus"+" limit "+0+","+100, null);
				}
				//打印执行语句
				return BaseDao.selectMap("select * from tb_wrongorder_type"+" limit "+0+","+100, null);
	}
	/**
	 * 根据订单号获得订单信息
	 */
	@Override
	public List<Map<String, Object>> getOrderPage(Map paramMap) {
		return BaseDao.selectMap("select * from tb_order where order_mailnum=?", new Object[]{paramMap.get("order_mailnum")});
	}
}
