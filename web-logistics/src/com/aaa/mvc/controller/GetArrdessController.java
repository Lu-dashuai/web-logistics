package com.aaa.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.GetArrdessService;

@Controller
@RequestMapping("/getArr")
public class GetArrdessController {
	@Autowired
	private GetArrdessService getArrdessService;
	
	/**
	 * 获取所有省
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getP")
	public Object getProvince(){
		List<Map<String, Object>> provinceList = getArrdessService.getProvince();
		return provinceList;
	}
	/**
	 * 获取省
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getP1")
	public Object getProvince1(){
		List<Map<String, Object>> provinceList = getArrdessService.getProvince1();
		return provinceList;
	}
	/**
	 * 获取市
	 */
	@ResponseBody
	@RequestMapping("/getC")
	public Object getCity(String provinceId){
		List<Map<String, Object>> cityList = getArrdessService.getCity(provinceId);
		return cityList;
	}
	/**
	 * 获取市
	 */
	@ResponseBody
	@RequestMapping("/getC1")
	public Object getCity1(String provinceId){
		List<Map<String, Object>> cityList = getArrdessService.getCity1(provinceId);
		return cityList;
	}
	/**
	 * 获取区
	 */
	@ResponseBody
	@RequestMapping("/getA")
	public Object getArea(String cityId){
		List<Map<String, Object>> areaList = getArrdessService.getArea(cityId);
		return areaList;
	}
	/**
	 * 获取区
	 */
	@ResponseBody
	@RequestMapping("/getA1")
	public Object getArea1(String cityId){
		List<Map<String, Object>> areaList = getArrdessService.getArea1(cityId);
		return areaList;
	}
}
