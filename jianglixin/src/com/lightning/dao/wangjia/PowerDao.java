package com.lightning.dao.wangjia;

import java.util.List;

import com.lightning.bean.wangjia.Power;


public interface PowerDao {
	void insertPower(Power power);//添加数据
	int deletePower(Power power);//删除数据
	void updatePower(Power power);//修改
	List findOnePower(Power power);//查找一条数据  为了  修改而使用
	List findPower();//查询所有
	List findWorkerPower(int workerid);//查询的当前登录这的权限
}
