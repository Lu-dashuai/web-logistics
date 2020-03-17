package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;
@Repository
public class OrdersDaoImpl implements OrdersDao {
	@Override
	public List<Map<String, Object>> getPage(int start, int rows, Map map) {
		// TODO Auto-generated method stub
		//排序参数
		String str = "";
		if(map.get("sort")!=null){
			str = " order by "+map.get("sort")+" "+map.get("order");
		}
		//return BaseDao.selectMap("select order_now_store,count(order_now_store) as countorder,sum(goods_cost) as totalmoney from tb_order "+setParams(map)+str+"group by  order_now_store  limit "+start+","+rows, null);
		return BaseDao.selectMap("select a.order_now_store,sum(a.goods_cost) as cost,count(*) as cnt,"+
	"(select count(*) from tb_badorder tbb where tbb.id=a.id) as ycnum,round((select count(*) from tb_badorder tbb "+
			"where tbb.id=a.id)/count(*),2) as yclnum,ifnull((select sum(tbb.badorder_pay) from tb_badorder tbb "+
			"where tbb.id=a.id),0) as badorder_pay "+
			" from tb_order a " +setParams(map)+str+ " group by a.order_now_store  limit "+start+","+rows, null);
	}

	
	/**
 * 封装参数
	 * @param map
	 * @return
	 */
	private String setParams(Map map){
		     //查询参数
				String str1 = " where 1=1 ";
				if(map.get("order_now_store")!=null){
					//拼接order_now_store
					Object order_now_store = map.get("order_now_store");
					if(order_now_store!=null&&!"".equals(order_now_store)){
						str1 += " and order_now_store like '%"+order_now_store+"%'";
					}
				}
				
				Object order_time_begin = map.get("begintime");
				Object order_time_end = map.get("endtime");
				//拼接empId
				if (order_time_begin!=null&&!"".equals(order_time_begin)) {
					str1 += " and order_time >= '"+order_time_begin+"'";
				}
				if (order_time_end!=null&&!"".equals(order_time_end)) {
					str1 += " and order_time <'"+order_time_end+"'";
				}
				return str1;
	}
	@Override
	public  List<Map<String, Object>> getPageCount(Map map) {
		// TODO Auto-generated method stub
		return  BaseDao.selectMap("SELECT  COUNT(DISTINCT order_now_store) as cnt FROM tb_order "+setParams(map), null);
	}


	@Override
	public List<Map<String, Object>> getOrderECharts(String province,String city) {
		// TODO Auto-generated method stub
		String str="";
		if(province!=null&&city!=null){
			str="'"+province+city+"%'";
		}
		return BaseDao.selectMap("select order_now_store,count(*) as cnt from tb_order where order_now_store like "+str+" group by order_now_store", null);
	}

}
