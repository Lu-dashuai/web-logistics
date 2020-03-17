package com.lightning.dao.wangzelong;

import java.util.List;

import com.lightning.bean.wangzelong.Price;

public interface PriceDao {
	//price表的接口
	List findPrice();
	List findOnePrice(Price price);
	void deletePrice(Price price);
	void updatePrice(Price price);
	void insertPrice(Price price);
}
