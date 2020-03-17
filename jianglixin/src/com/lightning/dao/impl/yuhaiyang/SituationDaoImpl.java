package com.lightning.dao.impl.yuhaiyang;

import java.util.List;

import com.lightning.dao.base.BaseDao;
import com.lightning.dao.yuhaiyang.SituationDao;

public class SituationDaoImpl implements SituationDao {

	@Override
	public List findSituation() {
		// TODO Auto-generated method stub
		String sql="select * from situation";
		try {
			List list=BaseDao.query(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
