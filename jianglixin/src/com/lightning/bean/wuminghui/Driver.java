package com.lightning.bean.wuminghui;

public class Driver {
	private int driver_worker;//驾驶人编号 不是null 主键
	private int driver_car;//车辆id
	public int getDriver_worker() {
		return driver_worker;
	}
	public void setDriver_worker(int driver_worker) {
		this.driver_worker = driver_worker;
	}
	public int getDriver_car() {
		return driver_car;
	}
	public void setDriver_car(int driver_car) {
		this.driver_car = driver_car;
	}
	public Driver(int driver_worker, int driver_car) {
		super();
		this.driver_worker = driver_worker;
		this.driver_car = driver_car;
	}
	
	public Driver(int driver_worker) {
		super();
		this.driver_worker = driver_worker;
	}
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
