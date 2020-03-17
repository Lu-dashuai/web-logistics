package com.lightning.action.wangzelong;

import java.util.List;

import org.apache.logging.log4j.core.config.json.JsonConfiguration;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangzelong.Price;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wangzelong.PriceDaoImpl;
import com.lightning.dao.wangzelong.PriceDao;
@Namespace("/Price")
public class PriceAction extends BaseAction{
	private Price price;
	private PriceDao pricedao=new PriceDaoImpl();
	private List tabPrice;
	private List rowPrice;
	
	@Action(value="updatePrice",results= {@Result(type="redirect",location="/before/wangzelong/showPrice.jsp")})
	public String updatePrice(){
		pricedao.updatePrice(price);//向price添加价格信息
		return "success";
	}
	
	@Action(value="findOnePrice")
	public String findOnePrice() {//查询价格信息
		tabPrice=pricedao.findOnePrice(price);
		print(JSON.toJSONString(tabPrice));
		return null;
	}
	@Action(value="findPrice")
	public String findPrice() {//查询价格所有信息
		tabPrice=pricedao.findPrice();
		print(JSON.toJSONString(tabPrice));
		return null;
	}
	
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public PriceDao getPricedao() {
		return pricedao;
	}

	public void setPricedao(PriceDao pricedao) {
		this.pricedao = pricedao;
	}

	public List getTabPrice() {
		return tabPrice;
	}

	public void setTabPrice(List tabPrice) {
		this.tabPrice = tabPrice;
	}

	public List getRowPrice() {
		return rowPrice;
	}

	public void setRowPrice(List rowPrice) {
		this.rowPrice = rowPrice;
	}
	
	
}
