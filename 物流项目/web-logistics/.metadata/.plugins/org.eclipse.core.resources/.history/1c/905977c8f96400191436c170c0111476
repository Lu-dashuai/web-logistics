package com.aaa.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {
	@Autowired
	StoreService store;
	@RequestMapping("/page")
	public String getPage(Model model,String node,HttpServletRequest request){
		model.addAttribute("node",node);
		return "backStage/store";
	}
	/**
	 * 查询所有门店
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Object userPage(@RequestParam Map paramMap){
		Map map = new HashMap();
		//总数量
		map.put("total", store.getPageCount(paramMap));
		//分页查询的结果
	    map.put("rows", store.getPage(paramMap));
		return map;
	}
	/**
	 * 订单添加操作 
	 * @param paramMap
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/add")
	public void userAdd(@RequestParam Map paramMap,HttpServletResponse response) throws IOException{
		int userAdd = store.storeAdd(paramMap);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		if(userAdd!=0){
		response.getWriter().print("<script>window.parent.parent.location.href=window.parent.parent.location.href; </script>");
		}
	}
	/**
	 * 更改订单
	 * @param id
	 * @throws IOException 
	 */
	@RequestMapping("/update")
	public void updateOrder(int id,@RequestParam Map paramMap,HttpServletResponse response) throws IOException {
		int updateOrder = store.updateStore(id, paramMap);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		if(updateOrder!=0){
		response.getWriter().print("<script>window.parent.parent.location.href=window.parent.parent.location.href; </script>");
		}
	}
	/**
	 * 删除订单
	 * @throws IOException 
	 */
	@RequestMapping("/delete")
	public void deleteOrder(int id,HttpServletResponse response,HttpServletRequest request) throws IOException {
		int deleteOrder = store.deleteStore(id);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			if(deleteOrder!=0){
				//return "redirect:power/storeTree.do";
				response.getWriter().print("<script>window.parent.location.href=window.parent.location.href; </script>");
			}
	}
	/**
	 * 省，市，县插入数据库
	 */
	@RequestMapping("/insert")
	public void insert(@RequestParam Map map){
		store.insert(map);
	}
}
