package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.StoreDao;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	StoreDao store;
	@Override
	public List<Map<String, Object>> getPage(Map map) {
		// TODO Auto-generated method stub
	    //获取分页要素，判断如果为空，赋予默认值
		int pageNo = map.get("page")==null?1:Integer.valueOf(map.get("page")+"");
		int pageSize = map.get("rows")==null?10:Integer.valueOf(map.get("rows")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return store.getPage(start, pageSize, map);
	}
	/**
	 * 获得页面总数量
	 */
	@Override
	public int getPageCount(Map map) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> pageCount = store.getPageCount(map);
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
	public int storeAdd(Map map) {
		// TODO Auto-generated method stub
		return store.storeAdd(map);
	}
	/**
	 * 订单修改
	 */
	@Override
	public int updateStore(int id, Map map) {
		// TODO Auto-generated method stub
		return store.updateStore(id, map);
	}
	/**
	 * 删除订单
	 */
	@Override
	public int deleteStore(int id) {
		// TODO Auto-generated method stub
		return store.deleteStore(id);
	}
	/**
	 * 省，市，县插入数据库
	 */
	@Override
	public void insert(Map map) {
		store.insert(map);
	}
}
