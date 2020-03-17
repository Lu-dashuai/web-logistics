package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;
@Repository
public class SelectUserDaoImpl implements SelectUserDao {

	@Override
	public List<Map<String, Object>> selectUser() {
		
		return null;
	}
	/**
	 * 用户添加
	 */
	@Override
	public int userAdd(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("insert into tb_adduser(u_name,u_pwd,u_phone,u_email,u_account,u_number,u_city,u_type) values(?,?,?,?,?,?,?,?)",
				new Object[]{map.get("u_name"),map.get("u_pwd"),map.get("u_phone"),map.get("u_email"),map.get("u_account"),map.get("u_number"),map.get("u_city"),map.get("u_type")});
	}
	/**
	 * 用户删除
	 */
	@Override
	public int userDel(int id) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("delete from tb_adduser where id=?",new Object[]{id});
	}
	/**
	 * 用户更新
	 */
	@Override
	public int userUpdate(Map paramMap) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_adduser set u_name=?,u_pwd=?,u_phone=?,u_email=?,u_account=?,u_number=?,u_city=? where id=?", 
				new Object[]{paramMap.get("u_name"),paramMap.get("u_pwd"),paramMap.get("u_phone"),paramMap.get("u_email"),paramMap.get("u_account"),paramMap.get("u_number"),paramMap.get("u_city"),paramMap.get("id")});
	}
	/**
	 * 获取分页数据
	 */
	@Override
	public List<Map<String, Object>> getPage(int start, int rows, Map map) {
		//排序参数
				String str = "";
				if(map.get("sort")!=null){
					str = " order by "+map.get("sort")+" "+map.get("order");
				}
		//打印执行语句
		return BaseDao.selectMap("select id,u_name,u_pwd,u_phone,u_email,u_account,u_number,u_city,u_type from tb_adduser "+setParams(map)+str+" limit "+start+","+rows, null);
	}
	/**
	 * 封装参数
	 * @param map
	 * @return
	 */
	private String setParams(Map map){
		     //查询参数
				String str1 = " where 1=1 ";
				Object u_account = map.get("u_account");
				//拼接id
				if(u_account!=null&&!"".equals(u_account)){
					str1 += " and u_account ="+u_account;
				}
				//拼接numbmer
				
			
				return str1;
	}
	/**
	 * 获取分页总数据
	 */
	@Override
	public List<Map<String, Object>> getPageCount(Map map) {
		// TODO Auto-generated method stub
		return  BaseDao.selectMap("select count(*) as cnt from tb_adduser "+setParams(map), null);
	}

}
