package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

/***
 *@className:UserService.java
 *@discripton:
 *@author:zz
 *@createTime:2018-9-30上午10:53:06
 *@version:
 */
public interface FinanceService {
	/**
	 * 获取分页数据
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getPage(Map map);
	/**
	 * 获取分页数据总数量
	 * @param map
	 * @return
	 */
	int getPageCount(Map map);
	 /**
	  * 统计财务
	  */
	 List<Map<String, Object>> getFinanceCount();
}
