package com.lightning.action.wuminghui;

import java.sql.Driver;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.lightning.action.base.BaseAction;
import com.lightning.bean.util.Page;
import com.lightning.bean.util.PageUtil;
import com.lightning.bean.wuminghui.Car;
import com.lightning.bean.wuminghui.Cartype;
import com.lightning.bean.wuminghui.State;
import com.lightning.bean.wuminghui.Station;
import com.lightning.bean.wuminghui.Way;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wuminghui.CarDaoImpl;
import com.lightning.dao.impl.wuminghui.CartypeDaoImpl;
import com.lightning.dao.impl.wuminghui.DriverDaoImpl;
import com.lightning.dao.impl.wuminghui.StateDaoImpl;
import com.lightning.dao.impl.wuminghui.StationDaoImpl;
import com.lightning.dao.impl.wuminghui.WayDaoImpl;
import com.lightning.dao.wuminghui.CarDao;
import com.lightning.dao.wuminghui.CartypeDao;
import com.lightning.dao.wuminghui.DriverDao;
import com.lightning.dao.wuminghui.StateDao;
import com.lightning.dao.wuminghui.StationDao;
import com.lightning.dao.wuminghui.WayDao;
@Namespace("/Car")
public class CarAction extends BaseAction{
	private Car car;
	private List tabCar;
	private List rowCar;
	private CarDao cardao=new CarDaoImpl();
	private State state;
	private StateDao statedao=new StateDaoImpl();
	private Station station;
	private StationDao stationdao=new StationDaoImpl();
	private Way way=new Way();
	private WayDao waydao=new WayDaoImpl();
	private Driver driver;
	private DriverDao driverdao=new DriverDaoImpl();
	private String carName;//模糊查询
	private Page page=new Page();
	private PageUtil pageutil=new PageUtil();
	private List tabWay;
	private Cartype cartype;
	private CartypeDao cartypedao=new CartypeDaoImpl();
	private List rowWay;
	
	//private List tabcartype;
	/**
	 * 添加一条信息
	 * */
	@Action(value="insertCar",results= {@Result(location="/before/wuminghui/showCar.jsp")})
	public String insertCar(){ 
		int key=cardao.insertCar(car);
		way.setWay_car(key);
		waydao.insertWay(way);
//		target="before/wuminghui/showCar";
		return "success";
	}
	
	/**
	 * ajax传输车辆状态
	 * */
	@Action(value="findState")
	public String findState() {
		List<List> tabState=statedao.findState(); 
		JSONWang wang=new JSONWang();
		print(wang.fromList(tabState));
		return null;
	}
	
	/**
	 * 根据ID删除一条信息
	 * */
	@Action(value="deleteCar",results= {@Result(location="/before/wuminghui/showCar.jsp")})
	public String deleteCar() {
		cardao.deleteCar(car);
		way.setWay_car(car.getCar_id());
		waydao.deleteWay(way);
		return "success";
		 
	}
	
	/**
	 * 查询全部车辆信息     模糊查询
	 * */
	@Action(value="findCarByCode",results= {@Result(location="/before/wuminghui/showCar.jsp")})
	public String findCarByCode() {
		//System.out.println(carName);
		tabCar=cardao.findCarByCode(carName);
		//System.out.println(tabCar);
		return "success";
	}
	
	/**
	 * 查询根据Id 修改一条车辆信息
	 * */
	@Action(value="findOneCar",results= {@Result(name="success",location="/before/wuminghui/updateCar.jsp")})
	public String findOneCar() {
		tabCar=cardao.findOneCar(car);
		rowCar=(List) tabCar.get(0);
		Way waycar=new Way();
		waycar.setWay_car(car.getCar_id());
		rowWay=(List) waydao.findOneWay(waycar).get(0);
	//	System.out.println(rowCar);
		return "success";
	}
	
	/**
	 * 修改车辆信息
	 * */
	@Action(value="updateCarAndWay",results= {@Result(location="/before/wuminghui/showCar.jsp")})
	public String updateCarAndWay() {
		cardao.updateCar(car);
		way.setWay_car(car.getCar_id());
		waydao.updateWay(way);
		return "success";
	}
	
	/**
	 * 用ajax传输全部的网点ID
	 * */
	@Action(value="findStation")
	public String findStation() {
		List<List> tabStation=stationdao.findStation(); 
		JSONWang wang=new JSONWang();
		print(wang.fromList(tabStation));
		return null;
	}
	
	/**
	 * 用ajax传输全部的车辆ID
	 * */
	@Action(value="findCarcar")
	public String findWay() {
		List<List> tabCar = cardao.findCar();
		JSONWang wang=new JSONWang();
		print(wang.fromList(tabCar));
		return null;
	}
	
	
	/**
	 * ajax传输车辆类型
	 * 
	 * */
	
	@Action(value="findCartype")
	public String findAllCartype() {
		List<List> tabCartype=cartypedao.findAllCartype(); 
		JSONWang wang=new JSONWang();
		print(wang.fromList(tabCartype));
		//System.out.println(wang.fromList(tabCartype));
		return null;
	}
	
	
	/**
	 * 分页
	 * */
	@Action(value="findCarCount",results= {@Result(location="/before/wuminghui/showCar.jsp")})
	public String findCarCount() {
		List count=(List) cardao.findCountCar().get(0);
		pageutil.setTotal(Integer.parseInt(count.get(0).toString()));
		page.setMax(10);
		if(pageutil.getTotal()%10==0) {
			page.setMaxPage(pageutil.getTotal()/10);
		}else {
			page.setMaxPage((pageutil.getTotal()/10)+1);
		}
		tabCar=cardao.findlimitCar(page);
		return "success";
	}
	
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public StateDao getStatedao() {
		return statedao;
	}
	public void setStatedao(StateDao statedao) {
		this.statedao = statedao;
	}
	

	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public List getTabCar() {
		return tabCar;
	}


	public void setTabCar(List tabCar) {
		this.tabCar = tabCar;
	}



	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public List getRowCar() {
		return rowCar;
	}


	public void setRowCar(List rowCar) {
		this.rowCar = rowCar;
	}


	public CarDao getCardao() {
		return cardao;
	}


	public void setCardao(CarDao cardao) {
		this.cardao = cardao;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public StationDao getStationdao() {
		return stationdao;
	}

	public void setStationdao(StationDao stationdao) {
		this.stationdao = stationdao;
	}

	public Way getWay() {
		return way;
	}

	public void setWay(Way way) {
		this.way = way;
	}

	public WayDao getWaydao() {
		return waydao;
	}

	public void setWaydao(WayDao waydao) {
		this.waydao = waydao;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public DriverDao getDriverdao() {
		return driverdao;
	}

	public void setDriverdao(DriverDao driverdao) {
		this.driverdao = driverdao;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public PageUtil getPageutil() {
		return pageutil;
	}

	public void setPageutil(PageUtil pageutil) {
		this.pageutil = pageutil;
	}

	public List getTabWay() {
		return tabWay;
	}

	public void setTabWay(List tabWay) {
		this.tabWay = tabWay;
	}

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

	public List getRowWay() {
		return rowWay;
	}

	public void setRowWay(List rowWay) {
		this.rowWay = rowWay;
	}
	
	
}
