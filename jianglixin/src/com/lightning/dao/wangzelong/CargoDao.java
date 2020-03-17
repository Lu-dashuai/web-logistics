package com.lightning.dao.wangzelong;

import java.util.List;

import com.lightning.bean.wangzelong.Cargo;

public interface CargoDao {
	//cargo类的接口
	List findCargo(Cargo cargo);
	List findOneCargo(Cargo cargo);
	void deleteCargo(Cargo cargo);
	void updateCargo(Cargo cargo);
	void insertCargo(Cargo cargo);
}
