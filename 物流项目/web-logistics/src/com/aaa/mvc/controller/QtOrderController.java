package com.aaa.mvc.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaa.mvc.service.QtOrderService;

@Controller
@RequestMapping("/qtorder")
public class QtOrderController {
	@Autowired
	private QtOrderService qtOrderService;
	/**
	 * 订单操作
	 * @param map
	 * @return
	 */
	@RequestMapping("/add")
	public String userAdd(@RequestParam Map paramMap,Model model){
		Object dd = paramMap.get("goods_supportvalue");
		int userAdd = qtOrderService.userAdd(paramMap);
		List<Map<String,Object>> storeList = qtOrderService.selectHistory(paramMap); 
		model.addAttribute("orderList", storeList);
		//Map map = new HashMap();
		return "forwardStage/jiesuan";
	}
	/**
	 * 前台按订单号查询
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@RequestMapping("/select")
	public String selectAdd(@RequestParam Map paramMap,HttpServletRequest request){
		List<Map<String, Object>> selectUser = qtOrderService.selectOrder(paramMap);
		request.setAttribute("list", selectUser);
		return "forwardStage/chaxundingdan";
		
	}
	/**
	 * 前台按手机号查询
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@RequestMapping("/selecti")
	public String selectPhone(@RequestParam Map paramMap,String sender_phone,HttpServletRequest request){
		List<Map<String, Object>> selectUser = qtOrderService.selectPhone(paramMap);
		request.setAttribute("list", selectUser);
		return "forwardStage/chaxundingdan";
	}
	/**
	 * 前台按历史订单号查询
	 * @param paramMap
	 * @param request
	 * @return
	 * 订单号
	 */
	@RequestMapping("/historyOrderNum")
	public String historyOrderNum(@RequestParam Map paramMap,HttpServletRequest request){
		List<Map<String, Object>> selectHistory = qtOrderService.selectHistoryByNum(paramMap);
		request.setAttribute("list", selectHistory);
		return "forwardStage/historyMsg";
		
	}
	/**
	 * 前台按历史手机号查询
	 * @param paramMap
	 * @param request
	 * @return
	 * 手机号
	 */
	@RequestMapping("/historyPhoneNum")
	public String historyPhoneNum(@RequestParam Map paramMap,HttpServletRequest request){
		List<Map<String, Object>> selectHistory = qtOrderService.selectHistoryPhoneNum(paramMap);
		request.setAttribute("list", selectHistory);
		request.setAttribute("size", selectHistory.size());
		return "forwardStage/historyMsg";
	}
	
}
