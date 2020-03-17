/**
 * 
 */
package com.lightning.action.wuminghui;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.lightning.action.base.BaseAction;
import com.lightning.bean.wuminghui.Car;
import com.lightning.bean.wuminghui.Cartype;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wuminghui.CartypeDaoImpl;
import com.lightning.dao.wuminghui.CartypeDao;

/**   
*    
* 项目名称：lightning3   
* 类名称：CartypeAction   
* 类描述：   
* 创建人：Administrator   
* 创建时间：2018年1月31日 上午8:40:47   
* @version        
*/
@Namespace("/Cartype")
public class CartypeAction extends BaseAction{
	private Cartype cartype;
	private CartypeDao cartypedao= new CartypeDaoImpl();
	private List<List> tabcartype;
	private List rowcartype;
//	private Car car;
//	private CarDao cardao
	
	/**
	 * 
	 * 增加一个车型
	 * */
	@Action(value="insertCartype",results= {@Result(location="/before/wuminghui/showCartype.jsp")})
	public String insertCartype() {
		cartypedao.insertCartype(cartype);
		return findCartype();
	}
	
	/**
	 * 查询全部车型
	 * */
	@Action(value="findCartype",results= {@Result(type="chain",location="/before/wuminghui/showCartype.jsp")})
	public String findCartype() {
		tabcartype = cartypedao.findCartype();
		//System.out.println(tabcartype);
		return "success";
		
	}
	/**
	 * 
	 * */
	
	
	public Cartype getCartype() {
		return cartype;
	}
	public void setCartype(Cartype cartype) {
		this.cartype = cartype;
	}
	public CartypeDao getCartypedao() {
		return cartypedao;
	}
	public void setCartypedao(CartypeDao cartypedao) {
		this.cartypedao = cartypedao;
	}
	public List<List> getTabcartype() {
		return tabcartype;
	}
	public void setTabcartype(List<List> tabcartype) {
		this.tabcartype = tabcartype;
	}
	public List getRowcartype() {
		return rowcartype;
	}
	public void setRowcartype(List rowcartype) {
		this.rowcartype = rowcartype;
	}
	
	

}
