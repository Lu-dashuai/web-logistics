package com.lightning.dao.impl.yuhaiyang;

import java.util.List;

import com.lightning.bean.wangjia.Worker;
import com.lightning.bean.yuhaiyang.Comego;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.yuhaiyang.ComegoDao;

public class ComegoDaoImpl implements ComegoDao {

	BaseDao base=new BaseDao();
	@Override
	public List findComego() {
		// TODO Auto-generated method stub
		Worker worker=new Worker();
		String sql="select indent.indent_id,come.comego_id,sit.situation_name,  " + 
				" come.comego_time,stat.station_name,type.cartype_name from indent  " + 
				" left join comego come on come.comego_indent=indent.indent_id " + 
				" left join situation sit on come.comego_situation=sit.situation_id   " + 
				" left join station stat on come.comego_station=stat.station_id   " + 
				" left join car car on come.comego_car=car.car_id  " + 
				" left join cartype type on car.car_type=type.cartype_id where 1=1 ";
				if(worker.getWorker_station()!=0){}
		/*String sql="select come.comego_id,come.comego_indent,sit.situation_name,come.comego_time,stat.station_address,type.cartype_name from comego come     " + 
				" left join situation sit on come.comego_situation=sit.situation_id  " + 
				" left join station stat on come.comego_station=stat.station_id  " + 
				" left join car car on come.comego_car=car.car_id  " + 
				" left join cartype type on car.car_type=type.cartype_id " + 
				" order by come.comego_id desc";*/
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
	public void insertComego(Comego comego) {
		// TODO Auto-generated method stub
		String sql="insert into comego(comego_indent,comego_time) values(?,?)";
		try {
			base.update(sql, new Object[]{comego.getComego_indent(),comego.getComego_time()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteComngo(Comego comego) {
		// TODO Auto-generated method stub
		String sql="delete from comego where comego_id=?";
		try {
			base.update(sql, new Object[]{comego.getComego_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateComego(Comego comego) {
		// TODO Auto-generated method stub
		String sql="update comego set comego_indent=?,comego_time=?,comego_station=? where comego_id=?";
		try {
			base.update(sql, new Object[]{comego.getComego_indent(),comego.getComego_time(),comego.getComego_station(),comego.getComego_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List findByIdComego(Comego comego) {
		// TODO Auto-generated method stub
		String sql="select comego.* ,station.station_address,car.car_type " + 
				" from comego join station on (comego.comego_station=station.station_id) " + 
				" join car on (comego.comego_car=car.car_id)  where comego.comego_id=?";
		try {
			List list=base.query(sql, new Object[]{comego.getComego_id()});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取所有订单的ID
	 */
	@Override
	public List findAllComego() {
		// TODO Auto-generated method stub
		String sql="select indent_id from indent";
		/*String sql="select indent_id from( " + 
				" select indent.indent_id as indent_id from indent " + 
				" union all " + 
				" select indent.indent_id as indent_id from indent  " + 
				" left join comego on indent.indent_id=comego.comego_indent " + 
				" left join situation on comego.comego_situation=situation.situation_id " + 
				" where situation.situation_name=\"出库\"  " + 
				" or situation.situation_name=\"入库\")a group by indent_id having count(indent_id)=1";*/
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
	 * 添加一个出库记录
	 */
	@Override
	public void insertCome(Comego comego) {
		// TODO Auto-generated method stub
		String sql="insert into comego(comego_indent,comego_time,comego_station)  values(?,?,?)";
		try {
			base.update(sql, new Object[] {comego.getComego_indent(),comego.getComego_time(),comego.getComego_station()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertComegoCar(Comego comego) {
		// TODO Auto-generated method stub
		String sql="update comego set comego_car=? where comego_indent=? ";
		try {
			base.update(sql, new Object[] {comego.getComego_car(),comego.getComego_indent()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List findComeinIndent(Comego comego) {
		// TODO Auto-generated method stub
		String sql="select comego_indent from comego cg left join indent ent on cg.comego_indent=ent.indent_id where cg.comego_car=? and ent.indent_situation=5";
		try {
			List list=base.query(sql, new Object[] {comego.getComego_car()});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
