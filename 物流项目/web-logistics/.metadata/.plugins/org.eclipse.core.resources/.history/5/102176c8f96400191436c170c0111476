package com.aaa.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.SelectUserService;

@Controller
@RequestMapping("/user")
public class SelectUserController {
	@Autowired //依赖注入
	private SelectUserService selectUserService;
	
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
		map.put("total", selectUserService.getPageCount(paramMap));
		//分页查询的结果
	    map.put("rows", selectUserService.getPage(paramMap));
		return map;
	}
	
	/**
	 * 用户添加操作 
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Object userAdd(@RequestParam Map paramMap){
		int userAdd = selectUserService.userAdd(paramMap);
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
	 * 更改用户
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object updateUser(int id,@RequestParam Map paramMap) {
		int updateOrder = selectUserService.userUpdate(paramMap);
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
	 * 删除用户
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteUser(int id) {
		int deleteUser = selectUserService.userDel(id);
		Map map = new HashMap();
		if(deleteUser==0) {
			map.put("showInfo", "删除失败");
		} else {
			map.put("suc", "true");
			map.put("showInfo", "删除成功");
		}
		return map;
		
	}
	
}
