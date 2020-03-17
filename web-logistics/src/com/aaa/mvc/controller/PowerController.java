package com.aaa.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.entity.StoreTreeNode;
import com.aaa.mvc.entity.TreeNode;
import com.aaa.mvc.service.PowerService;

/***
 *@className:PowerController.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-9上午11:53:50
 *@version:
 */
@Controller
@RequestMapping("/power")//进入拦截器
public class PowerController {

	@Autowired
	private PowerService powerService;
	
	/**
	 * 权限树json数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/tree")
	public Object powerTree(){
		return powerService.getList();
	}
	/**
	 * 门店权限树返回的json数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/storeTree1")
	public Object storePowerTree(){
		List<StoreTreeNode> storeList = powerService.getStoreList();
		return storeList;
	}
	/**
	 * 权限树json数据(选择)
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkedTree")
	public Object checkedTree(String roleId){
		List<TreeNode> checkedList = powerService.getCheckedList(roleId);
		
		return checkedList;
	}
	/**
	 * 权限树json数据(根据登陆不同，展示权限菜单不同)
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/powerTree")
	public Object powerListTree(){
		return powerService.getPowerList();
	}
	/**
	 * 输入/power/index.do进入拦截器
	 * 跳转权限首页
	 * @return
	 */
	//第二种情况，直接输入/power/index.do，进拦截器，此时无用户名密码，进入admin/login.do不拦截，直接跳入登陆界面。
	@RequestMapping("/index")
	public String toIndex(Model model) {
		return "   power/index";
	}
	/**
	 * 进入添加订单页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertOrder")
	public String toOpenOrder(Model model) {
		return "backStage/order/insertOrder";
	}
	/**
	 * 进入查看订单页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/lookOrder")
	public String lookOrder(Model model) {
		return "backStage/order/lookOrder";
	}
	/**
	 * 进入审核订单页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/checkOrder")
	public String checkOrder(Model model) {
		return "backStage/order/checkOrder";
	}
	/**
	 * 进入我的订单页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/inkuOrder")
	public String inkuOrder(Model model) {
		return "backStage/order/inkuOrder";
	}
	/**
	 * 进入装配管理装配框页面
	 */
	@RequestMapping("/autoOrder")
	public String autoOrder(Model model) {
		return "backStage/order/autoOrder";
	}
	/**
	 * 进入装配管理页面
	 */
	@RequestMapping("/autoInOrder")
	public String autoInOrder(Model model) {
		return "backStage/order/autoInOrder";
	}
	
	/**
	 * 进入装配管理页面的添加物品页面
	 */
	@RequestMapping("/autoOrders")
	public String autoOrder1(Model model) {
		return "backStage/order/autoOrder";
	}
	/**
	 * 进入装配管理页面的详情页面
	 */
	@RequestMapping("/autoOrderByCar")
	public String autoOrderByCar(Model model) {
		return "backStage/order/autoOrderByCar";
	}
	/**
	 * 进入装配管理页面的详情页面
	 */
	@RequestMapping("/outCar")
	public String outCar(Model model) {
		return "backStage/order/outCar";
	}
	/**
	 * 进入门店管理页面
	 */
	@RequestMapping("storeTree")
	public String store(Model model) {
		return "power/storeTree";
	}
	/**
	 * 权限菜单添加
	 */
	@RequestMapping("/add1")
	public String powerAdd(Model model) {
		return "power/add";
	}
		/**
		 * 权限菜单更新删除
		 */
		@RequestMapping("/update1")
		public String powerUpdateAndDelete(Model model) {
			return "power/update";
		}
		/**
		 * 权限菜单更新删除
		 */
		@RequestMapping("/update2")
		public String update(Model model) {
			return "power/update1";
		}
	
	
		/**
		 * 去更新权限树
		 * @param powerId
		 * @return
		 */
		@RequestMapping("/toUpdate")
		public String toUpdate(Integer powerId,Model model){
			model.addAttribute("power", powerService.getById(powerId));
			return "power/update1";
		}
		/**
		 * 权限菜单修改
		 * @param paramMap
		 * @param response
		 * @throws IOException
		 */
		@RequestMapping("/update")
		public void update(@RequestParam Map paramMap,HttpServletResponse response) throws IOException{
			int update = powerService.update(paramMap);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			if(update==-1)
				response.getWriter().print("修改失败！");
			else
				response.getWriter().print("<script>window.parent.parent.location.href=window.parent.parent.location.href; </script>");	
		}
		
		/**
		 * 权限菜单修改
		 * @param paramMap
		 * @param response
		 * @throws IOException
		 */
		@RequestMapping("/add")
		public void add(@RequestParam Map paramMap,HttpServletResponse response) throws IOException{
			int update = powerService.add(paramMap);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			if(update==-1)
				response.getWriter().print("添加失败！");
			else
				response.getWriter().print("<script>window.parent.location.href=window.parent.location.href; </script>");	
		}
		/**
		 * 权限菜单删除
		 * @param powerId
		 * @throws IOException 
		 */
		@RequestMapping("/delete")
		public void delete(String powerId,HttpServletResponse response) throws IOException{
		int delete=	powerService.deletePowerById(powerId);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print("<script>window.parent.parent.location.href=window.parent.parent.location.href; </script>");	
		}
		/**
		 * 进入目的地站入库
		 */
		@RequestMapping("/overStore")
		public String overStore(Model model) {
			return "backStage/order/overStoreOrder";
		}
		/**
		 * 进入进入前台订单
		 */
		@RequestMapping("/forword")
		public String forword(Model model) {
			return "backStage/order/forWordOrder";
		}
		/**
		 * 进入财务页面
		 */
		@RequestMapping("/finance")
		public String finance(Model model) {
			return "finance/finance";
		}
		/**
		 * 进入统计页面
		 */
		@RequestMapping("/echarts")
		public String echarts(Model model) {
			return "statisticsorder/echarts";
		}
		/**
		 * 进入统计页面
		 */
		@RequestMapping("/order")
		public String order(Model model) {
			return "statisticsorder/order";
		}
	
}
