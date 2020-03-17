package com.aaa.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

/***
 *@className:UserDaoImpl.java
 *@discripton:
 *@author:zz
 *@createTime:2018-9-30上午10:49:57
 *@version:
 */
@Repository
public class FinanceDaoImpl implements FinanceDao {
	@Override
	public List<Map<String, Object>> getPage(int start, int rows, Map map) {
		// TODO Auto-generated method stub
		//排序参数
		String str = "";
		if(map.get("sort")!=null){
			str = " order by "+map.get("sort")+" "+map.get("order");
		}
		return BaseDao.selectMap("select id,billtype,spendtype,remark,addtime,money from tb_bill "+setParams(map)+str+" limit "+start+","+rows, null);
	}

	/**
	 * 封装参数
	 * @param map
	 * @return
	 */
	private String setParams(Map map){
		     //查询参数
				String str1 = " where 1=1 ";
				//拼接billtype
				Object billtype = map.get("billtype");
				if(billtype!=null&&!"".equals(billtype)){
					str1 += " and billtype like '%"+billtype+"%'";
				}
				//拼接spendtype
				Object spendtype = map.get("spendtype");
				if(spendtype!=null&&!"".equals(spendtype)){
					str1 += " and spendtype like '%"+spendtype+"%'";
				}
				Object order_time_begin = map.get("begintime");
				Object order_time_end = map.get("endtime");
			//拼接时间
			if (order_time_begin!=null&&!"".equals(order_time_begin)) {
				str1 += " and addtime >= '"+order_time_begin+"'";
			}
			if (order_time_end!=null&&!"".equals(order_time_end)) {
				str1 += " and addtime <'"+order_time_end+"'";
			}
				return str1;
	}
	
	@Override
	public  List<Map<String, Object>> getPageCount(Map map) {
		// TODO Auto-generated method stub
		return  BaseDao.selectMap("select count(*) as cnt from tb_bill "+setParams(map), null);
	}

	@Override
	public List<Map<String, Object>> getFinanceCount() {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select sum(case when spendtype=1 then money end) zzc,sum(case when spendtype=2 then money end) zsr,"+
				"sum(case when billtype='维修金额' then money end) zwx,sum(case when billtype='订单金额' then money end) zdd,sum(case when billtype='异常金额' then money end) zyc from tb_bill", null);
	}

}
