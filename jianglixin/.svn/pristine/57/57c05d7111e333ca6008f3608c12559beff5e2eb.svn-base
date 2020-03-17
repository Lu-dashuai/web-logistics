package com.lightning.dao.impl.yuhaiyang;

import java.util.List;

import com.lightning.bean.yuhaiyang.Warehose;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.yuhaiyang.WarehoseDao;

public class WarehoseDaoImpl implements WarehoseDao {

	BaseDao base=new BaseDao();
	@Override
	//查询所有仓库
	public List findWarehose() {
		// TODO Auto-generated method stub
		String sql="select warehose.warehose_id,type.type,station.station_name,warehose.warehose_size from warehose  " + 
				" left join type on warehose.warehose_type=type.type_id  " + 
				" left join station on warehose.warehose_station=station.station_id";
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
	//增加一个仓库信息
	public void insertWarehose(Warehose warehose) {
		// TODO Auto-generated method stub
		String sql="insert into warehose(warehose_type,warehose_station,warehose_size) values(?,?,?)";
		try {
			base.update(sql, new Object[]{warehose.getWarehose_type(),warehose.getWarehose_station(),warehose.getWarehose_size()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	//删除一个仓库信息
	public void deleteWarehose(Warehose warehose) {
		// TODO Auto-generated method stub
		String sql="delete from warehose where warehose_id=?";
		try {
			base.update(sql, new Object[]{warehose.getWarehose_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	//修改仓库信息
	public void updateWarehose(Warehose warehose) {
		// TODO Auto-generated method stub
		String sql="update warehose set warehose_type=?,warehose_station=?,warehose_size=? where warehose_id=?";
		try {
			base.update(sql, new Object[]{warehose.getWarehose_type(),warehose.getWarehose_station(),warehose.getWarehose_size(),warehose.getWarehose_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	//根据ID查找仓库信息
	public List findWarehoseById(Warehose warehose) {
		// TODO Auto-generated method stub
		String sql="select warehose_id,warehose_type,warehose_station,warehose_size from warehose where warehose_id=?";
		try {
			List list=base.query(sql, new Object[]{warehose.getWarehose_id()});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
