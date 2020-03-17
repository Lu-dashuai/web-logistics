package com.aaa.mvc.dao;

import java.util.List;
import java.util.Map;

/***
 *@className:RepairCarDao.java
 *@discripton:
 *@author:dujihu
 *@createTime:2018-10-11下午11:15:55
 *@version:1.0
 */

public interface RepairCarDao {
	/**
	 * 查询待维修的车辆
	 * @return
	 */
	List<Map<String,Object>> getList();
	/**
	 * 删除车辆信息
	 * @param id
	 * @return
	 */
	int delete(int id);
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
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPageCount(Map map);
	/**
	 * 获取维修历史分页数据
	 * @param start  开始值
	 * @param rows  每页显示数量
	 * @param map  其他参数
	 * @return
	 */
	List<Map<String,Object>> getHistoryPage(int start,int rows,Map map);
	/**
	 * 获取维修历史分页数据的总数量
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getHistoryPageCount(Map map);
	/**
	 *添加车辆信息
	 * @param map
	 * @return
	 */
	int add(Map map);
	/**
	 * 修改车辆信息
	 * @param map
	 * @param id
	 * @return
	 */
	int update(Map map,int id);
	/**
	 * 通过维修id 修改维修车辆的维修状态
	 * @param id
	 * @return
	 */
	int updateById(int id,String val);
	/**
	 * 通过车牌号获取车辆信息
	 * @param car_driver_papers
	 * @return
	 */
	List<Map<String,Object>> getListByCarNum(String car_driver_papers);
	/**
	 * 通过Id查询维修车辆信息
	 * @param car_driver_id
	 * @return
	 */
	List<Map<String,Object>> getListById(int car_driver_id);
	/**
	 * 查询维修人员
	 * @return
	 */
	List<Map<String,Object>> getRepairMan();
	/**
	 * 
	 * @return
	 */
	int updateEmpid(int id,String name );
	/**
	 * 保存维修历史
	 * @return
	 */
	int saveHis(Map map);
	/**
	 * 更新维修费用和结果
	 * @return
	 */
	int updateMoney(Map map);
	/**
	 * 更新原表维修结果
	 * @param id
	 * @return
	 */
	int updateResult(int id,String val);
	/**
	 * 更新历史表维修结果
	 * @param id
	 * @return
	 */
	int updateHisResult(int id,String val);
}
