package com.lightning.dao.impl.makui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lightning.bean.makui.Users;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.factory.ConnectionFactory;
import com.lightning.dao.makui.UsersDao;


public class UsersDaoImpl implements UsersDao{
	//查询所有用户
	@Override
	public List findUsers() {
		String sql="select users_id,users_password,users_name,users_phone,users_idcard,users_postcode from users";
		return BaseDao.queryMap(sql,null);
	}
	//添加一个用户
	@Override
	public void insertUsers(Users users) {
		String sql="insert into users values(?,?,?,?,?,?)";
		BaseDao.update(sql, new Object[]{users.getUsers_id(),users.getUsers_password(),users.getUsers_name(),users.getUsers_phone(),users.getUsers_idcard(),users.getUsers_postcode()});
	}
	//删除一个用户
	@Override
	public void deleteUsers(Users users) {
		String sql="delete from users where users_id=?";
		BaseDao.update(sql, new Object[]{users.getUsers_id()});
	}
	//查询一个用户
	@Override
	public List findOneUsers(Users users) {
		String sql="select users_id,users_password,users_name,users_phone,users_idcard,users_postcode from users where users_id=?";
		return BaseDao.query(sql, new Object[]{users.getUsers_id()});
	}
	//修改一个用户信息
	@Override
	public void updateUsers(Users users) {
		String sql="update users set users_password=?,users_name=?,users_phone=?,users_phone=?,users_idcard=?,users_postcode=? where users_id=?";
		BaseDao.update(sql, new Object[]{users.getUsers_password(),users.getUsers_name(),users.getUsers_phone(),users.getUsers_idcard(),users.getUsers_postcode(),users.getUsers_id()});
	}
	//登录时账号密码是否在数据库存在
	public boolean frontlogin(Users users) {
		boolean flag = false;
		String sql="select * from users where users_id=? and users_password=?";
		List usersList=BaseDao.query(sql, new Object[] {users.getUsers_id(),users.getUsers_password()});
		if(usersList!=null && usersList.size()>0) {
			flag=true;
		}
		return flag;
	}
	//查询订单信息
	public List insertIndent(int indentid) {
		String sql="select indent.indent_id,indent.indent_time,situation.situation_name,time.time_start,time.time_end from indent  " + 
				" left join situation on indent.indent_situation=situation.situation_id " + 
				" left join comego on comego.comego_indent=indent.indent_id " + 
				" left join car on comego.comego_car=car.car_id " + 
				" left join time on time.time_car_id=car.car_id " + 
				" where indent.indent_id=? ";
		List usersList=BaseDao.queryMap(sql, new Object[] {indentid});
		return usersList;
	}
	
	
	@Override
	public void updatepass(String pass,String users_id) {
		String sql="update users set users_password=? where users_id=? ";
		BaseDao.update(sql, new Object[] {pass,users_id});
	}
	
	
	
	
	//根据输入的用户名以及密码进行查询此用户是否已存在
	@Override
	public List selectUsers(Users users) {
		// TODO Auto-generated method stub
		String sql="select * from users where users_id=?";
		List list=BaseDao.query(sql, new Object[] {users.getUsers_id()});
		return list;
	}

	
}
