package com.lightning.action.wangzelong;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.makui.Users;
import com.lightning.bean.wangzelong.Bills;
import com.lightning.bean.wangzelong.Cargo;
import com.lightning.bean.wangzelong.Price;
import com.lightning.bean.yuhaiyang.Indent;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wangzelong.BillsDaoImpl;
import com.lightning.dao.impl.wangzelong.CargoDaoImpl;
import com.lightning.dao.impl.wangzelong.PriceDaoImpl;
import com.lightning.dao.impl.wangzelong.TypeDaoImpl;
import com.lightning.dao.impl.wuminghui.WayDaoImpl;
import com.lightning.dao.impl.yuhaiyang.IndentDaoImpl;
import com.lightning.dao.wangzelong.BillsDao;
import com.lightning.dao.wangzelong.CargoDao;
import com.lightning.dao.wangzelong.PriceDao;
import com.lightning.dao.wangzelong.TypeDao;
import com.lightning.dao.wuminghui.WayDao;
import com.lightning.dao.yuhaiyang.IndentDao;
@Namespace("/Cargo")
public class CargoAction extends BaseAction{
	private Cargo cargo;
	private CargoDao cargodao=new CargoDaoImpl();
	private Indent indent;
	private IndentDao indentdao=new IndentDaoImpl();
	private List tabCargo;
	private List rowCargo;
	private List tabIndent;
	private List rowIndent;
	private String params;
	private TypeDao typedao=new TypeDaoImpl();
	private WayDao waydao=new WayDaoImpl();
	private List rowDistance;
	@Action(value="insertCargo",results= {@Result(location="/before/wangzelong/showAccount.jsp"),@Result(name="usersError",location="/before/makui/Userslogin.jsp"),@Result(name="insertError",location="/before/wangzelong/insertIndentBefore.jsp")})
	public String insertCargo(){                                              
		Users users=null;                                                                                                                                   
		users=(Users) getSession().get("users");//获取用户信息
		if(users!=null) {//判断页面是否有用户登陆  
			int key=indentdao.insertIndent(indent);//添加indent表并获取自动生成的主键
			if(key>0) {
				Bills bills=new Bills();
				bills.setBills_users(users.getUsers_id());
				bills.setBills_indent(key);
				BillsDao billsdao=new BillsDaoImpl();
				billsdao.insertBills(bills);//添加用户与订单表关联
				cargo.setCargo_indent(key);
				cargodao.insertCargo(cargo);//添加货物信息表
				return findOneCargo();
			}else {
				return "insertError";//用户用回车刷新页面时返回添加订单页面
			}
		}else {
			return "usersError";//没有用户登陆时，调到登陆页面
		}
	}
	
	public String findOneCargo(){
		tabCargo=cargodao.findCargo(cargo);//查询并反馈至付款界面
		rowCargo=(List) tabCargo.get(0);
		rowDistance=(List) waydao.findKmOnWay(Integer.parseInt(indent.getIndent_shipper_address()),Integer.parseInt(indent.getIndent_receiver_address())).get(0);//查询距离
		return "success";
	}
	
	@Action(value="findOneCargoAgain")
	public String findOneCargoAgain() {//查询货物并计算价格
		Price price =new Price();
		PriceDao pricedao=new PriceDaoImpl();
		price.setPrice_id(1); //获取价格
		List tabPrice=pricedao.findOnePrice(price);
		List rowPrice=(List) tabPrice.get(0);
		List moneyAll=new ArrayList();
		float money=0f;
		String[] indents=params.split(",");
		Cargo findcargo=new Cargo();
		Indent findIndent=new Indent();
		List tabFindCargo=new ArrayList();
		List rowFindCargo=new ArrayList();
		List tabFindIndent=new ArrayList();
		List rowFindIndent=new ArrayList();
		List distace=new ArrayList();
		for(int i=0;i<indents.length;i++) {
			findcargo.setCargo_indent(Integer.parseInt(indents[i]));
			findIndent.setIndent_id(Integer.parseInt(indents[i]));
			tabFindCargo=cargodao.findCargo(findcargo);
			rowFindCargo=(List) tabFindCargo.get(0);
			tabFindIndent=indentdao.selectById(findIndent);
			rowFindIndent=(List) tabFindIndent.get(0);
			distace=(List) waydao.findKmOnWay(Integer.parseInt(rowFindIndent.get(9).toString()),Integer.parseInt(rowFindIndent.get(5).toString())).get(0);
			money=5*(float)rowPrice.get(0)+(float)rowFindCargo.get(1)*(float)rowPrice.get(1)+(float)rowFindCargo.get(2)*(float)rowPrice.get(2)+(int)rowPrice.get(3);
			moneyAll.add(money);
		}
		print(JSON.toJSONString(moneyAll));
		return null;
	}
	
	public String updateCargo() {
		return null;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public CargoDao getCargodao() {
		return cargodao;
	}

	public void setCargodao(CargoDao cargodao) {
		this.cargodao = cargodao;
	}

	public List getTabCargo() {
		return tabCargo;
	}

	public void setTabCargo(List tabCargo) {
		this.tabCargo = tabCargo;
	}

	public List getRowCargo() {
		return rowCargo;
	}

	public void setRowCargo(List rowCargo) {
		this.rowCargo = rowCargo;
	}

	public Indent getIndent() {
		return indent;
	}

	public void setIndent(Indent indent) {
		this.indent = indent;
	}

	public IndentDao getIndentdao() {
		return indentdao;
	}

	public void setIndentdao(IndentDao indentdao) {
		this.indentdao = indentdao;
	}

	public TypeDao getTypedao() {
		return typedao;
	}

	public void setTypedao(TypeDao typedao) {
		this.typedao = typedao;
	}
	public List getTabIndent() {
		return tabIndent;
	}
	public void setTabIndent(List tabIndent) {
		this.tabIndent = tabIndent;
	}
	public List getRowIndent() {
		return rowIndent;
	}
	public void setRowIndent(List rowIndent) {
		this.rowIndent = rowIndent;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public WayDao getWaydao() {
		return waydao;
	}

	public void setWaydao(WayDao waydao) {
		this.waydao = waydao;
	}

	public List getRowDistance() {
		return rowDistance;
	}

	public void setRowDistance(List rowDistance) {
		this.rowDistance = rowDistance;
	}
	
	
}
