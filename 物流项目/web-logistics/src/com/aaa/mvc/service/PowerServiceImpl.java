package com.aaa.mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.PowerDao;
import com.aaa.mvc.entity.StoreTreeNode;
import com.aaa.mvc.entity.TreeNode;

/***
 *@className:PowerServiceImpl.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-9上午11:32:05
 *@version:
 */
@Service
public class PowerServiceImpl implements PowerService {

	//依赖注入dao层
	@Autowired
	private PowerDao powerDao;
	
	@Override
	public List<TreeNode> getList() {
		// TODO Auto-generated method stub
		List<TreeNode> powerAllList = powerDao.getList();
		//临时的powerList
		List<TreeNode> powerTempList = new ArrayList<TreeNode>();
		//判断是否为空
		if(powerAllList!=null&&powerAllList.size()>0){
			for(TreeNode ptreeNode:powerAllList){
				if(ptreeNode.getParentId()==0){//如果等于0,说明是一级节点
					powerTempList.add(ptreeNode);
					//递归绑定子节点
					bindChirldren(ptreeNode,powerAllList);
				}
			}
		}
		return powerTempList;
	}

	/**
	 * 递归绑定所有子节点
	 * @param parentTreeNode
	 * @param powerAllList
	 */
	private  void bindChirldren(TreeNode parentTreeNode,List<TreeNode> powerAllList ){
		for(TreeNode chirldrenTreeNode:powerAllList){
			if(parentTreeNode.getId()==chirldrenTreeNode.getParentId()){
				//获取当前节点的所有子节点集合
				List<TreeNode> children = parentTreeNode.getChildren();
				if(children==null){//如果孩子节点为空,
					List<TreeNode> childrenTempList = new ArrayList<TreeNode>();//实例化孩子集合
					childrenTempList.add(chirldrenTreeNode);//添加子节点到集合里面
					parentTreeNode.setChildren(childrenTempList);//设置孩子集合
				}else{//不空，说明设置过
					children.add(chirldrenTreeNode);//添加子节点到集合里面
				}
				//自己调用自己,找孩子
				bindChirldren(chirldrenTreeNode,powerAllList);
			}
		}
	}

	@Override
	public Map<String, Object> getById(int powerId) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> powerList = powerDao.getById(powerId);
		if(powerList!=null&&powerList.size()>0){
			return powerList.get(0);
		}
		return null;
	}

	@Override
	public int update(Map map) {
		// TODO Auto-generated method stub
		return powerDao.update(map);
	}

	@Override
	public int add(Map map) {
		// TODO Auto-generated method stub
		return powerDao.add(map);
	}
	/**
	  * 门店权限树
	  * @return:List<StoreTreeNode>
	  */
	@Override
	public List<StoreTreeNode> getStoreList() {
		List<StoreTreeNode> powerAllList = powerDao.getStoreList();
		//临时的powerList
		List<StoreTreeNode> powerTempList = new ArrayList<StoreTreeNode>();
		//判断是否为空
		if(powerAllList!=null&&powerAllList.size()>0){
			for(StoreTreeNode ptreeNode:powerAllList){
				if(ptreeNode.getParentId()==0){//如果等于0,说明是一级节点
					powerTempList.add(ptreeNode);
					//递归绑定子节点
					bindChirldren(ptreeNode,powerAllList);
				}
			}
		}
		return powerTempList;
	}
	/**
	 * 递归绑定所有门店子节点
	 * @param parentTreeNode
	 * @param powerAllList
	 */
	private  void bindChirldren(StoreTreeNode parentTreeNode,List<StoreTreeNode> powerAllList ){
		for(StoreTreeNode chirldrenTreeNode:powerAllList){
			if(parentTreeNode.getId()==chirldrenTreeNode.getParentId()){
				//获取当前节点的所有子节点集合
				List<StoreTreeNode> children = parentTreeNode.getChildren();
				if(children==null){//如果孩子节点为空,
					List<StoreTreeNode> childrenTempList = new ArrayList<StoreTreeNode>();//实例化孩子集合
					childrenTempList.add(chirldrenTreeNode);//添加子节点到集合里面
					parentTreeNode.setChildren(childrenTempList);//设置孩子集合
				}else{//不空，说明设置过
					children.add(chirldrenTreeNode);//添加子节点到集合里面
				}
				//自己调用自己,找孩子
				bindChirldren(chirldrenTreeNode,powerAllList);
			}
		}
	}
	/**
	 * 获得不同员工的权限树在授权框中显示
	 */
	@Override
	public List<TreeNode> getCheckedList(String roleId) {
				List<TreeNode> powerAllList = powerDao.getCheckedList(roleId);
				//临时的powerList
				List<TreeNode> powerTempList = new ArrayList<TreeNode>();
				//判断是否为空
				if(powerAllList!=null&&powerAllList.size()>0){
					for(TreeNode ptreeNode:powerAllList){
						if(ptreeNode.getParentId()==0){//如果等于0,说明是一级节点
							powerTempList.add(ptreeNode);
							//递归绑定子节点
							bindChirldren(ptreeNode,powerAllList);
						}
					}
				}
				
				return powerTempList;
	}
	/**
	 * 根据用户获得权限
	 */
	@Override
	public List<TreeNode> getPowerList() {
		// TODO Auto-generated method stub
		List<TreeNode> powerAllList = powerDao.getPowerList();
		//临时的powerList
		List<TreeNode> powerTempList = new ArrayList<TreeNode>();
		//判断是否为空
		if(powerAllList!=null&&powerAllList.size()>0){
			for(TreeNode ptreeNode:powerAllList){
				if(ptreeNode.getParentId()==0){//如果等于0,说明是一级节点
					powerTempList.add(ptreeNode);
					//递归绑定子节点
					bindChirldren(ptreeNode,powerAllList);
				}
			}
		}
		
		return powerTempList;
	}
	/**
	 * 根据id删除权限
	 */
	@Override
	public int deletePowerById(String powerId) {
		return powerDao.deletePowerById(powerId);
	}
}
