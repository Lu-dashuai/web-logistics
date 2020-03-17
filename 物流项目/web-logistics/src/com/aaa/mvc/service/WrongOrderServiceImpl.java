package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.WrongOrderDao;
@Service
public class WrongOrderServiceImpl implements WrongOrderService {
	@Autowired
	private WrongOrderDao wrongOrderDao;
	@Override
	public List<Map<String, Object>> getPage(Map map) {
		// TODO Auto-generated method stub
	    //获取分页要素，判断如果为空，赋予默认值
		int pageNo = map.get("page")==null?1:Integer.valueOf(map.get("page")+"");
		int pageSize = map.get("rows")==null?10:Integer.valueOf(map.get("rows")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return wrongOrderDao.getPage(start, pageSize, map);
	}

	@Override
	public int getPageCount(Map map) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> pageCount = wrongOrderDao.getPageCount(map);
		//判断集合，如果不为空，返回总数量
		if(pageCount!=null&&pageCount.size()>0){
			return Integer.valueOf(pageCount.get(0).get("cnt")+"");
		}
		return 0;
	}
	/**
	 * 订单添加
	 */
	@Override
	public int userAdd(Map map) {
		// TODO Auto-generated method stub
		return wrongOrderDao.userAdd(map);
	}
	/**
	 * 订单修改
	 */
	@Override
	public int updateOrder(int id, Map map) {
		// TODO Auto-generated method stub
		return wrongOrderDao.updateOrder(id, map);
	}
	/**
	 * 删除订单
	 */
	@Override
	public int deleteOrder(int id) {
		// TODO Auto-generated method stub
		return wrongOrderDao.deleteOrder(id);
	}
	/**
	 * 根据订单号获得该订单信息
	 */
	@Override
	public List<Map<String, Object>> getOrderPage(Map paramMap) {
		return wrongOrderDao.getOrderPage(paramMap);
	}

}
