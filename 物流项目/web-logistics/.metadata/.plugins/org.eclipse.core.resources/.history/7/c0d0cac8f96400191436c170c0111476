package com.aaa.mvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	/**
	 * 获取分页数据
	 * 
	 */
	@Override
	public List<Map<String, Object>> getPage(int start, int rows, Map map) {
		// TODO Auto-generated method stub
		//排序参数
		String str = "";
		if(map.get("sort")!=null){
			str = " order by "+map.get("sort")+" "+map.get("order");
		}
		//打印执行语句
		return BaseDao.selectMap("select id,dept,sex,ename,tel,duties,username,hiredate,state,store,password ,roleId from tb_admin "+setParams(map)+str+" limit "+start+","+rows, null);
	}

	/**
	 * 封装参数
	 * @param map
	 * @return
	 */
	private String setParams(Map map){
		     //查询参数
				String str1 = " where 1=1 ";
				Object ename = map.get("ename");
				//拼接id
				if(ename!=null&&!"".equals(ename)){
					str1 += " and ename ="+"'"+ename+"'";
				}
				//拼接numbmer
				Object username = map.get("username");
				//拼接numbmer
				if(username!=null&&!"".equals(username)){
					str1 += " and username ="+"'"+username+"'";
				}
				return str1;
	}
	
	/**
	 * 通用的封装参数方法
	 * @param map
	 * @return
	 */
	private String setParam(Map map,int tel){
		String str=" where 1=1 ";
		//返回map中的所有key
		Set keySet = map.keySet();
		if(!keySet.isEmpty()){
			for(Object key:keySet){
				if(map.get(key)!=null&&!"".equals(map.get(key))&&tel==1)
				  str += " and "+key+"="+map.get(key); 
				if(map.get(key)!=null&&!"".equals(map.get(key))&&tel==2)
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
				Object username = map.get("username");
				//拼接empId
				if(username!=null&&!"".equals(username)){
					str1 += " and username like '%"+username+"%'";
				}*/
		return  BaseDao.selectMap("select count(*) as cnt from tb_admin "+setParams(map), null);
	}
	/**
	 * 添加用户
	 */
	@Override
	public int empAdd(Map map) {
		//把object格式日期数据转化为日期形式
				Date hiredate =null;
				try {
					hiredate = new SimpleDateFormat("MM/dd/yyyy").parse(map.get("hiredate")+"");
				} catch (ParseException e) {
					e.printStackTrace();
				}
		return BaseDao.insertAndUpdateAndDelete("insert into tb_admin(dept,sex,ename,tel,duties,username,password,hiredate,state,store,roleId) values(?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{map.get("dept"),map.get("sex"),map.get("ename"),map.get("tel"),map.get("duties"),map.get("username"),map.get("password"),hiredate,map.get("state"),map.get("store"),map.get("roleId")});
	}
	/**
	 * 用户更新
	 */
	@Override
	public int empUpdate(Map paramMap) {
				//把object格式日期数据转化为日期形式
				Date hiredate =null;
				try {
					hiredate = new SimpleDateFormat("MM/dd/yyyy").parse(paramMap.get("hiredate")+"");
				} catch (ParseException e) {
					e.printStackTrace();
				}
		return BaseDao.insertAndUpdateAndDelete("update tb_admin set dept=?,sex=?,ename=?,tel=?,duties=?,username=?,hiredate=?,state=?,store=? ,password=? ,roleId=? where id=?", 
				new Object[]{paramMap.get("dept"),paramMap.get("sex"),paramMap.get("ename"),paramMap.get("tel"),paramMap.get("duties"),paramMap.get("username"),hiredate,paramMap.get("state"),paramMap.get("store"),paramMap.get("password"),paramMap.get("roleId"),paramMap.get("id")});

	}
	/**
	 * 用户删除
	 */
	@Override
	public int empDel(String id) {
		return BaseDao.insertAndUpdateAndDelete("delete from tb_admin where id=?",new Object[]{id});
	}
	/**
	 * 把更新好的权限放入数据库
	 */
	@Override
	public int addRoleAndPowers(String roleId, String powerId) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("insert into tb_admin_power(roleId,powerId) values(?,?)", 
				new Object[]{roleId,powerId});
	}

	@Override
	public int deletePowersByRoleId(String roleId) {
		return BaseDao.insertAndUpdateAndDelete("delete from tb_admin_power where roleId=?", 
				new Object[]{roleId});
	}
	/**
	 * 获得角色数据
	 */
	@Override
	public Object getRolePage(int start, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select * from tb_role", null);
	}
	/**
	 * 获得角色数据总数量
	 */
	@Override
	public List<Map<String, Object>> getRolePageCount(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select count(*) as cnt from tb_role", null);
	}
}
