package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.OrdersDao;



@Service
public class OrdersServiceImpl implements OrdersService {
	//依赖注入
@Autowired
private OrdersDao orderDao;
@Override
public List<Map<String, Object>> getPage(Map map) {
	// TODO Auto-generated method stub
    //获取分页要素，判断如果为空，赋予默认值
	int pageNo = map.get("page")==null?1:Integer.valueOf(map.get("page")+"");
	int pageSize = map.get("rows")==null?8:Integer.valueOf(map.get("rows")+"");
	//计算开始值
	int start = (pageNo-1)*pageSize;
	return orderDao.getPage(start, pageSize, map);
}
@Override
public int getPageCount(Map map) {
	// TODO Auto-generated method stub
	List<Map<String, Object>> pageCount = orderDao.getPageCount(map);
	//判断集合，如果不为空，返回总数量
	if(pageCount!=null&&pageCount.size()>0){
		return Integer.valueOf(pageCount.get(0).get("cnt")+"");
	}
	return 0;
}
@Override
public List<Map<String, Object>> getOrderECharts(String province,String city) {
	// TODO Auto-generated method stub
	return orderDao.getOrderECharts(province,city);
}
}
