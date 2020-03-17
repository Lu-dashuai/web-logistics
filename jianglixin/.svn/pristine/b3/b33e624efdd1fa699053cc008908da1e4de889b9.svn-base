package com.lightning.dao.impl.wangzelong;

import java.util.List;

import com.lightning.bean.wangzelong.Price;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangzelong.PriceDao;

public class PriceDaoImpl implements PriceDao{

	@Override
	public List findPrice() {
		// 查询price表的所有数据
		String sql="select * from price";
		return BaseDao.query(sql, null);
	}

	@Override
	public List findOnePrice(Price price) {
		// 查询price表的单条数据
		String sql="select price_km,price_ton,price_piece,price_province,price_explain from price where price_id=?";
		return BaseDao.query(sql,new Object[] {price.getPrice_id()});
	}

	@Override
	public void deletePrice(Price price) {
		// 删除price的单条数据
		String sql="delete from price where price_id=?";
		BaseDao.update(sql, new Object[] {price.getPrice_id()});
	}

	@Override
	public void updatePrice(Price price) {
		// 更新price标的单条数据
		String sql="update price set price_km=?,price_ton=?,price_piece=?,price_province=?,price_explain=? where price_id=?";
		BaseDao.update(sql, new Object[] {price.getPrice_km(),price.getPrice_ton(),price.getPrice_piece(),price.getPrice_province(),price.getPrice_explain(),price.getPrice_id()});
	}

	@Override
	public void insertPrice(Price price) {
		// 添加价格表
		String sql="insert into price values(?,?,?,?,?,?)";
		BaseDao.update(sql, new Object[]{price.getPrice_id(),price.getPrice_km(),price.getPrice_ton(),price.getPrice_piece(),price.getPrice_province(),price.getPrice_explain()});
	}

}
