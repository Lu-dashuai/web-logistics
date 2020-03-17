package com.aaa.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.AbnormalOrderService;

/***
 *@className:AbnormalOrder.java
 *@discripton:
 *@author:dujihu
 *@createTime:2018-10-21下午6:21:58
 *@version:1.0
 */
@Controller
@RequestMapping("/bad")
public class AbnormalOrderController {
	@Autowired
	private AbnormalOrderService abnormalOrderService;
	/**
	 * 到添加页面
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAddOrder(){
		
		return "abnormalOrder/addBadOrder";
	}
	/**
	 * 到待审核页面
	 * @return
	 */
	@RequestMapping("/toWaitCheck")
	public String toWaitCheck(){
		
		return "abnormalOrder/waitCheck";
	}
	/**
	 * 到未通过页面
	 * @return
	 */
	@RequestMapping("/toNoPass1")
	public String toNoPass1(){
		
		return "abnormalOrder/noPass1";
	}
	/**
	 * 到初审通过页面
	 * @return
	 */
	@RequestMapping("/toPass")
	public String toPass(){
		
		return "abnormalOrder/pass";
	}
	/**
	 * 到待赔付页面
	 * @return
	 */
	@RequestMapping("/toWaitPay")
	public String toWaitPay(){
		
		return "abnormalOrder/waitPay";
	}
	/**
	 * 到展示所有
	 * @return
	 */
	@RequestMapping("/toShowAll")
	public String toShowAll(){
		
		return "abnormalOrder/showAll";
	}
	/**
	 * 获取订单信息
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allOrder")
	public Object getAllOrder(@RequestParam Map map){
		
		return abnormalOrderService.getAllOrder(map).get(0);
	}
	@ResponseBody
	@RequestMapping("/saveBadOrder")
	public Object saveBadOrder(@RequestParam Map map){
		int result = abnormalOrderService.addBadOrder(map);
		if(result==0){
			map.put("msg", "提交失败");
		}else{
			map.put("msg", "提交成功");
		}
		return map;
	}
	
	/**
	 * 获取待审核订单表
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allBadOrder")
	public Object allBadOrder(@RequestParam Map paramMap){
		Map map = new HashMap();
		//总数量
		map.put("total", abnormalOrderService.getPageCount(paramMap));
		//分页查询结果
		map.put("rows",abnormalOrderService.getPage(paramMap) );
		return map;
	}
	/**
	 * 获取所有异常单
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllBad")
	public Object getAllBad(@RequestParam Map paramMap){
		
		return abnormalOrderService.getAllBadOrder(paramMap).get(0);
	}
	/**
	 * 更新状态
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object updateState(@RequestParam Map map){
		int result = abnormalOrderService.updateState(map);
		if(result==0){
			map.put("msg", "提交失败");
		}else{
			map.put("msg", "提交成功");
		}
		return map;
	}
}
