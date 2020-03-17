package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.RepairCarDao;

/***
 *@className:RepairCarServiceImpl.java
 *@discripton:
 *@author:dujihu
 *@createTime:2018-10-11下午11:18:58
 *@version:1.0
 */
@Service
public class RepairCarServiceImpl implements RepairCarService {
	@Autowired
	private RepairCarDao repairCarDao;
	@Override
	public List<Map<String, Object>> getList() {
		// TODO Auto-generated method stub
		return repairCarDao.getList();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return repairCarDao.delete(id);
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
		return repairCarDao.getPage(start, pageSize, map);
	}

	@Override
	public int getPageCount(Map map) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> pageCount = repairCarDao.getPageCount(map);
		//判断集合  如果不为空  返回总数量
		if(pageCount!=null&&pageCount.size()>0){
			return Integer.valueOf(pageCount.get(0).get("cnt")+"");
		}
		return 0;
	}


	@Override
	public int add(Map map) {
		// TODO Auto-generated method stub
		return repairCarDao.add(map);
	}

	@Override
	public int update(Map map, int id) {
		// TODO Auto-generated method stub
		return repairCarDao.update(map, id);
	}

	@Override
	public List<Map<String, Object>> getListByCarNum(String car_driver_papers) {
		// TODO Auto-generated method stub
		return repairCarDao.getListByCarNum(car_driver_papers);
	}

	@Override
	public List<Map<String, Object>> getListById(int car_driver_id) {
		// TODO Auto-generated method stub
		return repairCarDao.getListById(car_driver_id);
	}

	@Override
	public int updateById(int id,String val) {
		// TODO Auto-generated method stub
		repairCarDao.updateResult(id,val);
		repairCarDao.updateHisResult(id,val);
		
		return repairCarDao.updateById(id,val);
	}

	@Override
	public List<Map<String, Object>> getRepairMan() {
		// TODO Auto-generated method stub
		return repairCarDao.getRepairMan();
	}

	@Override
	public int updateEmpid(int id, String name) {
		// TODO Auto-generated method stub
		
		 repairCarDao.updateEmpid(id, name);
		return 1;
	}

	@Override
	public List<Map<String, Object>> getHistoryPage(Map map) {
		// TODO Auto-generated method stub
		/**
		 * 获取分页要素  判断如果为空   取默认值 
		 */
		int pageNo = map.get("page")==null?1:Integer.valueOf( map.get("page")+"");
		int pageSize = map.get("rows")==null?10:Integer.valueOf(map.get("rows")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return repairCarDao.getHistoryPage(start, pageSize, map);
	}

	@Override
	public int getHistoryPageCount(Map map) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> pageCount = repairCarDao.getHistoryPageCount(map);
		//判断集合  如果不为空  返回总数量
		if(pageCount!=null&&pageCount.size()>0){
			return Integer.valueOf(pageCount.get(0).get("cnt")+"");
		}
		return 0;
	}

	@Override
	public int saveHis(Map map) {
		// TODO Auto-generated method stub
		if(Integer.valueOf(map.get("val")+"")==1){
		repairCarDao.updateById(Integer.valueOf(map.get("service_record_id")+""),"3");
		}else if(Integer.valueOf(map.get("val")+"")==2){
		repairCarDao.updateById(Integer.valueOf(map.get("service_record_id")+""),"2");	
		}else if(Integer.valueOf(map.get("val")+"")==99){
			repairCarDao.updateById(Integer.valueOf(map.get("service_record_id")+""),"4");	
		}else if(Integer.valueOf(map.get("val")+"")==66){
			repairCarDao.updateById(Integer.valueOf(map.get("repair_history_id")+""), "88");
		}
		
		
		repairCarDao.updateMoney(map);
		return repairCarDao.saveHis(map);
	}

}
