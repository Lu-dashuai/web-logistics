package com.aaa.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.OrderService;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired//依赖注入
	private OrderService orderService;
	
	/**
	 * 用户分页列表
	 * 查询所有状态的订单
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/page")
	public Object userPage(@RequestParam Map paramMap,HttpServletRequest req){
		Object user = req.getSession().getAttribute("username");
		paramMap.put("user", user);
		Map map = new HashMap();
		//总数量
		map.put("total", orderService.getPageCount(paramMap));
		//分页查询的结果
	    map.put("rows", orderService.getPage(paramMap));
		return map;
	}
	@ResponseBody
	@RequestMapping("/orderList")
	public Object list(@RequestParam Map paramMap){
		List<Map<String,Object>> list = orderService.getPage(paramMap);
		return list;
	}
/*	*//**
	 * 订单审核中的分页查询
	 * 只查询状态为1的订单，1为待审核
	 * @param paramMap
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/checkPage")
	public Object checkUserPage(@RequestParam Map paramMap){
		Map map = new HashMap();
		//总数量
		map.put("total", orderService.getPageCount(paramMap));
		//分页查询的结果
	    map.put("rows", orderService.getPage(paramMap));
		return map;
	}*/
	/**
	 * 订单添加操作 
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Object userAdd(@RequestParam Map paramMap){
		int userAdd = orderService.userAdd(paramMap);
		//String order_mailnum="";
		Map map = new HashMap();
		//检查订单号唯一性方法；
		//String checkMailnum = checkMailnum(paramMap);
		//map.put("msg", checkMailnum);
		if(userAdd==0){
		     map.put("showInfo", "添加失败");
		}else{
			  map.put("suc", "true");
			  map.put("showInfo", "添加成功");
		} 
		return map;
	}
	/**
	 * 检查订单号唯一性
	 * @param paramMap
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/checkMailnum")
	public Object checkMailnum(@RequestParam Map paramMap) {
		//String order_mailnum;
		//查询所有的信息
		Map map = new HashMap();
		int rows = orderService.checkMailnum(paramMap);
		if(rows==1){
			map.put("msg", "false");
		}else{
			map.put("msg", "true");
		}
		return map;
	}
	/**
	 * 更改订单
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object updateOrder(int id,@RequestParam Map paramMap) {
		int updateOrder = orderService.updateOrder(id, paramMap);
		Map map = new HashMap();
		if(updateOrder==0) {
			map.put("showInfo", "更改失败");
		} else {
			 map.put("suc", "true");
			 map.put("showInfo", "更改成功");
		}
		return map;
	}
	
	/**
	 * 删除订单
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteOrder(int id) {
		int deleteOrder = orderService.deleteOrder(id);
		Map map = new HashMap();
		if(deleteOrder==0) {
			map.put("showInfo", "删除失败");
		} else {
			map.put("suc", "true");
			map.put("showInfo", "删除成功");
		}
		return map;
	}
	/**
	 * 审核通过页面的通过方法
	 */
	@ResponseBody
	@RequestMapping("/passOrder")
	public Object passOrder(String idsStr) {
		//int deleteOrder = orderService.deleteOrder(id);
		
		int passOrder = orderService.passOrder(idsStr);
		Map map = new HashMap();
		if(passOrder==0) {
			map.put("showInfo", "请选中一行");
		} else {
			map.put("suc", "true");
			map.put("showInfo", "审核通过成功");
		} 
			
		return map;
	}
	
	/**
	 * 审核通过页面的退单方法
	 */
	@ResponseBody
	@RequestMapping("/backOrder")
	public Object backOrder(String idsStr) {
		int backOrder = orderService.backOrder(idsStr);
		Map map = new HashMap();
		if(backOrder==0) {
			map.put("showInfo", "请选中一行");
		} else {
			map.put("suc", "true");
			map.put("showInfo", "退单成功");
		}
		return map;
	}
	/**
	 * 订单入库页面的入库方法
	 */
	@ResponseBody
	@RequestMapping("/inkuOrder")
	public Object inkuOrder(String idsStr,HttpServletRequest req) {
		//int deleteOrder = orderService.deleteOrder(id);
		Object user = req.getSession().getAttribute("username");
		int inkuOrder = orderService.inkuOrder(idsStr,user);
		Map map = new HashMap();
		if(inkuOrder==0) {
			map.put("showInfo", "请选中一行");
		} else {
			map.put("suc", "true");
			map.put("showInfo", "入库通过成功");
		}
		return map;
	}
	/**
	 * 订单入库页面的到达目的地方法
	 */
	@ResponseBody
	@RequestMapping("/overStoreOrder")
	public Object overStoreOrder(String idsStr,HttpServletRequest req) {
		//int deleteOrder = orderService.deleteOrder(id);
		Object user = req.getSession().getAttribute("username");
		int inkuOrder = orderService.overStoreOrder(idsStr,user);
		Map map = new HashMap();
		if(inkuOrder==0) {
			map.put("showInfo", "请选中一行");
		} else {
			map.put("suc", "true");
			map.put("showInfo", "进入目的地的站点成功");
		}
		return map;
	}
	/**
	 * 添加菜单查询省份
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/adr")
	public Object getProvince(){
		List<Map<String,Object>> adr = orderService.getAdr();
		return adr;
	}
	/**
	 * 添加订单查询用户门店
	 */
	@ResponseBody
	@RequestMapping("/getUserState")
	public Object getUserState(HttpServletRequest request){
		Object user = request.getSession().getAttribute("username");
		List<Map<String,Object>> storeList = orderService.getUserState(user);
		String store = storeList.get(0).get("store")+"";
		Map map = new HashMap();
		map.put("store", store);
		return map;
	}
	
	/**
	 * 查询门店
	 * @return ......
	 */
	@ResponseBody
	@RequestMapping("/getStore")
	public Object getStore() {
		List<Map<String,Object>> storeList = orderService.getStore(); 
		return storeList;
	}

}
