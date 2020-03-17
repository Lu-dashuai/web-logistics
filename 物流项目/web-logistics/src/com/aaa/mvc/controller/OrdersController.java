package com.aaa.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.OrdersService;


@Controller
@RequestMapping("/orderstatistic")
public class OrdersController {
@Autowired
private OrdersService orderService;
@ResponseBody  //让该方法的返回值为json  相当于servlet  response.getWrite().print(json)
@RequestMapping("/page")
public Object ordersList(@RequestParam Map paramMap){
	Map map =new HashMap();
	//总数量
			map.put("total", orderService.getPageCount(paramMap));
			//分页查询的结果
		    map.put("rows", orderService.getPage(paramMap));
	return map;
}
	/**
	 * 模拟数据
	 * @return
	 */
@ResponseBody  
@RequestMapping("/ordercharts")
	public Object getOrderECharts(String province,String city){
	
		return orderService.getOrderECharts(province,city);
	}

}
