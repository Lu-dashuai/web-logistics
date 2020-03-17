package com.lightning.dao.impl.yuhaiyang;

import java.util.List;

import com.lightning.bean.yuhaiyang.Comein;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.yuhaiyang.ComeinDao;

public class ComeinDaoImpl implements ComeinDao {

	BaseDao base=new BaseDao();
	@Override
	public void insertComegoin(Comein comein) {
		// TODO Auto-generated method stub
		String sql="insert into comein(comein_indent,comein_time,comein_station)  values(?,?,?)";
		try {
			base.update(sql, new Object[] {comein.getComein_indent(),comein.getComein_time(),comein.getComein_station()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据id查询网店用来判断预登陆账户一样
	@Override
	public List findComeinId(int id) {
		String sql="select comein_station from comein where comein_id=(select max(comein_id) from comein where comein_indent=?)";
		return base.query(sql, new Object[] {id});
	}
}
