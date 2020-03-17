package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

@Repository
public class DistributeDaoImpl implements DistributeDao {
	@Autowired
	HttpSession session;
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
		//获得门店名称
		 Object username = session.getAttribute("username");
		 List<Map<String, Object>> selectMap = BaseDao.selectMap("select store from tb_admin where username=?", new Object[]{username});
		 Object store = selectMap.get(0).get("store");
		     //查询参数
		String str1=null;
		Object goods_status = map.get("goods_status");
		if(goods_status!=null&&!"".equals(goods_status)){
			str1=" where goods_status="+goods_status+" and order_now_store='"+store+"' ";
		}else{
			 str1 = " where (goods_status=20 or goods_status=6) and order_now_store='"+store+"' ";
		}
				Object order_mailnum = map.get("order_mailnum");
				//拼接order_mailnum
				if(order_mailnum!=null&&!"".equals(order_mailnum)){
					str1 = " where order_mailnum ="+order_mailnum;
				}
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
	 * 更新派件取件状态
	 */
	@Override
	public int updateStatus(Map map) {
		if("2".equals(map.get("operate")+"")){
		return BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=7 where id=?", new Object[]{map.get("id")});
		}else if("1".equals(map.get("operate")+"")){
		return BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=1 where id=?", new Object[]{map.get("id")});
		}else{
		return BaseDao.insertAndUpdateAndDelete("update tb_order set goods_status=66 where id=?", new Object[]{map.get("id")});
		}
	}
	/**
	 * 获得配送员的list
	 */
	@Override
	public Object selectPeople() {
		 Object username = session.getAttribute("username");
		 List<Map<String, Object>> selectMap = BaseDao.selectMap("select store from tb_admin where username=?", new Object[]{username});
		 Object store = selectMap.get(0).get("store");
		return BaseDao.selectMap("select ename from tb_admin where roleId= 2 and store =?",new Object[]{store} );
	}
	/**
	 * 根据员工id获得数据
	 */
	@Override
	public List<Map<String, Object>> getById(String id) {
		return BaseDao.selectMap("select * from tb_order where id=?", new Object[]{id});
	}
}
