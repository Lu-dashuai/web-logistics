package com.aaa.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.FinanceService;



/***
 *@className:UserController.java
 *@discripton:
 *@author:zz
 *@createTime:2018-9-30上午10:57:41
 *@version:
 */
@Controller
@RequestMapping("/finance")
public class FinanceController {

	//依赖注入 服务层
	@Autowired
	private FinanceService financeService;
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
		map.put("total", financeService.getPageCount(paramMap));
		//分页查询的结果
	    map.put("rows", financeService.getPage(paramMap));
	    return map;
	}
	/**
	 * 财务统计列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")  //窄化映射请求配置
    public Object userList(){
    	/*ModelAndView modelAndView = new ModelAndView();
    	//设置逻辑视图名
		modelAndView.setViewName("finance/finance");
		//绑定数据
		modelAndView.addObject("financeList", financeService.getFinanceCount());*/
		List<Map<String, Object>> financeCount = financeService.getFinanceCount();
		return financeCount;
    }
}
