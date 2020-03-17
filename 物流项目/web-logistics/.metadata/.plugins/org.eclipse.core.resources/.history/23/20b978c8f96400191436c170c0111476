package com.aaa.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.dao.WrongOrderDaoImpl;
import com.aaa.mvc.service.OrderService;
import com.aaa.mvc.service.WrongOrderService;
import com.aaa.mvc.util.BaseDao;
import com.aaa.mvc.util.GetUserMap;

@Controller
@RequestMapping("wrong")
public class WrongOrderController {
	@Autowired//依赖注入
	private WrongOrderService wrongOrderService;
	@Autowired
	private HttpSession session;
	@Autowired//依赖注入
	private OrderService orderService;
	
	@RequestMapping("order")
	public String wrongOrder(HttpServletRequest request){
		/*request.setAttribute("order_mailnum",111011);*/
		return "backStage/order/wrongOrder";
	}
	/**
	 * 到添加异常单页面
	 * @return
	 */
	@RequestMapping("orderAdd")
	public String wrongOrderAdd(){
		return "backStage/order/wrongOrderAdd";
	}
	@RequestMapping("orderAdd1")
	public String wrongOrderAdd1(){
		return "backStage/order/wrongOrder1";
	}@RequestMapping("orderAdd2")
	public String wrongOrderAdd2(){
		return "backStage/order/wrongOrder2";
	}@RequestMapping("orderAdd3")
	public String wrongOrderAdd3(){
		return "backStage/order/wrongOrder3";
	}@RequestMapping("orderAdd4")
	public String wrongOrderAdd4(){
		return "backStage/order/wrongOrder4";
	}
	//分割线...................................................
	@ResponseBody
	@RequestMapping("add1")
	public String addWrongOrder(@RequestParam Map paramMap){
		return null;
	}
	
	
	
	/**
	 * 按快递单号查询订单信息去填写异常单
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("/select")
	public String select(@RequestParam Map paramMap,HttpServletRequest request){
		List<Map<String, Object>> page = wrongOrderService.getOrderPage(paramMap);//得到按快递单号返回的List
		request.setAttribute("list", page);
		return "backStage/order/wrongOrderAdd";
	}
	
	/**
	 * 用户分页列表
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/page")
	public Object userPage(@RequestParam Map paramMap){
		Map map = new HashMap();
		//总数量
		map.put("total", wrongOrderService.getPageCount(paramMap));
		//分页查询的结果
	    map.put("rows", wrongOrderService.getPage(paramMap));
		return map;
	}
	/**
	 * 下拉框
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/page1")
	public Object userPage1(String caocuo){
		
		//分页查询的结果
		return new WrongOrderDaoImpl().getXiaLaKuang(caocuo);
	}
	/**
	 * 订单添加操作 
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Object userAdd(@RequestParam Map paramMap){
		int userAdd = wrongOrderService.userAdd(paramMap);
		Map map = new HashMap();
		if(userAdd==0){
		     map.put("showInfo", "添加失败");
		}else{
			  map.put("suc", "true");
			  map.put("showInfo", "添加成功");
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
		int updateOrder = wrongOrderService.updateOrder(id, paramMap);
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
		int deleteOrder = wrongOrderService.deleteOrder(id);
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
	 * 搜索
	 * @param tempOrder_mailnum
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/chaxun")
	public void chaxun(HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.setContentType("text/html");
		Object username = session.getAttribute("username");
		//把登录的用户username变成map去orderservice去查
		Map userMap=new HashMap();
		userMap.put("user", username);
		String tempOrder_mailnum = request.getParameter("order_mailnum");
		PrintWriter out = response.getWriter();
		List<Map<String, Object>> selectMap =orderService.getPage(userMap);
		List<Map<String, Object>> selectMap2 = wrongOrderService.getPage(userMap);
		for (Map<String, Object> map : selectMap){
			if(tempOrder_mailnum.equals(map.get("order_mailnum")+"")){
				out.print("true");
				return;
			}
		}
		for (Map<String, Object> map : selectMap2) {
			if(tempOrder_mailnum.equals(map.get("order_mailnum")+"")){
				out.print("trueOne");
				return;
			}else{//两个数组都没找到就返回FALSE说明没有这个编号
				out.print("false");
			}
		}
	}
}
