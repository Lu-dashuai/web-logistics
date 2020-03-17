package com.aaa.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.DistributeService;
@Controller
@RequestMapping("/distribute")
public class DistributeOrderController {
	@Autowired
	DistributeService distribute;
	/**
	 * 配送人员调配页面
	 * @return
	 */
	@RequestMapping("/order")
	public String order(){
		return "backStage/order/distributeOrder";
	}
	/**
	 * 订单确认页面
	 * @return
	 */
	@RequestMapping("/take")
	public String takeOrder(){
		return "backStage/order/takeOrder";
	}
	/**
	 * 用户分页列表
	 * 查询所有状态的订单
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/page")
	public Object userPage(@RequestParam Map paramMap,HttpServletRequest req){
		Object object = paramMap.get("order_mailnum");
		Map map = new HashMap();
		//总数量
		map.put("total", distribute.getPageCount(paramMap));
		//分页查询的结果
	    map.put("rows", distribute.getPage(paramMap));
		return map;
	}
	/**
	 * 取件派件的状态改变
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update(@RequestParam Map map){
		
		int row=distribute.updateStatus(map);
		if(row==0){
		     map.put("showInfo", "操作失败");
		}else{
			  map.put("suc", "true");
			  map.put("showInfo", "操作成功");
		} 
		return map;
	}
	/**
	 * 
	 * 获得配送人员的list
	 */
	@ResponseBody
	@RequestMapping("/people")
	public Object selectPeople(){
		return distribute.selectPeople();
	}
	/**
	 * 根据员工id获得他的数据
	 */
	@ResponseBody
	@RequestMapping("/get")
	public Object getById(String id){
		 List<Map<String, Object>> byId = distribute.getById(id);
		Map<String, Object> map = byId.get(0);
		return map;
		
	}
}
