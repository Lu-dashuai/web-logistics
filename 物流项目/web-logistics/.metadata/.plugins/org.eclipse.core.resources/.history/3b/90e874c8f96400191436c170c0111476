package com.aaa.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.CarService;
import com.aaa.mvc.service.RepairCarService;

/***
 *@className:WaitRepairController.java
 *@discripton:
 *@author:dujihu
 *@createTime:2018-10-11下午11:11:47
 *@version:1.0
 */
@Controller
@RequestMapping("/repair")
public class RepairCarController {
	@Autowired
	private RepairCarService repairCarService;
	@Autowired
	private CarService carService;
	
	/**
	 * 获取待维修车辆列表
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allCar")
	public Object allCar(@RequestParam Map paramMap){
		Map map = new HashMap();
		//总数量
		map.put("total", repairCarService.getPageCount(paramMap));
		//分页查询结果
		map.put("rows",repairCarService.getPage(paramMap) );
		return map;
	}
	/**
	 * 访问等待维修车辆页面
	 * @return
	 */
	@RequestMapping("/toWaitCar")
	public String toWaitCar(){
		
		return "repair_car/waitRepairCar";
	}
	/**
	 * 访问维修人员选择页面
	 * @return
	 */
	@RequestMapping("/toCheckMan")
	public String toCheckMan(HttpServletRequest request){
		request.setAttribute("list", repairCarService.getRepairMan());
		return "repair_car/repairman";
	}
	/**
	 * 访问司机核实界面
	 * @return
	 */
	@RequestMapping("/toDriverVerify")
	public String toDriverVerify(){
		
		return "repair_car/driverVerify";
	}
	/**
	 * 访问维修历史页面
	 * @return
	 */
	@RequestMapping("/toRecord")
	public String toRecord(){
		
		return "repair_car/Record";
	}
	/**
	 * 访问维修历史页面
	 * @return
	 */
	@RequestMapping("/toAffirm")
	public String toAffirm(){
		
		return "repair_car/repairmanAffirm";
	}
	/**
	 * 访问维修费用查询页面
	 * @return
	 */
	@RequestMapping("/toCost")
	public String toRepairCost(){
		
		return "repair_car/repairCost";
	}
	/**
	 * 访问维修费用支付页面
	 * @return
	 */
	@RequestMapping("/toPayCost")
	public String toPayCost(){
		
		return "repair_car/payRepairCost";
	}
	
	/**
	 * 删除表
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete(Integer id){
		int result = repairCarService.delete(id);
		Map map = new HashMap();
		if(result==0){
			map.put("msg", "删除失败");
			 return map;
		}else{
			 map.put("msg", "删除成功");
			 return map;
		}
	}
	/**
	 * 添加车辆 
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Object addUser(@RequestParam Map paramMap){
		int result = repairCarService.add(paramMap);
		Map map = new HashMap();
		if(result==0){
			map.put("msg", "添加失败");
			return  map;
		}else{
			map.put("msg", "添加成功");
			return  map;
		}
		
	}
	/**
	 * 查询车辆信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allCarDetails")
	public Object getAllCar(){
		return 	carService.select();
	}
	/**
	 * 通过车牌号查询车辆信息
	 * @param car_driver_papers
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getByNum")
	public Object getCarByNum(String car_driver_papers){
		Map map = new HashMap();
		map.put("car", repairCarService.getListByCarNum(car_driver_papers).get(0));
		 return map;
	}
	/**
	 * 通过维修表的id查询所有信息
	 * @param service_record_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectById")
	public Object getCarById(Integer service_record_id){
		return repairCarService.getListById(service_record_id).get(0);
	}
	
	/**
	 * 修改维修车辆信息
	 * @param paramMap
	 * @param service_record_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object updateCar(@RequestParam Map paramMap,Integer service_record_id){
		int result = repairCarService.update(paramMap, service_record_id);
		Map map = new HashMap();
		if(result==0){
			map.put("msg", "修改失败");
			return  map;
		}else{
			map.put("msg", "修改成功");
			return  map;
		}
	}
	/**
	 * 通过维修表的id修改维修车辆的维修状态
	 * @param service_record_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateService_State")
	public Object updateService_State(Integer service_record_id,String val){
		int result = repairCarService.updateById(service_record_id,val);
		Map map = new HashMap();
			if(result==0){
				if(val.equals("提交")||val.equals("noPro")||val.equals("havePro")){
				 	map.put("msg", "提交失败");
				}
				if(val.equals("撤回")){
					map.put("msg", "撤回失败");
				}
				if(val.equals("分配")){
					map.put("msg", "分配失败");
				}
				if(val.equals("自行维修")){
					map.put("msg", "自行维修提交失败");
				}
				return map;
			}else{
				if(val.equals("提交")||val.equals("noPro")||val.equals("havePro")){
					map.put("msg", "提交成功");
				}
				if(val.equals("撤回")){
					 map.put("msg", "撤回成功");
				}
				if(val.equals("分配")){
					 map.put("msg", "分配成功");
				}
				if(val.equals("自行维修")){
					 map.put("msg", "自行维修提交成功");
				}
				return map;
			}
	}
	/**
	 * 获得维修人员
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/getRepairMan")
	public Object getRepairMan(){
		//List<Map<String,Object>> list = repairCarService.getRepairMan();
		return repairCarService.getRepairMan();
	}*/
	
	@ResponseBody
	@RequestMapping("/updateEmpid")
	public Object updateEmpid(@RequestParam Map map,Integer id){
		String name = (String) map.get("empids");
		int result = repairCarService.updateEmpid(id, name);
		if(result==0){
			map.put("msg", "选择失败");
			return  map;
		}else{
			map.put("msg", "选择成功");
			return  map;
		}
	}
	/**
	 * 获取车辆维修历史列表
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allCarHistory")
	public Object allCarHistory(@RequestParam Map paramMap){
		
		Map map = new HashMap();
		//总数量
		map.put("total", repairCarService.getHistoryPageCount(paramMap));
		//分页查询结果
		map.put("rows",repairCarService.getHistoryPage(paramMap) );
		return map;
	}
	@ResponseBody
	@RequestMapping("/savehistory")
	public Object saveHistory(@RequestParam Map paramMap){
		
		int result = repairCarService.saveHis(paramMap);
		Map map = new HashMap();
		if(result==0){
			map.put("msg", "保存失败");
			return  map;
		}else{
			map.put("msg", "保存成功");
			return  map;
		}
	}
	/**
	 * 获取维修历史信息
	 * @param service_record_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectHisById")
	public Object getHisById(@RequestParam Map map){
		return repairCarService.getHistoryPage(map).get(0);
	}
}
