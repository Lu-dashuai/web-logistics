package com.aaa.mvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.CarService;
/**
 * 车辆管理
 * @author 子歌
 *
 */

@Controller
@RequestMapping("/car")
public class CarController {
	//依赖注入 服务层
		@Autowired
		private CarService carService;
		@RequestMapping("/carCheck")
		public String carCheck(Model model){
			return "backStage/carCheck";
		}
	
	/**
	 * 车辆信息分页列表
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/page")
	public Object carPage(@RequestParam Map paramMap){
		Map map = new HashMap();
		//总数量
		map.put("total", carService.getPageCount(paramMap));
		//分页查询的结果
	    map.put("rows", carService.getPage(paramMap));
		return map;
	}
	
	/**
	 * 车辆信息添加操作 
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Object carAdd(@RequestParam Map paramMap){
		int carAdd = carService.carAdd(paramMap);
		Map map = new HashMap();
		if(carAdd==0){
		     map.put("showInfo", "添加失败");
		}else{
			  map.put("suc", "true");
			  map.put("showInfo", "添加成功");
		} 
		return map;
	}
	//用户更新
	/**
	 * 用户删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Object carDel(String id){
		//调用服务层
		int carDel=carService.carDel(id);
		Map map = new HashMap();
		if(carDel==0){//失败
		     map.put("errorMsg", "删除失败");
		}else{//成功
			  map.put("success", "true");
		} 
		return map;
	}
	/**
	 * 用户更新
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public Object carUpdate(@RequestParam Map paramMap){
		Map map=new HashMap();
		int carUpdate=carService.carUpdate(paramMap);
		if(carUpdate==0){
			map.put("showInfo","更新失败");
		}else{
			map.put("suc","true");
			map.put("showInfo", "更新成功");
		}
		return map;
	}
}
