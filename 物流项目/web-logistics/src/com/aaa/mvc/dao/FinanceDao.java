package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

/***
 *@className:UserDao.java
 *@discripton:
 *@author:zz
 *@createTime:2018-9-30上午10:47:52
 *@version:
 */
public interface FinanceDao {
	/**
	 * 获取分页数据
	 * @param start  开始值
	 * @param rows  每页显示数量
	 * @param map  其他参数
	 * @return
	 */
	List<Map<String,Object>> getPage(int start,int rows,Map map);
	/**
	 * 获取分页数据的总数量
	 * @param map
	 * @return
	 */
	 List<Map<String, Object>> getPageCount(Map map);
	 /**
	  * 统计财务
	  */
	 List<Map<String, Object>> getFinanceCount();
}
