package com.lightning.action.wuminghui;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.lightning.action.base.BaseAction;
import com.lightning.bean.wuminghui.Way;
import com.lightning.dao.impl.wuminghui.WayDaoImpl;
import com.lightning.dao.wuminghui.WayDao;


@Namespace("/Way")
public class WayAction extends BaseAction{
	private Way way;
	private List tabWay;
	private List rowWay;
	private WayDao waydao=new WayDaoImpl();
	

	@Action(value="insertWay",results= {@Result(name="success",location="/before/wuminghui/showWay.jsp")})
	public String insertWay(){
		waydao.insertWay(way);
	//	target="before/wuminghui/showWay";
		return findWay();
	}
	@Action(value="deleteWay",results= {@Result(location="/before/wuminghui/showWay.jsp")})
	public String deleteWay() {
		waydao.deleteWay(way);
		return findWay();
	}
	@Action(value="findWay",results= {@Result(location="/before/wuminghui/showWay.jsp")})
	public String findWay() {
		tabWay=waydao.findWay();
		return	"success";
	}
	@Action(value="findOneWay",results= {@Result(name="updateWay",location="/before/wuminghui/updateWay.jsp")})
	public String findOneWay() {
		tabWay=waydao.findOneWay(way);
		rowWay=(List) tabWay.get(0);
		return "updateWay";
	}
	@Action(value="updateWay",results= {@Result(location="/before/wuminghui/showWay.jsp")})
	public String updateWay() {
		waydao.updateWay(way);
		return findWay();
	}
	public Way getWay() {
		return way;
	}
	public void setWay(Way way) {
		this.way = way;
	}
	public List getTabWay() {
		return tabWay;
	}
	public void setTabWay(List tabWay) {
		this.tabWay = tabWay;
	}
	public List getRowWay() {
		return rowWay;
	}
	public void setRowWay(List rowWay) {
		this.rowWay = rowWay;
	}
	public WayDao getWaydao() {
		return waydao;
	}
	public void setWaydao(WayDao waydao) {
		this.waydao = waydao;
	}
	
}
