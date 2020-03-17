		package com.aaa.mvc.controller;
		
		import java.util.HashMap;
		import java.util.Map;
		
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Controller;
		import org.springframework.ui.Model;
		import org.springframework.web.bind.annotation.RequestMapping;
		import org.springframework.web.bind.annotation.RequestParam;
		import org.springframework.web.bind.annotation.ResponseBody;
		
		import com.aaa.mvc.service.EmpService;
		
		@Controller
		@RequestMapping("/emp")
		public class EmpController {
			@Autowired
			EmpService empService;
			/**
			 * 登录到emp.jsp界面
			 * @param model
			 * @return
			 */
			@RequestMapping("/empList")
			public String empCheck(Model model){
				return "backStage/emp";
			}
			/**
			 * 跳转到角色页面
			 */
			@RequestMapping("/role")
			public String role(Model model){
				return "backStage/role";
			}
		
		/**
		 * 车辆信息分页列表
		 * @param paramMap
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/page")
		public Object empPage(@RequestParam Map paramMap){
			Map map = new HashMap();
			//总数量
			map.put("total", empService.getPageCount(paramMap));
			//分页查询的结果
		    map.put("rows", empService.getPage(paramMap));
			return map;
		}
		
		/**
		 * 车辆信息添加操作 
		 * @param paramMap
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/add")
		public Object empAdd(@RequestParam Map paramMap){
			int empAdd = empService.empAdd(paramMap);
			Map map = new HashMap();
			if(empAdd==0){
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
		public Object empDel(String id){
			//调用服务层
			int empDel=empService.empDel(id);
			Map map = new HashMap();
			if(empDel==0){//失败
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
		public Object empUpdate(@RequestParam Map paramMap){
			Map map=new HashMap();
			int empUpdate=empService.empUpdate(paramMap);
			if(empUpdate==0){
				map.put("showInfo","更新失败");
			}else{
				map.put("suc","true");
				map.put("showInfo", "更新成功");
			}
			return map;
		}
		/**
		 * 保存角色权限关联
		 * @param paramMap
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/saveRoleAndPower")
			public Object saveRoleAndPower(@RequestParam Map paramMap){
				//保存
				int rs = empService.saveRoleAndPower(paramMap);
				Map map = new HashMap();
				if(rs==0){
				     map.put("showInfo", "添加失败");
				}else{
					  map.put("suc", "true");
					  map.put("showInfo", "添加成功");
				} 
				return map;
			}
		/**
		 * 查询角色列表
		 */
		@ResponseBody
		@RequestMapping("/roleList")
		public Object rolePage(@RequestParam Map paramMap){
			Map map = new HashMap();
			//总数量
			map.put("total", empService.getRolePageCount(paramMap));
			//分页查询的结果
		    map.put("rows", empService.getRolePage(paramMap));
			return map;
		}
		}
