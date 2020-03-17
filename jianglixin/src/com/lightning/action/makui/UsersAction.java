package com.lightning.action.makui;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.makui.Users;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.makui.UsersDaoImpl;
import com.lightning.dao.makui.UsersDao;
@Namespace("/Users")
@Result(name="success" ,location="/${target}.jsp",type="redirect")
public class UsersAction extends BaseAction{
	private Users users;
	private UsersDao userdao = new UsersDaoImpl();
	private List tabUsers;
	private List rowUsers;
	private String pass;
	private String indentid;
	//查询订单信息
		@Action(value="insertIndent")
		public String insertIndent(){
			tabUsers=userdao.insertIndent(Integer.parseInt(indentid));
			String strIndent=JSON.toJSONString(tabUsers);
			print(strIndent);
			return null;
		}
		
		//用户唯一性验证
		@Action(value="checkUser")
		public String checkUser(){
			//System.out.println(2);
			boolean flag=true;
			List list=userdao.selectUsers(users);
			if(list!=null&&list.size()>0) {
				flag=false;
			}
			print(flag+"");
			return null;
		}	
		
	//添加用户信息
	@Action(value="insertUsers",results={@Result(location="/before/makui/Userslogin.jsp")})
	public String insertUsers(){
		userdao.insertUsers(users);
		return showUser();
	}
	public String getIndentid() {
		return indentid;
	}




	public void setIndentid(String indentid) {
		this.indentid = indentid;
	}




	private String showUser() {
		tabUsers = userdao.findUsers();
		target="later/makui/showUsers";
		return "success";
	}
	//查询所有的用户信息
	@Action(value="findUsers")
	public String findUsers() {
		List<List> tabUsers = userdao.findUsers();
		print(JSON.toJSONString(tabUsers));
		return null;
	}
	//修改一条用户的信息
	@Action(value="updateUser")
	public String updateUser(){
		userdao.updateUsers(users);
		return showUser();
	}
	//查询一个用户的信息
	@Action(value="findone")
	public String findone(){
		tabUsers=userdao.findOneUsers(users);
		rowUsers=(List) tabUsers.get(0);
		return "findone";
	}
//	@Action(value="delete")
//	public String delete(){
//		userdao.deleteUsers(users);
//		return showUser();
//	}
	/**
	 * 登录验证
	 * @return
	 */
	@Action(value="userslogin",results={@Result(type="redirect" ,location="/${target}")})
	public String userslogin() {
		if(userdao.frontlogin(users)) {
			target="before/front/index.jsp";
			List<List> tab=new ArrayList();
			tab=userdao.findOneUsers(users);
			for(List row:tab) {
				users.setUsers_name(row.get(2).toString());
				users.setUsers_phone(row.get(3).toString());
				users.setUsers_idcard(row.get(4).toString());
				users.setUsers_postcode(Integer.parseInt(row.get(5).toString()));
			}
			
			getSession().put("users",users);
			return "success";
		}else {
			target="before/front/index.jsp";
			return "success";
			
		}
		
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@Action(value="updatepass")
	public String updatepass() {
		users=(Users) getSession().get("users");
		String id=users.getUsers_id();
		userdao.updatepass(pass, id);
		getSession().remove("users");
		return null;
	}

	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public UsersDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}
	public List getTabUsers() {
		return tabUsers;
	}
	public void setTabUsers(List tabUsers) {
		this.tabUsers = tabUsers;
	}
	public List getRowUsers() {
		return rowUsers;
	}
	public void setRowUsers(List rowUsers) {
		this.rowUsers = rowUsers;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
