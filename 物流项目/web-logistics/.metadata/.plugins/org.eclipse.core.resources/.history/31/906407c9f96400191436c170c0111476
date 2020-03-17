package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.EmpDao;



@Service
public class EmpServiceImpl implements EmpService {
	//依赖注入
		@Autowired
		private EmpDao empDao;

		

		@Override
		public List<Map<String, Object>> getPage(Map map) {
			// TODO Auto-generated method stub
		    //获取分页要素，判断如果为空，赋予默认值
			int pageNo = map.get("page")==null?1:Integer.valueOf(map.get("page")+"");
			int pageSize = map.get("rows")==null?10:Integer.valueOf(map.get("rows")+"");
			//计算开始值
			int start = (pageNo-1)*pageSize;
			return empDao.getPage(start, pageSize, map);
		}

		@Override
		public int getPageCount(Map map) {
			// TODO Auto-generated method stub
			List<Map<String, Object>> pageCount = empDao.getPageCount(map);
			//判断集合，如果不为空，返回总数量
			if(pageCount!=null&&pageCount.size()>0){
				return Integer.valueOf(pageCount.get(0).get("cnt")+"");
			}
			return 0;
		}

		@Override
		public int empAdd(Map map) {
			
			return empDao.empAdd(map);
		}

		@Override
		public int empDel(String id) {
			
			return empDao.empDel(id);
		}

		@Override
		public int empUpdate(Map paramMap) {
			return empDao.empUpdate(paramMap);
		}

		/**
		 * 批量保存角色和权限
		 * @param map
		 * @return 
		 */
		@Override
		public int saveRoleAndPower(Map map) {
			// TODO Auto-generated method stub
			String roleId = map.get("id")+"";//1
			String powerIds = map.get("powerIds")+"";//1,2,3,11
			//添加之前，删除所有原来该角色关联的所有权限ID  ，达到更新目的
			empDao.deletePowersByRoleId(roleId);
			//分割字符串，循环添加
			String[] powerArr = powerIds.split(",");//[1,2,3,11]
			boolean isSuc=true;
			for(String powerId:powerArr){
				int rs = empDao.addRoleAndPowers(roleId, powerId);
				if(rs==0){
					isSuc=false; 
				}
			}
			if(isSuc)
			 return 1;
			else
		     return 0;
		}
		/**
		 * 获得角色数据
		 */
		@Override
		public Object getRolePage(Map map) {
			 //获取分页要素，判断如果为空，赋予默认值
			int pageNo = map.get("page")==null?1:Integer.valueOf(map.get("page")+"");
			int pageSize = map.get("rows")==null?10:Integer.valueOf(map.get("rows")+"");
			//计算开始值
			int start = (pageNo-1)*pageSize;
			return empDao.getRolePage(start, pageSize, map);
		}
		/**
		 * 获得角色总数量
		 */
		@Override
		public int getRolePageCount(Map map) {
			List<Map<String, Object>> pageCount = empDao.getRolePageCount(map);
			//判断集合，如果不为空，返回总数量
			if(pageCount!=null&&pageCount.size()>0){
				return Integer.valueOf(pageCount.get(0).get("cnt")+"");
			}
			return 0;
		}

}
