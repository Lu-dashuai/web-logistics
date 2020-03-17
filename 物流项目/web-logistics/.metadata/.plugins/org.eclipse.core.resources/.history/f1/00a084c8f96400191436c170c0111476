package com.aaa.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

@Repository
public class CarDaoImpl implements CarDao {
	
	
	@Override
	public List<Map<String, Object>> select() {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select car_id,car_driver,car_type,car_driver_papers,car_color,car_bulk,car_load,car_state,car_outlet from tb_car_details", null);
	}
	
	/**
	 * 获取分页数据
	 */
	@Override
	public List<Map<String, Object>> getPage(int start, int rows, Map map) {
		// TODO Auto-generated method stub
		//排序参数
		String str = "";
		if(map.get("sort")!=null){
			str = " order by "+map.get("sort")+" "+map.get("order");
		}
		//查询参数
		/*String str1 = " where 1=1 ";
		Object id = map.get("id");
		//拼接empId
		if(id!=null&&!"".equals(id)){
			str1 += " and id ="+id;
		}
		//拼接empNo
		Object number = map.get("number");
		//拼接empId
		if(number!=null&&!"".equals(number)){
			str1 += " and number like '%"+number+"%'";
		}*/
		//打印执行语句
		return BaseDao.selectMap("select id,number,driver,store,type,color,volume,capacity,state from tb_car "+setParams(map)+str+" limit "+start+","+rows, null);
	}

	/**
	 * 封装参数
	 * @param map
	 * @return
	 */
	private String setParams(Map map){
		     //查询参数
				String str1 = " where 1=1 ";
				Object id = map.get("id");
				//拼接id
				if(id!=null&&!"".equals(id)){
					str1 += " and id ="+id;
				}
				//拼接numbmer
				Object number = map.get("number");
				//拼接numbmer
				if(number!=null&&!"".equals(number)){
					str1 += " and number ="+number;
				}
				return str1;
	}
	
	/**
	 * 通用的封装参数方法
	 * @param map
	 * @return
	 */
	private String setParam(Map map,int type){
		String str=" where 1=1 ";
		//返回map中的所有key
		Set keySet = map.keySet();
		if(!keySet.isEmpty()){
			for(Object key:keySet){
				if(map.get(key)!=null&&!"".equals(map.get(key))&&type==1)
				  str += " and "+key+"="+map.get(key); 
				if(map.get(key)!=null&&!"".equals(map.get(key))&&type==2)
					str += " and "+key+" like '%"+map.get(key)+"%'"; 
			}
		}
		return str;
	}
	/**
	 * 获得数据总页数
	 */
	@Override
	public  List<Map<String, Object>> getPageCount(Map map) {
		// TODO Auto-generated method stub
	     	//查询参数
			/*	String str1 = " where 1=1 ";
				Object id = map.get("id");
				//拼接empId
				if(id!=null&&!"".equals(id)){
					str1 += " and id ="+id;
				}
				//拼接empNo
				Object number = map.get("number");
				//拼接empId
				if(number!=null&&!"".equals(number)){
					str1 += " and number like '%"+number+"%'";
				}*/
		return  BaseDao.selectMap("select count(*) as cnt from tb_car "+setParams(map), null);
	}

	@Override
	public int carAdd(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("insert into tb_car(number,driver,store,type,color,volume,capacity,state) values(?,?,?,?,?,?,?,?)",
				new Object[]{map.get("number"),map.get("driver"),map.get("store"),map.get("type"),map.get("color"),map.get("volume"),map.get("capacity"),map.get("state")});
	}
	/**
	 * 用户更新
	 */
	@Override
	public int carUpdate(Map paramMap) {
		return BaseDao.insertAndUpdateAndDelete("update tb_car set number=?,driver=?,store=?,type=?,color=?,volume=?,capacity=?,state=? where id=?", 
				new Object[]{paramMap.get("number"),paramMap.get("driver"),paramMap.get("store"),paramMap.get("type"),paramMap.get("color"),paramMap.get("volume"),paramMap.get("capacity"),paramMap.get("state"),paramMap.get("id")});

	}
	/**
	 * 用户删除
	 */
	@Override
	public int carDel(String id) {
		return BaseDao.insertAndUpdateAndDelete("delete from tb_car where id=?",new Object[]{id});
	}
}
