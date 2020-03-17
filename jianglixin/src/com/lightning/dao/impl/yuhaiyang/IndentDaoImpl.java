package com.lightning.dao.impl.yuhaiyang;

import java.util.List;

import com.lightning.bean.wangjia.Worker;
import com.lightning.bean.wuminghui.Car;
import com.lightning.bean.yuhaiyang.Indent;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.yuhaiyang.IndentDao;

public class IndentDaoImpl implements IndentDao {

	BaseDao base=new BaseDao();
	@Override
	////查询订单表的详细信息
	public List findIndent() {
		// TODO Auto-generated method stub
		String sql="SELECT ent.*,sit.situation_name,car.cargo_weight,car.cargo_size,te.type,car.cargo_explain from indent ent  " + 
				" left JOIN cargo car ON ent.indent_id=car.cargo_indent  " + 
				" left JOIN type te on car.cargo_type=te.type_id " + 
				" left join situation sit on sit.situation_id=ent.indent_situation ";
		try {
			List list=base.queryMap(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	//删除订单表的信息
	public void deleteIndent(Indent indent) {
		// TODO Auto-generated method stub
		 String sql="delete from indent where indent_id=?";
		 try {
			base.update(sql, new Object[]{indent.getIndent_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	//添加订单表的信息
	public int insertIndent(Indent indent) {
		// TODO Auto-generated method stub
		String sql="insert into indent(indent_time,indent_receiver_name,indent_receiver_phone,indent_receiver_postcode,indent_receiver_address,indent_shipper_name,indent_shipper_phone,indent_shipper_postcode,indent_shipper_address,indent_situation) values(?,?,?,?,?,?,?,?,?,3)";
		try {
			 return base.update(sql, new Object[]{indent.getIndent_time(),
					indent.getIndent_receiver_name(),
					indent.getIndent_receiver_phone(),
					indent.getIndent_receiver_postcode(),
					indent.getIndent_receiver_address(),
					indent.getIndent_shipper_name(),
					indent.getIndent_shipper_phone(),
					indent.getIndent_shipper_postcode(),
					indent.getIndent_shipper_address()});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	@Override
	//修改订单表中的某一条数据
	public void updateIndent(Indent indent) {
		// TODO Auto-generated method stub
		String sql="update indent set indent_receiver_name=?, " +
				" indent_receiver_phone=?,indent_receiver_postcode=?," +
				" indent_receiver_address=?," +
				" indent_shipper_name=?,indent_shipper_phone=?," +
				" indent_shipper_postcode=?,indent_shipper_address=?" +
				" indent_situation=? where indent_id=?";
		try {
			base.update(sql, new Object[]{indent.getIndent_receiver_name(),
					indent.getIndent_receiver_phone(),
					indent.getIndent_receiver_postcode(),
					indent.getIndent_receiver_address(),
					indent.getIndent_shipper_name(),
					indent.getIndent_shipper_phone(),
					indent.getIndent_shipper_postcode(),
					indent.getIndent_shipper_address(),indent.getIndent_id(),
					indent.getIndent_situation()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	//根据ID查询订单表中的此ID详细信息
	public List findIndentById(Indent indent) {
		// TODO Auto-generated method stub
		String sql="select indent.*,cargo.cargo_weight,cargo.cargo_size,"
				+ " cargo.cargo_type,cargo.cargo_explain from indent "
				+ " join cargo on(indent.indent_id=cargo.cargo_indent) where indent.indent_id=?";
		try {
			List list=base.query(sql, new Object[]{indent.getIndent_id()});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询订单表中所有状态为出库的ID
	 */
	@Override
	public List findIndentId() {
		// TODO Auto-generated method stub
		String sql="select indent.indent_id from indent where indent_situation=\"出库\"";
		try {
			List list=base.query(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询所有状为待审核的订单信息并且出发网点属于哪个网点
	 */
	@Override
	public List findAuditIndent(int stat) {
		// TODO Auto-generated method stub
		String sql="select * from indent " + 
				" left join situation on indent.indent_situation=situation.situation_id " + 
				" left join cargo on indent.indent_id=cargo.cargo_indent " + 
				" left join type on cargo.cargo_type=type.type_id " + 
				" where indent.indent_situation=3 and indent_shipper_address=?  ";
		try {
			List list=base.queryMap(sql, new Object[] {stat});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 把状态为待审核的订单状态改为入库的状态
	 */
	@Override
	public void updateAuditIndent(Indent indent) {
		// TODO Auto-generated method stub
		String sql="update indent set indent_situation=replace(indent_situation,'3','2') where indent_id=?";
		try {
			base.update(sql,new Object[]{indent.getIndent_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有订单为未出库状态的订单信息根据入库记录查询
	 */
	@Override
	public List findComeinIndent(int stat) {
		// TODO Auto-generated method stub
		String sql="select * from indent \r\n" + 
				" left join situation on indent.indent_situation=situation.situation_id   " + 
				" left join cargo on indent.indent_id=cargo.cargo_indent " + 
				" left join type on cargo.cargo_type=type.type_id  " + 
				" left join comein on indent.indent_id=comein.comein_indent " + 
				" where indent.indent_situation=2 and comein.comein_station=?";
		try {
			List list=base.queryMap(sql, new Object[] {stat});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询所有订单为来货未出库状态的订单信息根据出库查询
	 */
	@Override
	public List findComegoHomeIndent(int stat) {
		// TODO Auto-generated method stub
		String sql="select * from indent \r\n" + 
				" left join situation on indent.indent_situation=situation.situation_id   " + 
				" left join cargo on indent.indent_id=cargo.cargo_indent " + 
				" left join type on cargo.cargo_type=type.type_id  " + 
				" left join comein on indent.indent_id=comein.comein_indent " + 
				" where indent.indent_situation=7 and comein.comein_station=?";
		try {
			List list=base.queryMap(sql, new Object[] {stat});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 把状态为未出库的订单状态改为未发车的状态
	 */
	@Override
	public void updateComeinIndent(Indent indent) {
		// TODO Auto-generated method stub
		String sql="update indent set indent_situation=replace(indent_situation,'2','1') where indent_id=?";
		try {
			base.update(sql, new Object[] {indent.getIndent_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有订单为未发车状态的订单信息
	 */
	@Override
	public List findComegoIndent(int stat) {
		// TODO Auto-generated method stub
		String sql="select * from indent  " + 
				" left join situation on indent.indent_situation=situation.situation_id   " + 
				" left join cargo on indent.indent_id=cargo.cargo_indent  " + 
				" left join type on cargo.cargo_type=type.type_id  " + 
				" left join comego on indent.indent_id=comego.comego_indent " + 
				" where indent.indent_situation=1 and comego.comego_station=? ";
		try {
			List list=base.queryMap(sql, new Object[] {stat});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 把状态为未发车的订单状态改为运输中状态
	 */
	@Override
	public void updateComegoIndent(Indent indent) {
		// TODO Auto-generated method stub
		String sql="update indent set indent_situation=replace(indent_situation,'1','5') where indent_id=?";
		try {
			base.update(sql, new Object[] {indent.getIndent_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据订单ID查询出该订单的的出发网点
	 */
	@Override
	public List findIndentStation(Indent indent) {
		// TODO Auto-generated method stub
		String sql="select indent_shipper_address from indent where indent_id=?";
		try {
			List list=base.queryMap(sql, new Object[] {indent.getIndent_id()});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据订单ID查询出该订单的出发网点的空闲车辆
	 */
	@Override
	public List findCarStation(int stat) {
		// TODO Auto-generated method stub
		String sql="select car.car_id,car.car_code from car   " + 
				" left join station on car.car_belong_station=station.station_id   " + 
				" left join way way on way.way_car=car.car_id    " + 
				" where car.car_state in(2,3) and car.car_belong_station=?  ";
		try {
			List list=base.queryMap(sql, new Object[] {stat});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据网点查询ID与车辆状态1与5查询车辆
	 */
	@Override
	public List findCarGohomeStation(int stat) {
		// TODO Auto-generated method stub
		String sql="select car.car_id,car.car_code from car   " + 
				" left join station on car.car_belong_station=station.station_id   " + 
				" left join way way on way.way_car=car.car_id    " + 
				" where car.car_state in(1,5) and way.way_direction=?  ";
		try {
			List list=base.queryMap(sql, new Object[] {stat});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据订单ID查询出该订单的到达网点
	 */
	@Override
	public List findArriveStation(Indent indent) {
		// TODO Auto-generated method stub
		String sql="select indent_shipper_address from indent where indent_id=?";
		try {
			List list=base.queryMap(sql, new Object[] {indent.getIndent_id()});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据订单ID查询出该订单的出发网点的空闲司机
	@Override
	public List findWorkerStation(int i) {
		// TODO Auto-generated method stub
		String sql="select worker.worker_id,worker.worker_name from worker " + 
				" left join station on station.station_id=worker.worker_station " + 
				" where  worker.worker_post=3 and worker.worker_status=4 and worker.worker_station=?";
		try {
			List list=base.queryMap(sql, new Object[] {i});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据车辆ID修改车辆车辆状态
	 */
	@Override
	public void updateCarState(Car car) {
		// TODO Auto-generated method stub
		String sql="update car set car_state=1 where car_id=?";
		try {
			base.update(sql, new Object[] {car.getCar_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * 根据车辆ID修改车辆车辆状态5-3
	 */
	@Override
	public void updateGoHomeCarState(Car car) {
		// TODO Auto-generated method stub
		String sql="update car set car_state=3 where car_id=?";
		try {
			base.update(sql, new Object[] {car.getCar_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * 根据车辆ID修改车辆状态
	 */
	@Override
	public void updateCarGohomeState(Car car) {
		// TODO Auto-generated method stub
		String sql="update car set car_state=3 where car_id=?";
		try {
			base.update(sql, new Object[] {car.getCar_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	/**
	 *	根据员工ID修改员工状态
	 */
	public void updateWorker(Worker worker) {
		String sql="update worker set worker_status=3 where worker_id=?";
		try {
			base.update(sql, new Object[] {worker.getWorker_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据ID进行异常订单的处理
	 */
	@Override
	public void updateFaleIndentSituation(Indent indent) {
		// TODO Auto-generated method stub
		String sql="update indent set indent_situation=replace(indent_situation,'3','6') where indent_id=?";
		try {
			base.update(sql, new Object[] {indent.getIndent_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询当天订单的数量
	 */
	@Override
	public List nowDateIndent() {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(indent.indent_id) as sum FROM indent " + 
				" WHERE TO_DAYS( NOW( ) ) = TO_DAYS(indent.indent_time)";
		try {
			List list=base.queryMap(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  查询前一天订单的数量
	 */
	@Override
	public List nowBeforeDateIndent() {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(indent.indent_id) as sum FROM indent WHERE \r\n" + 
				"TO_DAYS( NOW( ) ) - TO_DAYS( indent_time) = 1";
		try {
			List list=base.queryMap(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据ID查询此订单的信息信息
	 */
	@Override
	public List selectById(Indent indent) {
		// TODO Auto-generated method stub
		String sql="select * from indent where indent_id=?";
		return base.query(sql, new Object[] {indent.getIndent_id()});
	}
	/**
	 * 查询两天前的订单数量
	 */
	@Override
	public List nowBeforeIndent() {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(indent.indent_id) as sum FROM indent WHERE  " + 
				"TO_DAYS( NOW( ) ) - TO_DAYS( indent_time) = 2";
		try {
			List list=base.queryMap(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询三天的订单数量以及时间
	 * 
	 * 当天订单数量
	 */
	@Override
	public List nowDate() {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(indent.indent_id) as sum,indent_time FROM indent  " + 
				" WHERE TO_DAYS( NOW( ) ) = TO_DAYS(indent.indent_time)";
		try {
			List list=base.queryMap(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 一天前的订单数量
	 */
	@Override
	public List beforeDate() {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(indent.indent_id) as sum,indent_time FROM indent WHERE  \r\n" + 
				"TO_DAYS( NOW( ) ) - TO_DAYS( indent_time) = 1 ";
		try {
			List list=base.queryMap(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 两天前的订单数量
	 */
	@Override
	public List beforDate() {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(indent.indent_id) as sum,indent_time FROM indent WHERE   " + 
				" TO_DAYS( NOW( ) ) - TO_DAYS( indent_time) = 2 ";
		try {
			List list=base.queryMap(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 增加一个出库记录同时将订单状态改为完成状态并且到达网点属于哪个网点
	 */
	@Override
	public void arriveIndent(Indent indent) {
		// TODO Auto-generated method stub
		String sql="update indent set indent_situation=replace(indent_situation,'7','4') where indent_id=? ";
		try {
			base.update(sql, new Object[] {indent.getIndent_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 将订单状态从5变为2;
	 */
	@Override
	public void updateComeinIndentSituation(Indent indent){
		String sql="update indent set indent_situation=7 where indent_id=?";
		base.update(sql, new Object[] {indent.getIndent_id()});
	}

}
