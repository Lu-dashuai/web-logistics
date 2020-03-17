package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.mvc.dao.OrderDao;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	/**
	 * 完成分页功能
	 */
	@Override
	public List<Map<String, Object>> getPage(Map map) {
		// TODO Auto-generated method stub
	    //获取分页要素，判断如果为空，赋予默认值
		int pageNo = map.get("page")==null?1:Integer.valueOf(map.get("page")+"");
		int pageSize = map.get("rows")==null?10:Integer.valueOf(map.get("rows")+"");
		//计算开始值
		int start = (pageNo-1)*pageSize;
		return orderDao.getPage(start, pageSize, map);
	}
	/**
	 * 获取总条数
	 */
	@Override
	public int getPageCount(Map map) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> pageCount = orderDao.getPageCount(map);
		//判断集合，如果不为空，返回总数量
		if(pageCount!=null&&pageCount.size()>0){
			return Integer.valueOf(pageCount.get(0).get("cnt")+"");
		}
		return 0;
	}
	/**
	 * 订单添加
	 */
	@Override
	public int userAdd(Map map) {
		// TODO Auto-generated method stub
		return orderDao.userAdd(map);
	}
	/**
	 * 订单修改
	 */
	@Override
	public int updateOrder(int id, Map map) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(id, map);
	}
	/**
	 * 删除订单
	 */
	@Override
	public int deleteOrder(int id) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrder(id);
	}
	/**
	  * 审核订单页面的通过按钮
	  * @param id
	  * @return
	  */
	@Override
	public int passOrder(String idsStr) {
		int row = 0;
		if(idsStr!=null&&!"".equals(idsStr)){
			String[] oids = idsStr.split(",");//以逗号拿到每个逗号之间的值，放到新定义的数组里
			for(String id:oids){
				row = orderDao.passOrder(Integer.valueOf(id));
			}
		}
		return row;
	}
	/**
	  * 审核订单页面的退单按钮
	  * @param id
	  * @return
	  */
	@Override
	public int backOrder(String idsStr) {
		int row = 0;
		if(idsStr!=null&&!"".equals(idsStr)){
			String[] oids = idsStr.split(",");//以逗号拿到每个逗号之间的值，放到新定义的数组里
			for(String id:oids){
				row = orderDao.backOrder(Integer.valueOf(id));
			}
		}
		return row;
	}
	/**
	  * 我的订单页面的入库按钮
	  * @param id
	  * @return
	  */
	@Override
	public int inkuOrder(String idsStr,Object user) {
		int row = 0;
		if(idsStr!=null&&!"".equals(idsStr)){
			String[] oids = idsStr.split(",");//以逗号拿到每个逗号之间的值，放到新定义的数组里
			for(String id:oids){
				row = orderDao.inkuOrder(Integer.valueOf(id),user);
			}
		}
		return row;
		//return orderDao.inkuOrder(id,user);
	}
	/**
	 * 邮寄单号验证
	 */
	@Override
	public int checkMailnum(Map map) {
		return orderDao.checkMailnum(map);
	}
	/**
	  * 订单管理页面的添加菜单查询地址
	  * @return
	  */
	@Override
	public List<Map<String, Object>> getAdr() {
		return orderDao.getAdr();
	}
	/**
	 * 通过用户登陆查询所在门店
	 */
	@Override
	public List<Map<String, Object>> getUserState(Object user) {
		return orderDao.getUserState(user);
	}
	/**
	 * 订单入库页面的到达目的地方法
	 */
	@Override
	public int overStoreOrder(String idsStr,Object user) {
		// TODO Auto-generated method stub
		int row = 0;
		if(idsStr!=null&&!"".equals(idsStr)){
			String[] oids = idsStr.split(",");//以逗号拿到每个逗号之间的值，放到新定义的数组里
			for(String id:oids){
				row = orderDao.overStoreOrder(Integer.valueOf(id),user);
			}
		}
		return row;
		//return orderDao.overStoreOrder(id,user);
	}
	/**
	 * 获取门店信息
	 * @return
	 */
	
	@Override
	public List<Map<String, Object>> getStore() {
		// TODO Auto-generated method stub
		return orderDao.getStore();
	}
	

}
