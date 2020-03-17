package com.lightning.action.wuminghui;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.lightning.action.base.BaseAction;
import com.lightning.bean.wuminghui.Driver;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wuminghui.CarDaoImpl;
import com.lightning.dao.impl.wuminghui.DriverDaoImpl;
import com.lightning.dao.wuminghui.CarDao;
import com.lightning.dao.wuminghui.DriverDao;
@Namespace("/Driver")
public class DriverAction extends BaseAction{
	private Driver driver;
	private List tabDriver;
	private List rowDriver;
	private DriverDao driverdao=new DriverDaoImpl();
	private List tabCar;
	private CarDao cardao=new CarDaoImpl();
	
	/**
	 * 查询car的信息传到后台进行增加操作
	 * @return
	 */
	@Action(value="insertAllDriver")
	public String insertAllDriver(){
		tabCar=cardao.findCar();
		JSONWang wang=new JSONWang();
		print(wang.fromList(tabCar));
		return "success";
	}
	/**
	 * 进行增加操作，添加一条数据
	 * @return
	 */
@Action(value="insertDriver",results= {@Result(location="/before/wuminghui/showDriver.jsp")})
	public String insertDriver(){
		driverdao.insertDriver(driver);
//		target="before/wuminghui/showDriver";
		return findDriver();
	}
/**
 * 根据ID删除一条数据，一般不进行此操作
 * @return
 */
@Action(value="deleteDriver",results= {@Result(location="/before/wuminghui/showDriver.jsp")})
	public String deleteDriver() {
		driverdao.deleteDriver(driver);
		return findDriver();
	}
/**
 * 查询所有name=司机的信息
 * @return
 */
@Action(value="findDriver",results= {@Result(location="/before/wuminghui/showDriver.jsp")})
	public String findDriver() {
		tabDriver=driverdao.findDriver();
		return "success";
	}
/**
 * 查询所有信息
 * @return
 */
@Action(value="findAllDriver",results= {@Result(location="/before/wuminghui/showDriver.jsp")})
public String findAllDriver() {
	tabDriver=driverdao.findAllDriver();
	System.out.println(tabDriver);
	return "success";
}
/**
 * 根据ID查询此ID的详细信息
 * @return
 */
@Action(value="findOneDriver",results={@Result (name="success",location="/before/wuminghui/updateDriver.jsp")})
	public String findOneDriver() {
		tabDriver=driverdao.findOneDriver(driver);
		rowDriver=(List) tabDriver.get(0);
		return "success";
	
	}
/**
 * 进行修改操作，根据ID进行修改操作
 * @return
 */
@Action(value="updateDriver",results= {@Result(location="/Driver/findAllDriver.action",type="redirect")})
	public String updateDriver() {
		driverdao.updateDriver(driver);
		return null;//此处死循环
	}
/**
 * 查询司机信息。传到前台，进行增加操作
 * @return		
 */
@Action(value="findDriverdriver")
	public String findDriverdriver() {
		List<List> tabDriver = driverdao.findDriver();
		JSONWang wang=new JSONWang();
		print(wang.fromList(tabDriver));
		//System.out.println(wang.fromList(tabDriver));
		return null;
}
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List getTabDriver() {
		return tabDriver;
	}

	public void setTabDriver(List tabDriver) {
		this.tabDriver = tabDriver;
	}

	public List getRowDriver() {
		return rowDriver;
	}

	public void setRowDriver(List rowDriver) {
		this.rowDriver = rowDriver;
	}

	public DriverDao getDriverdao() {
		return driverdao;
	}

	public void setDriverdao(DriverDao driverdao) {
		this.driverdao = driverdao;
	}
	public List getTabCar() {
		return tabCar;
	}
	public void setTabCar(List tabCar) {
		this.tabCar = tabCar;
	}
	public CarDao getCardao() {
		return cardao;
	}
	public void setCardao(CarDao cardao) {
		this.cardao = cardao;
	}

}
