package com.lightning.dao.yuhaiyang;

import java.util.List;

import com.lightning.bean.wangjia.Worker;
import com.lightning.bean.wuminghui.Car;
import com.lightning.bean.yuhaiyang.Indent;

public interface IndentDao {
	//查询订单表的详细信息
	public List findIndent();
	//删除订单表的信息
	public void deleteIndent(Indent indent);
	//添加订单表的信息
	public int insertIndent(Indent indent);
	//修改订单表中的某一条数据
	public void updateIndent(Indent indent);
	//根据ID查询订单表中的此ID详细信息
	public List findIndentById(Indent indent);
	//查询订单表中所有状态为出库的ID
	public List findIndentId();
	//查询所有订单为待审核状态的订单信息
	public List findAuditIndent(int stat);
	//把状态为待审核的订单状态改为入库的状态
	public void updateAuditIndent(Indent indent);
	//根据订单ID查询出该订单的的出发网点
	public List findIndentStation(Indent indent);
	//查询所有订单为未出库状态的订单信息
	public List findComeinIndent(int stat);
	//把状态为未出库的订单状态改为未发车状态
	public void updateComeinIndent(Indent indent);
	//根据订单ID查询出该订单的到达网点
	public List findArriveStation(Indent indent);
	//查询所有订单为未发车状态的订单信息
	public List findComegoIndent(int stat);
	//把状态为未发车的订单状态改为运输中状态
	public void updateComegoIndent(Indent indent);
	//根据订单ID查询出该订单的出发网点的空闲车辆
	public List findCarStation(int stat);
	//根据订单ID查询出该订单的出发网点的空闲司机
	public List findWorkerStation(int i);
	//根据车辆ID修改车辆车辆状态
	public void updateCarState(Car car);
	//根据员工ID修改员工状态
	public void updateWorker(Worker worker);
	//根据ID进行异常订单的处理
	public void updateFaleIndentSituation(Indent indent) ;
	//根据订单ID查询出该订单的到达网点的空闲车辆
	public List findCarGohomeStation(int stat);
	//根据车辆ID修改车辆状态
	public void updateCarGohomeState(Car car);
	//查询当天订单的数量
	public List nowDateIndent();
	//查询前一天订单数量
	public List nowBeforeDateIndent();
	//查询前两天订单数量
	public List nowBeforeIndent();
	//根据ID查询此订单的信息信息
	public List selectById(Indent indent);
	//查询三天的订单数量以及时间
	public List nowDate();
	public List beforeDate();
	public List beforDate();
	//增加一个出库记录同时将订单状态改为完成状态
	public void arriveIndent(Indent indent );
	//将订单由5改为2
	public void updateComeinIndentSituation(Indent indent);
	// 根据车辆ID修改车辆车辆状态 5-3
	void updateGoHomeCarState(Car car);
	//查询所有订单为未出库状态的订单信息根据出库查询
	public List findComegoHomeIndent(int stat);
}
