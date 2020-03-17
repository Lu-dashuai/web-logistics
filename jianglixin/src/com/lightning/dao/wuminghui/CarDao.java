package com.lightning.dao.wuminghui;

import java.util.List;

import com.lightning.bean.util.Page;
import com.lightning.bean.wuminghui.Car;

public interface CarDao {
	public int insertCar(Car car);
	public void deleteCar(Car car);
	public void updateCar(Car car);
	public List findCar();
	public List findOneCar(Car car);
	public List findCountCar();
	public List findlimitCar(Page page);
	public List<List> findCarByCode(String carName);//模糊查询	
	public List findlimitWay(Page page);
	public List findComeinCar(Car car);
	public void updateComeinCar(Car car);
	//根据所属网点查找车辆id
	public List findGohomeCar(int belong);
	//修改车辆状态为空闲
	public void updateGohomeCar(Car car);
}
