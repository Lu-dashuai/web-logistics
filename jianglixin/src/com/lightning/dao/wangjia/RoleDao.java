package com.lightning.dao.wangjia;

import java.util.List;

import com.lightning.bean.wangjia.Role;



public interface RoleDao {
	void insertRole(Role role);//添加数据
	int deleteRole(Role role);//删除数据
	void updateRole(Role role);//修改
	List findOneRole(Role role);//查找一条数据  为了  修改而使用
	List findRole();//查询所有
}
