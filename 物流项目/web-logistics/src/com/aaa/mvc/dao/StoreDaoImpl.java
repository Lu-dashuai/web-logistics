package com.aaa.mvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

@Repository
public class StoreDaoImpl implements StoreDao {
	/**
	 * 获取分页数据的总数量
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public  List<Map<String, Object>> getPageCount(Map map) {
		
		return  BaseDao.selectMap("select count(*) as cnt from tb_store "+setParams(map), null);
	}
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
		return BaseDao.selectMap("select * from tb_store"+setParams(map)+str+" limit "+start+","+rows, null);
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
				Object node = map.get("node");
				if(node!=null&&!"".equals(node)){
					List<Map<String, Object>> selectMap = BaseDao.selectMap("select store_name from tb_store where id=?",new Object[]{node});
					Object store_ename = selectMap.get(0).get("store_name");
					str1+=" and store_name like '%"+store_ename+"%'";
				}
				Object store_name = map.get("store_name");
				Object store_master = map.get("store_master");
				//拼接order_mailnum
				if(store_name!=null&&!"".equals(store_name)){
					str1 = " where store_name ='"+store_name+"'";
				}else if(store_master!=null&&!"".equals(store_master)){
					str1 += " and store_master ='"+store_master+"'";
				}
				return str1;
	}
	/**
	 * 订单删除
	 */
	@Override
	public int deleteStore(int id) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("delete from tb_store where id = ?", new Object[]{id});
	}
	/**
	 * 门店添加
	 */
	@Override
	public int storeAdd(Map map) {
		//调用设置日期方法
		Date date = setDate(map);
		return BaseDao.insertAndUpdateAndDelete("insert into tb_store(store_addTime,store_name, store_master, store_address, store_tel,store_parentid) values (?,?,?,?,?,?)",
				new Object[]{date,map.get("store_name"),map.get("store_master"),map.get("sender_adr"),map.get("store_tel"),"".equals(map.get("store_parentid"))?0:map.get("store_parentid")});
	}
	/**
	 * 更新门店
	 */
	@Override
	public int updateStore(int id, Map map) {
		//调用设置日期方法
		Date date = setDate(map);
		return BaseDao.insertAndUpdateAndDelete("update tb_store set store_name=?,store_master=?,store_address=?,store_tel=?,store_addTime=? where id=?",
				new Object[]{map.get("store_name"),map.get("store_master"),map.get("sender_adr"),map.get("store_tel"),date,map.get("id")});
	}
	/**
	 * 设置时间日期格式
	 * @param time
	 */
	private Date setDate(Map map){
		//下单时期不为null再去执行
		if(map.get("store_addTime")!=null){
		String ss = map.get("store_addTime")+"";
		
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
	 * 省，市，县插入数据库
	 */
	@Override
	public void insert(Map map) {
		List<Map<String, Object>> selectMap = BaseDao.selectMap("select name from tb_province", null);
		Object provinceId = map.get("province");
		List<Map<String, Object>> selectMap2 = BaseDao.selectMap("select name from tb_province1 where code=?", new Object[]{provinceId});
		Object provinceName = selectMap2.get(0).get("name");
		int i=0;
		for (Map<String, Object> map2 : selectMap) {
			if(map2.get("name").equals(provinceName)){
				i=1;
				break;
			}
		}
		//数据库里面没找到那个元素
		if(i!=1){
				BaseDao.insertAndUpdateAndDelete("insert into tb_province(code,name) values(?,?)", new Object[]{provinceId,provinceName});
		}
		//市.................................
		List<Map<String, Object>> selectMap1 = BaseDao.selectMap("select name from tb_city", null);
		Object cityId = map.get("city");
		List<Map<String, Object>> selectMap21 = BaseDao.selectMap("select name from tb_city1 where code=?", new Object[]{cityId});
		Object cityName1 = selectMap21.get(0).get("name");
		int j=0;
		for (Map<String, Object> map2 : selectMap1) {
			if(map2.get("name").equals(cityName1)){
				j=1;
				break;
			}
		}
		//数据库里面没找到那个元素
		if(j!=1){
				BaseDao.insertAndUpdateAndDelete("insert into tb_city(code,name,provincecode) values(?,?,?)", new Object[]{cityId,cityName1,provinceId});
		}
	//县。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
		List<Map<String, Object>> selectMap11 = BaseDao.selectMap("select name from tb_area", null);
		Object areaId = map.get("area");
		List<Map<String, Object>> selectMap211 = BaseDao.selectMap("select name from tb_area1 where code=?", new Object[]{areaId});
		Object areaName1 = selectMap211.get(0).get("name");
		int k=0;
		for (Map<String, Object> map2 : selectMap11) {
			if(map2.get("name").equals(areaName1)){
				k=1;
				break;
			}
		}
		//数据库里面没找到那个元素
		if(j!=1){
				BaseDao.insertAndUpdateAndDelete("insert into tb_area(code,name,citycode) values(?,?,?)", new Object[]{areaId,areaName1,cityId});
		}
		
	}
}