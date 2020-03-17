package com.lightning.dao.impl.wangzelong;

import java.util.List;

import com.lightning.bean.wangzelong.Cargo;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangzelong.CargoDao;

public class CargoDaoImpl implements CargoDao{

	@Override
	public List findOneCargo(Cargo cargo) {
		//通过cargo_indent的查询4张表
		String sql="select ent.indent_id,ent.indent_time,ent.indent_shipper_name,ent.indent_shipper_phone,ent.indent_shipper_postcode,ent.indent_shipper_address,ent.indent_receiver_name,ent.indent_receiver_phone,ent.indent_receiver_postcode,ent.indent_receiver_address,"
				+ "cg.cargo_explain,cg.cargo_weight,cg.cargo_size,ty.type,"
				+ "acc.account_money "
				+ "from indent ent left join cargo cg on ent.indent_id=cg.cargo_indent left join account acc on ent.indent_id=acc.account_indent left join type ty on cg.cargo_type=ty.type_id"
				+ " where cargo_indent=?";
		return BaseDao.queryMap(sql, new Object[] {cargo.getCargo_indent()});
	}

	@Override
	public void deleteCargo(Cargo cargo) {
		// 删除cargo的单一信息
		String sql="delete from cargo where cargo_indent=?";
		BaseDao.update(sql, new Object[] {cargo.getCargo_indent()});
	}

	@Override
	public void updateCargo(Cargo cargo) {
		// 修改cargo的单一信息
		String sql="update cargo set cargo_weight=?,cargo_size=?,cargo_type=?,cargo_explain=? where cargo_indent=?";
		BaseDao.update(sql, new Object[] {cargo.getCargo_weight(),cargo.getCargo_size(),cargo.getCargo_type(),cargo.getCargo_explain(),cargo.getCargo_indent()});
	}

	@Override
	public void insertCargo(Cargo cargo) {
		//添加cargo表
		String sql="insert into cargo values(?,?,?,?,?)";
		BaseDao.update(sql, new Object[]{cargo.getCargo_indent(),cargo.getCargo_weight(),cargo.getCargo_size(),cargo.getCargo_type(),cargo.getCargo_explain()});
	}

	@Override
	public List findCargo(Cargo cargo) {
		//通过indent查询所有
		String sql="select * from cargo where cargo_indent=?";
		return BaseDao.query(sql, new Object[] {cargo.getCargo_indent()});
	}

}
