package com.lightning.dao.wangzelong;

import java.util.List;

import com.lightning.bean.wangzelong.Type;

public interface TypeDao {
	//type类的接口
	List findType();
	List findOneType(Type type);
	void deleteType(Type type);
	void updateType(Type type);
	void insertType(Type type);
}
