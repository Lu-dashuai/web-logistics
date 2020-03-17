package com.lightning.dao.impl.wangzelong;

import java.util.List;

import com.lightning.bean.wangzelong.Bills;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangzelong.BillsDao;

public class BillsDaoImpl implements BillsDao{

	@Override
	public void insertBills(Bills bills) {
		// 添加用户与订单关联
		String sql="insert into bills values(?,?,1)";
		BaseDao.update(sql, new Object[] {bills.getBills_indent(),bills.getBills_users()});
	}

	@Override
	public List findBills(Bills bills) {
		// 通过用户id来查找该用户所有的订单信息
		String sql="select bills_indent,bills_users,bills_shape from bills where bills_users=? order by bills_indent desc";
		return BaseDao.query(sql, new Object[] {bills.getBills_users()});
		
	}
	
	
	@Override
	public void updateBills(Bills bills) {
		// 通过将bills_shape从1变为2 使用户页面不显示
		String sql="update bills set bills_shape=2 where bills_indent=?";
		BaseDao.update(sql, new Object[] {bills.getBills_indent()});
	}

	@Override
	public void deleteBills(Bills bills) {
		// 未付款时用户可删除自己的订单
		String sql="delete from bills where bills_indent=?";
		BaseDao.update(sql, new Object[]{bills.getBills_indent()});
	}

	@Override
	public List findOneBills(Bills bills) {
		// 通过bills_indent查询精确信息
		String sql="select ent.indent_id,ent.indent_time,ent.indent_shipper_name,ent.indent_shipper_phone,"
				+ "ent.indent_shipper_postcode,ent.indent_shipper_address,ent.indent_receiver_name,"
				+ "ent.indent_receiver_phone,ent.indent_receiver_postcode,ent.indent_receiver_address,"
				+ "cg.cargo_explain,cg.cargo_weight,cg.cargo_size,ty.type,acc.account_money from bills bi "
				+ "left join indent ent on bi.bills_indent=ent.indent_id left join cargo cg "
				+ "on ent.indent_id=cg.cargo_indent left join account acc "
				+ "on ent.indent_id=acc.account_indent left join type ty on "
				+ "cg.cargo_type=ty.type_id where bills_indent=?";
		return BaseDao.query(sql, new Object[] {bills.getBills_indent()});
	}

}
