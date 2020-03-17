package com.aaa.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa.mvc.service.AdminService;
import com.aaa.mvc.service.IndexService;
//进入登陆界面地址栏输入：localhost:8080/web-logistics/admin/login.do
@Controller
@RequestMapping("/admin")//过滤器不拦截
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private IndexService indexService;
	/**
	 * 获取登陆界面的账号密码和后台核对
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/ifLogin")
	public String adminLogin(String username, Model model,String password, HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//获取数据库用户集合
		List<Map<String, Object>> list = adminService.adminLogin();
		for (Map<String, Object> map : list) {
			if((map.get("username")+"").equals(username)&&(map.get("password")+"").equals(password)){
				//正确的时候把用户名放入session
				session.setAttribute("username", username);
				
				Object user = request.getSession().getAttribute("username");
				model.addAttribute("empList", indexService.getEmpMsg(user));
				//重定向到index页面
				return "forward:/index.jsp";
			}
		}
				//不正确跳到登陆界面
				return "backStage/login";
	}
	
	
	/**
	 * 
	 * 进入登陆界面
	 * @param model
	 * @return
	 */
	//第一种情况，输入/admin/login.do不拦截，直接进入登陆界面。
	//进入登陆界面后，用户名密码填写正确，点击提交，进入admin/ifLogin.do，不拦截，判断用户名密码正确，
	//进入首页
	//点击提交，进入admin/ifLogin.do，不拦截，判断密码错误
	//进入登陆界面
	@RequestMapping("/login")
	public String Login(Model model) {
		return "backStage/login";
	}
	
}
