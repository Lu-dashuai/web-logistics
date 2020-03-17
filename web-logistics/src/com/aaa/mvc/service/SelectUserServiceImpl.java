package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.SelectUserDao;
@Service
public class SelectUserServiceImpl implements SelectUserService {

	//依赖注入
	@Autowired
	private SelectUserDao selectUserDao;
	
	@Override
	public List<Map<String, Object>> selectUser() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 添加用户
	 */
	@Override
	public int userAdd(Map map) {
		// TODO Auto-generated method stub
		return selectUserDao.userAdd(map);
	}
	/**
	 * 删除用户
	 */
	@Override
	public int userDel(int id) {
		// TODO Auto-generated method stub
		return selectUserDao.userDel(id);
	}
	/**
	 * 更新用户
	 */
	@Override
	public int userUpdate(Map paramMap) {
		// TODO Auto-generated method stub
		return selectUserDao.userUpdate(paramMap);
	}

	
	public List<Map<String, Object>> getPage(Map map) {
		// TODO Auto-generated method stub
	    //获取分页要素，判断如果为空，赋予默认值
		int pageNo = map.get("page")==null?1:Integer.valueOf(map.get("page")+"");
		int pageSize = map.get("rows")==null?10:Integer.valueOf(map.get("rows")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return selectUserDao.getPage(start, pageSize, map);
	}

	@Override
	public int getPageCount(Map map) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> pageCount = selectUserDao.getPageCount(map);
		//判断集合，如果不为空，返回总数量
		if(pageCount!=null&&pageCount.size()>0){
			return Integer.valueOf(pageCount.get(0).get("cnt")+"");
		}
		return 0;
	}
	

}
