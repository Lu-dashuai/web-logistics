package com.lightning.dao.impl.wuminghui;

import java.util.List;


import com.lightning.bean.util.Page;
import com.lightning.bean.wuminghui.Car;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wuminghui.CarDao;

public class CarDaoImpl implements CarDao{
	/**
	 * 增加一个车辆信息
	 * */
	@Override
	public int insertCar(Car car) {
		String sql="insert into Car(car_id,car_code,car_type,car_size,car_state,car_belong_station) values(?,?,?,?,?,?)";
		 return BaseDao.update(sql, new Object[]{
				car.getCar_id(),car.getCar_code(),car.getCar_type(),car.getCar_size(),car.getCar_state(),car.getCar_belong_station()
				});
	}
	
	/**
	 * 删除一个车辆信息
	 * */
	@Override
	public void deleteCar(Car car) {
		String sql="delete from Car where car_id=?";
		BaseDao.update(sql, new Object[]{
				car.getCar_id()
		});
	}
	/**
	 * 修改一个车辆信息
	 * */
	@Override
	public void updateCar(Car car) {
		String sql="update car set car_code=?,car_type=?,car_size=?,car_state=?,car_belong_station=? where car_id=?";
		BaseDao.update(sql, new Object[]{
				car.getCar_code(),car.getCar_type(),car.getCar_size(),car.getCar_state(),car.getCar_belong_station(),car.getCar_id()
		});
	}
	/**
	 * 查询全部车辆信息
	 * */
	@Override
	public List findCar() {
		String sql="select ca.car_id,ca.car_code,cartype.cartype_name,ca.car_size,"
				+"sta.state_name,ca.car_belong_station,ca.car_arrive_station from car ca left join "
				+ "state sta on ca.car_state = sta.state_id left join cartype on cartype.cartype_id=ca.car_type";
		return BaseDao.query(sql, null);
	}
	
	/**
	 * 根据ID删除
	 * */
	@Override
	public List findOneCar(Car car) {
		String sql="select car_id,car_code,car_type,car_size,car_state,"
				+ "car_belong_station from car where car_id=?";
		return BaseDao.query(sql, new Object[] {car.getCar_id()});
	}
	/**
	 * 查询车辆总数
	 */
	@Override
	public List findCountCar() {
		String sql="select count(*) from car";
		return BaseDao.query(sql, null);
	}
	/**
	 * 分页查询car
	 * */
	@Override
	public List findlimitCar(Page page) {
		String sql="select ca.car_id,ca.car_code,cartype.cartype_name,ca.car_size,sta.state_name,"
				+ "st.station_name from car ca left join state sta on ca.car_state = sta.state_id left join"
				+ " cartype on cartype.cartype_id=ca.car_type left join station st on st.station_id=ca.car_belong_station"
				+ " order by ca.car_id limit ?,?";
//		System.out.println(page.getStartIndex());
//		System.out.println(page.getMax());
		return BaseDao.query(sql, new Object[] {page.getStartIndex(),page.getMax()});
	}
	//分页查询到达网点
	@Override
	public List findlimitWay(Page page) {
		String sql="select st.station_name from station st left join way wa on"
				+ " wa.way_direction=st.station_id left join car ca on ca.car_id=wa.way_car "
				+ "order by ca.car_id limit ?,?";
		return BaseDao.query(sql, new Object[] {page.getStartIndex(),page.getMax()});
	} 
	
	//根据车id查看来车的信息
	@Override
	public List findComeinCar(Car car) {
		String sql="select car_id,car_code,car_state,car_belong_station from car where car_id=?";
		return BaseDao.queryMap(sql, new Object[] {car.getCar_id()});
	}
	//修改车辆状态为休息
	@Override
	public void updateComeinCar(Car car) {
		String sql="update car set car_state=5 where car_id=?";
		BaseDao.update(sql, new Object[] {car.getCar_id()});
	}
	//修改车辆状态为空闲
	@Override
	public void updateGohomeCar(Car car) {
		String sql="update car set car_state=2 where car_id=?";
		BaseDao.update(sql, new Object[] {car.getCar_id()});
	}
	//根据所属网点查找车辆id
	@Override
	public List findGohomeCar(int belong) {
		String sql="select car_id from car where car_belong_station=?";
		return BaseDao.query(sql, new Object[] {belong});
	}
	/**
	 * 模糊查询
	 */
	@Override
	public List<List> findCarByCode(String carName) {
		String sql ="select ca.car_id,ca.car_code,cartype.cartype_name,ca.car_size,station.station_name,station.station_address "
				+ "from car ca left join state sta on ca.car_state = sta.state_id left join cartype cartype "
				+ "on cartype.cartype_id=ca.car_type left join station station "
				+ "on ca.car_id = station.station_id where ca.car_code like '%"+carName+"%'";
		return BaseDao.query(sql, null);
	}

	/* (non-Javadoc)
	 * @see com.lightning.dao.wuminghui.CarDao#findCarOne()
	 */

}
