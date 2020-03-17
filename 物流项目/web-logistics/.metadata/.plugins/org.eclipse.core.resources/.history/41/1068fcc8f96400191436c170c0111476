package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaa.mvc.dao.AbnormalOrderDao;

/***
 *@className:AdnormalOrderImpl.java
 *@discripton:
 *@author:dujihu
 *@createTime:2018-10-21下午8:11:53
 *@version:1.0
 */
@Repository
public class AdnormalOrderServiceImpl implements AbnormalOrderService {
	@Autowired
	private AbnormalOrderDao abnormalOrderDao;
	@Override
	public List<Map<String, Object>> getAllOrder(Map map) {
		// TODO Auto-generated method stub
		return abnormalOrderDao.getAllOrder(map);
	}
	@Override
	public int addBadOrder(Map map) {
		// TODO Auto-generated method stub
		return abnormalOrderDao.addBadOrder(map);
	}
	@Override
	public List<Map<String, Object>> getPage(Map map) {
		// TODO Auto-generated method stub
		/**
		 * 获取分页要素  判断如果为空   取默认值 
		 */
		int pageNo = map.get("page")==null?1:Integer.valueOf( map.get("page")+"");
		int pageSize = map.get("rows")==null?10:Integer.valueOf(map.get("rows")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return abnormalOrderDao.getPage(start, pageSize, map);
	}

	@Override
	public int getPageCount(Map map) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> pageCount = abnormalOrderDao.getPageCount(map);
		//判断集合  如果不为空  返回总数量
		if(pageCount!=null&&pageCount.size()>0){
			return Integer.valueOf(pageCount.get(0).get("cnt")+"");
		}
		return 0;
	}
	@Override
	public List<Map<String, Object>> getAllBadOrder(Map map) {
		// TODO Auto-generated method stub
		return abnormalOrderDao.getAllBadOrder(map);
	}
	@Override
	public int updateState(Map map) {
		// TODO Auto-generated method stub
		if(Integer.valueOf(map.get("val")+"")==5){
			abnormalOrderDao.saveBill(map);
			abnormalOrderDao.saveBadOrder(map);
		}
		return abnormalOrderDao.updateState(map);
	}
}
