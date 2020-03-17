package com.lightning.dao.impl.wangjia;

import java.util.List;

import com.lightning.bean.wangjia.Role;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangjia.RoleDao;

public class RoleDaoImpl implements RoleDao{
	//员工与职位的中间表添加方法
	@Override
	public void insertRole(Role role) {
		String sql="insert into role(role_worker,role_post) values(?,?)";
		BaseDao.update(sql, new Object[]{role.getRole_worker(),role.getRole_post()});
	}
	//员工与职位的中间表删除方法
	@Override
	public int deleteRole(Role role) {
		String sql ="delete from role where role_post=?";
		return BaseDao.update(sql, new Object[] {role.getRole_post()});
	}
	//员工与职位的中间表修改方法
	@Override
	public void updateRole(Role role) {
		String sql="update role set role_post=? where role_worker=?";
		BaseDao.update(sql, new Object[] {
				role.getRole_post(),
				role.getRole_worker()});
		
	}
	
	@Override
	public List findOneRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}
	//员工与职位的中间表查询全部方法
	@Override
	public List findRole() {
		String sql="select role_worker,role_post from role";
		
		return BaseDao.query(sql, null);
	}

}
