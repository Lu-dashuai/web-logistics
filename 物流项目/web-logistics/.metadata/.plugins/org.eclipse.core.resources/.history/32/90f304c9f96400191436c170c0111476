package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.DistributeDao;

@Service
public class DistributeServiceImpl implements DistributeService {
	@Autowired
	DistributeDao distribute;
	/**
	 * 获取页面总条数
	 */
	@Override
	public int getPageCount(Map paramMap) {
		 List<Map<String, Object>> pageCount = distribute.getPageCount(paramMap);
		 if(pageCount!=null&&pageCount.size()>0){
				return Integer.valueOf(pageCount.get(0).get("cnt")+"");
			}
			return 0;
	}
	/**
	 * 获取当前页
	 */
	@Override
	public Object getPage(Map paramMap) {
		 //获取分页要素，判断如果为空，赋予默认值
		int pageNo = paramMap.get("page")==null?1:Integer.valueOf(paramMap.get("page")+"");
		int pageSize = paramMap.get("rows")==null?10:Integer.valueOf(paramMap.get("rows")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return distribute.getPage(start, pageSize, paramMap);
	}
	/**
	 * 更新取件派件的状态
	 */
	@Override
	public int updateStatus(Map map) {
		return distribute.updateStatus(map);
	}
	/**
	 * 获得配送员的list
	 */
	@Override
	public Object selectPeople() {
		return distribute.selectPeople();
	}
	@Override
	public List<Map<String, Object>> getById(String id) {
		return distribute.getById(id);
	}

}
