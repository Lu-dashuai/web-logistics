package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import com.aaa.mvc.entity.StoreTreeNode;
import com.aaa.mvc.entity.TreeNode;

/***
 *@className:PowerService.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-9上午11:31:24
 *@version:
 */
public interface PowerService {

	/**
	 * 获取权限数据
	 * @return
	 */
	List<TreeNode> getList();
	
	/**
	 * 根据ID获取集合对象
	 * @param powerId
	 * @return
	 */
	Map<String,Object> getById(int powerId);
	
	/**
	 * 修改
	 * @param map
	 * @return
	 */
	int update(Map map);
	/**
	 * 添加
	 * @param map
	 * @return
	 */
	int add(Map map);
	/**
	 * 添加门店权限树
	 * @return
	 */
	List<StoreTreeNode> getStoreList();

	/**
	 * 获取权限数据(所有的，但要每个节点根据判断，带上checked:true)
	 * @param roleId
	 * @return
	 */
	public List<TreeNode> getCheckedList(String roleId);

	/**
	 * 获取权限数据(获取登陆人的角色对应所有权限)
	 * @return
	 */
	List<TreeNode> getPowerList();
	/**
	 * 根据id删除权限
	 * @return
	 */
	int deletePowerById(String powerId);
}
