package com.aaa.mvc.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.AutoOrderService;
import com.aaa.mvc.util.PageUtil;
import com.sun.org.glassfish.gmbal.ParameterNames;

@Controller
@RequestMapping("/autoOrder")
public class AutoOrderController {
	@Autowired
	private AutoOrderService autoOrderService; 
	/**
	 * 将session域里的用户获得
	 * 
	 */
	@ResponseBody
	@RequestMapping("/getUser")
	public Object getUser(HttpServletRequest request,HttpSession session){
		String user = request.getSession().getAttribute("username")+"";
		String userList = autoOrderService.getUser(user);
		return user;
	}
	/**
	 * 查询车辆信息
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/getCarMsg")
	public Object getCarMsg(HttpServletRequest request,HttpSession session){
		String user = request.getSession().getAttribute("username")+"";
		String number = request.getParameter("number");
		List<Map<String,Object>> carMsg = autoOrderService.getCarMsg(number,user);
		return carMsg;
	}
	/**
	 * 查询门店信息
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/getStore")
	public Object getStore(HttpServletRequest request){
		String user = request.getSession().getAttribute("username")+"";
		List<Map<String,Object>> stroe = autoOrderService.getStroe(user);
		return stroe;
	}
	/**
	 * 查询装配表里的状态为待装配的订单，连接订单表查询。
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWaitAuto")
	public Object getWaitAuto(HttpServletRequest request,HttpSession session){
		String user = request.getSession().getAttribute("username")+"";
		List<Map<String,Object>> waitAuto = autoOrderService.getWaitAuto(user);
		return waitAuto;
	}
	
	/**
	 * 执行装配管理的提交按钮
	 */
	@RequestMapping("/inAuto")
	public String autoOrder(@RequestParam Map paramsMap,Model model,HttpServletRequest request){
		String user = request.getSession().getAttribute("username")+"";
		paramsMap.put("user", user);
		
		
		Map map = new HashMap();
		//通过name获取复选框的id,放到map集合中
		for (int i = 0; i < paramsMap.size(); i++) {
			if(paramsMap.get("order"+i)!=null){
				Object id = paramsMap.get("order"+i);
				map.put("id"+i, id);
			}
		}
		int row = autoOrderService.getAuto(paramsMap,map);
		model.addAttribute("row", row);
		return "redirect:/autoOrder/usePageUtilOrderLisst.do";
	}
	/**
	 * 装配管理页面的订单普通的分页列表
	 * PageUtil使用方法
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/usePageUtilOrderLisst")
	public String usePageUtilOrderLisst(@RequestParam Map paramMap,Model model,HttpServletRequest request){
		String user = request.getSession().getAttribute("username")+"";
		paramMap.put("user", user);
		
		
		//获取分页总数量
		int pageCount = autoOrderService.getPageCount(paramMap);
		int pageSize=5;
		int pageNo=0;
		Object tempPageNo = paramMap.get("pageNo");
		if(tempPageNo==null){
			pageNo=1;
		}else{
			pageNo=Integer.valueOf(tempPageNo+"");
		}
		paramMap.put("pageSize", pageSize);//准备往前台传的每页数量
		paramMap.put("pageNo", pageNo);//从第0页开始
		//分页工具的使用
		String pageString = new PageUtil(pageNo, pageSize, pageCount, request).getPageString();
		model.addAttribute("orderList", autoOrderService.getOrderPage(paramMap));
		//将这个字符串传给前台直接el表达式出来就是分页的结构
		model.addAttribute("pageString", pageString);
		model.addAttribute("paramMap", paramMap);
		
	   return "backStage/order/autoInOrder";	
	}
	/**
	 * 车辆调度的分页列表
	 * PageUtil使用方法
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/backCarOrder")
	public String backCarOrder(@RequestParam Map paramMap,Model model,HttpServletRequest request){
		String user = request.getSession().getAttribute("username")+"";
		paramMap.put("user", user);
		
		
		//获取分页总数量
		int pageCount = autoOrderService.getPageCount(paramMap);
		int pageSize=5;
		int pageNo=0;
		Object tempPageNo = paramMap.get("pageNo");
		if(tempPageNo==null){
			pageNo=1;
		}else{
			pageNo=Integer.valueOf(tempPageNo+"");
		}
		paramMap.put("pageSize", pageSize);
		paramMap.put("pageNo", pageNo);
		//分页工具的使用
		String pageString = new PageUtil(pageNo, pageSize, pageCount, request).getPageString();
		model.addAttribute("orderList", autoOrderService.backCarOrder(paramMap));
		//将这个字符串传给前台直接el表达式出来就是分页的结构
		model.addAttribute("pageString", pageString);
		model.addAttribute("paramMap", paramMap);
		
	   return "backStage/order/backCarOrder";	
	}
	/**
	 * 装配管理页面的订单普通的分页列表
	 * PageUtil使用方法
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/outCarList")
	public String outCar(@RequestParam Map paramMap,Model model,HttpServletRequest request){
		String user = request.getSession().getAttribute("username")+"";
		paramMap.put("user", user);
		
		
		
		//获取分页总数量
		int pageCount = autoOrderService.getPageCount(paramMap);
		int pageSize=3;
		int pageNo=0;
		Object tempPageNo = paramMap.get("pageNo");
		if(tempPageNo==null){
			pageNo=1;
		}else{
			pageNo=Integer.valueOf(tempPageNo+"");
		}
		paramMap.put("pageSize", pageSize);
		paramMap.put("pageNo", pageNo);
		//分页工具的使用
		String pageString = new PageUtil(pageNo, pageSize, pageCount, request).getPageString();
		model.addAttribute("orderList", autoOrderService.getOrderPage(paramMap));
		//将这个字符串传给前台直接el表达式出来就是分页的结构
		model.addAttribute("pageString", pageString);
		model.addAttribute("paramMap", paramMap);
	   return "backStage/order/outCar";	
	}
	/**
	 * 装配管理页面的出库按钮
	 */
	@ResponseBody
	@RequestMapping("/outKu")
	public Object outKu(@RequestParam Map paramsMap){
		int row = autoOrderService.orderOutKu(paramsMap);
		Map map = new HashMap();
		if(row!=0){
			map.put("msg", "1");
		}else{
			map.put("msg", "0");
		}
		return map;
	}
	/**
	 * 装配管理页面的删除按钮
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delOrderByOrderNum")
	public Object delOrderByOrderNum(@RequestParam Map paramsMap){
		int row = autoOrderService.delOrderByOrderNum(paramsMap);
		Map map = new HashMap();
		if(row!=0){
			map.put("msg", "1");
		}else{
			map.put("msg", "0");
		}
		return map;
	}
	/**
	 * 装配管理页面的详情按钮
	 * PageUtil使用方法
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/inCarOrder")
	public String inCarOrder(@RequestParam Map paramMap,Model model,HttpServletRequest request,HttpSession session){
		String str = paramMap.get("orderCount")+"";
		Integer orderCount = Integer.valueOf(str);
		if(orderCount==0){
			return "redirect:/autoOrder/usePageUtilOrderLisst.do";
		}
		//获取分页总数量
		int pageCount = autoOrderService.getPageCount(paramMap);
		int pageSize=3;
		int pageNo=0;
		Object tempPageNo = paramMap.get("pageNo");
		if(tempPageNo==null){
			pageNo=1;
		}else{
			pageNo=Integer.valueOf(tempPageNo+"");
		}
		paramMap.put("pageSize", pageSize);
		paramMap.put("pageNo", pageNo);
		//分页工具的使用
		String pageString = new PageUtil(pageNo, pageSize, pageCount, request).getPageString();
		//后台往前台传的数据
		String user = request.getSession().getAttribute("username")+"";
		paramMap.put("user", user);
		model.addAttribute("orderList", autoOrderService.getInCarOrder(paramMap));
		//将这个字符串传给前台直接el表达式出来就是分页的结构
		model.addAttribute("pageString", pageString);
		model.addAttribute("paramMap", paramMap);
		return "backStage/order/autoOrderByCar";
	}
	/**
	 * 装配管理页面的详情按钮的删除功能
	 * @param carCode
	 * @param orderCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateOrderByCarNum")
	public Object updateOrderByCarNum(String carCode,String orderCode){
		int row = autoOrderService.updateOrderByCarNum(carCode,orderCode);
		Map map = new HashMap();
		if(row==1){
			map.put("msg", "1");
		}else{
			map.put("msg", "0");
		}
		return map;
	}
	/**
	 * 装配管理页面的删除功能
	 * 
	 */
	@ResponseBody
	@RequestMapping("/delAutoSuccCar")
	public Object delAutoSuccCar(String carNumber,int orderCount){
		int row = autoOrderService.delAutoSuccCar(carNumber,orderCount);
		Map map = new HashMap();
		if(row==1){
			map.put("msg", "1");
		}else{
			map.put("msg", "0");
		}
		return map;
	}
	/**
	 * 车辆调度的返程按钮
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/backOrderCar")
	public Object backOrderCar(@RequestParam Map paramsMap){
		int row = autoOrderService.backOrderCar(paramsMap);
		Map map = new HashMap();
		if(row!=0){
			map.put("msg", "1");
		}else{
			map.put("msg", "0");
		}
		return map;
	}
}

