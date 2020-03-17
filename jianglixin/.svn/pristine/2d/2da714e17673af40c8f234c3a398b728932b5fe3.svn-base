package com.lightning.dao.impl.yuhaiyang;

import java.util.List;

import com.lightning.bean.yuhaiyang.Keeper;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.yuhaiyang.KeeperDao;

public class KeeperDaoImpl implements KeeperDao {

	BaseDao base=new BaseDao();
	@Override
	public List findKeeper() {
		// TODO Auto-generated method stub
		String sql="select keep.keeper_worker,wor.worker_name,keep.keeper_warehose,ware.warehose_type,type.type  from keeper keep  " + 
				" left join worker wor on keep.keeper_worker=wor.worker_id " + 
				" left join warehose ware on keep.keeper_warehose=ware.warehose_id " + 
				" left join type type on ware.warehose_type=type.type_id";
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
	public void insertKeeper(Keeper keeper) {
		// TODO Auto-generated method stub
		String sql="insert into keeper(keeper_worker,keeper_warehose) values(?,?)";
		try {
			base.update(sql, new Object[]{keeper.getKeeper_worker(),keeper.getKeeper_warehose()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteKeeper(Keeper keeper) {
		// TODO Auto-generated method stub
		String sql="delete from keeper where id=?";
		try {
			base.update(sql, new Object[]{keeper.getKeeper_worker()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateKeeper(Keeper keeper) {
		// TODO Auto-generated method stub
		String sql="update keeper set keeper_worker=?,keeper_warehose=? where keeper_worker=?";
		try {
			base.update(sql, new Object[]{keeper.getKeeper_worker(),keeper.getKeeper_warehose(),keeper.getKeeper_worker()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List findKeeperById(Keeper keeper) {
		// TODO Auto-generated method stub   联合查询worker  warehose 
		String sql="select keeper.*,worker.worker_name from keeper join worker "
				+ " on(keeper.keeper_worker=worker.worker_id) "
				+ " where keeper.keeper_worker=?";
		try {
			List list=base.query(sql, new Object[]{keeper.getKeeper_worker()});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
