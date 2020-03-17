package com.aaa.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaa.mvc.entity.StoreTreeNode;
import com.aaa.mvc.entity.TreeNode;
import com.aaa.mvc.util.BaseDao;

/***
 *@className:PowerDaoImpl.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-9上午11:21:04
 *@version:
 */
@Repository
public class PowerDaoImpl implements PowerDao {
	
	@Autowired
	private HttpSession session;

	@Override
	public List<TreeNode> getList() {
		// TODO Auto-generated method stub
		//查询数据
		List<Map<String, Object>> powerMapList = BaseDao.selectMap("select id,name,parentid,state,iconcls,url from tb_power", null);
		//定义返回列表
		List<TreeNode> powerList = new ArrayList<TreeNode>();
		//判断是否为空
		 if(powerMapList!=null&&powerMapList.size()>0){
			 TreeNode treeNode = null;
			 //循环遍历，构造TreeNode对象，加入powerList
			 for(Map powerMap:powerMapList){
				// treeNode = new TreeNode(id, text, parentId, state, iconCls, url);
				 //if (powerMap.get("id") != null && powerMap.get("parentid") != null) {
				 treeNode = new TreeNode(Integer.valueOf(powerMap.get("id")+""), powerMap.get("name")+"",
						 Integer.valueOf(powerMap.get("parentid")+""), powerMap.get("state")+""
						 , powerMap.get("iconcls")+"", powerMap.get("url")+"");
				 //}
				 powerList.add(treeNode);
			 }
		 }
		return powerList;
	}


	@Override
	public List<Map<String, Object>> getById(int powerId) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select id,name,parentid,state,iconcls,url from tb_power where id=?", new Object[]{powerId});
	}

	@Override
	public int update(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_power set name=?,parentid=?,state=?,iconcls=?,url=? where id=?",
				new Object[]{map.get("name"),map.get("parentid"),map.get("state"),
				map.get("iconcls"),map.get("url"),map.get("id")});
	}

	@Override
	public int add(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("insert into tb_power(name,parentid,state,iconcls,url)  values(?,?,?,?,?)",
				new Object[]{map.get("name"),"".equals(map.get("parentid"))?0:map.get("parentid"),map.get("state"),
				map.get("iconcls"),map.get("url")});
	}

	
	/**
	 * 门店权限树
	 */
	@Override
	public List<StoreTreeNode> getStoreList() {
		//查询数据
		List<Map<String, Object>> powerMapList = BaseDao.selectMap("select id,store_name,store_parentid,store_state,store_iconcls,store_url from tb_store", null);
		//定义返回列表
		List<StoreTreeNode> powerList = new ArrayList<StoreTreeNode>();
		//判断是否为空
		 if(powerMapList!=null&&powerMapList.size()>0){
			 StoreTreeNode treeNode = null;
			 //循环遍历，构造TreeNode对象，加入powerList
			 for(Map powerMap:powerMapList){
				// treeNode = new TreeNode(id, text, parentId, state, iconCls, url);
				 //if (powerMap.get("id") != null && powerMap.get("parentid") != null) {
				 treeNode = new StoreTreeNode(Integer.valueOf(powerMap.get("id")+""), powerMap.get("store_name")+"",
						 Integer.valueOf(powerMap.get("store_parentid")+""), powerMap.get("store_state")+""
						 , powerMap.get("store_iconcls")+"", powerMap.get("store_url")+"");
				 //}
				 powerList.add(treeNode);
			 }
		 }
		return powerList;
	}
	/**
	 * 根据员工获得员工的权限数据
	 */
	@Override
	public List<TreeNode> getCheckedList(String roleId) {
		// TODO Auto-generated method stub
		        //查询数据
				List<Map<String, Object>> powerMapList = BaseDao.selectMap("select id,name,parentid,state,iconcls,url from tb_power", null);
				//查询该角色拥有的所有权限
				List<Map<String, Object>> powersByRoleId = BaseDao.selectMap("select powerId from tb_admin_power where roleId=?", new Object[]{roleId});
				//定义返回列表
				List<TreeNode> powerList = new ArrayList<TreeNode>();
				//判断是否为空
				 if(powerMapList!=null&&powerMapList.size()>0){
					 TreeNode treeNode = null;
					 //循环遍历，构造TreeNode对象，加入powerList
					 for(Map powerMap:powerMapList){
						 //判断是否为空
						 if(powersByRoleId!=null&&powersByRoleId.size()>0){
							 for(Map powers:powersByRoleId){
								 //如果用户该全选，让节点checked=true
								 if(powers.get("powerId").toString().equals(powerMap.get("id").toString())){
									 powerMap.put("checked",true);
									 break;
								 }
							 }   
						 }
						// treeNode = new TreeNode(id, text, parentId, state, iconCls, url);
						 treeNode = new TreeNode(Integer.valueOf(powerMap.get("id")+""), powerMap.get("name")+"",
								 Integer.valueOf(powerMap.get("parentid")+""), "open"
								 , powerMap.get("iconcls")+"", powerMap.get("url")+"",powerMap.get("checked")==null?null:powerMap.get("checked")+"");
						 powerList.add(treeNode);
					 }
				 }
			return powerList;
	}
	/**
	 * 根据用户id来获取权限
	 */
	@Override
	public List<TreeNode> getPowerList() {
		// TODO Auto-generated method stub
				Object empno=session.getAttribute("username");
				//查询数据
				List<Map<String, Object>> powerMapList = BaseDao.selectMap("select id,name,parentid,state,iconcls,url from tb_power  where id in(select powerId from tb_admin_power where roleId=(select roleId from tb_admin where username=?))", 
						new Object[]{empno});
				//定义返回列表
				List<TreeNode> powerList = new ArrayList<TreeNode>();
				//判断是否为空
				 if(powerMapList!=null&&powerMapList.size()>0){
					 TreeNode treeNode = null;
					 //循环遍历，构造TreeNode对象，加入powerList
					 for(Map powerMap:powerMapList){
						// treeNode = new TreeNode(id, text, parentId, state, iconCls, url);
						 treeNode = new TreeNode(Integer.valueOf(powerMap.get("id")+""), powerMap.get("name")+"",
								 Integer.valueOf(powerMap.get("parentid")+""), powerMap.get("state")+""
								 , powerMap.get("iconcls")+"", powerMap.get("url")+"");
						 powerList.add(treeNode);
					 }
				 }
				return powerList;
	}
	/**
	 * 根据权限id删除权限
	 */
	@Override
	public int deletePowerById(String powerId) {
		Integer powerId1 = Integer.valueOf(powerId);
		//删除id的权限
		BaseDao.insertAndUpdateAndDelete("delete from tb_power where id=?", new Object[]{powerId1});
		//删除id的子权限
		BaseDao.insertAndUpdateAndDelete("delete from tb_power where parentId=?", new Object[]{powerId1});
		return 1;
	}
}
