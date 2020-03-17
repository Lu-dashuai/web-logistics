package com.lightning.action.yuhaiyang;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangjia.Worker;
import com.lightning.bean.wangzelong.Cargo;
import com.lightning.bean.wangzelong.Type;
import com.lightning.bean.wuminghui.Car;
import com.lightning.bean.yuhaiyang.Comego;
import com.lightning.bean.yuhaiyang.Comein;
import com.lightning.bean.yuhaiyang.Indent;
import com.lightning.bean.yuhaiyang.Time;
import com.lightning.dao.impl.wangzelong.CargoDaoImpl;
import com.lightning.dao.impl.wangzelong.TypeDaoImpl;
import com.lightning.dao.impl.yuhaiyang.ComegoDaoImpl;
import com.lightning.dao.impl.yuhaiyang.ComeinDaoImpl;
import com.lightning.dao.impl.yuhaiyang.IndentDaoImpl;
import com.lightning.dao.impl.yuhaiyang.TimeDaoImpl;
import com.lightning.dao.wangzelong.CargoDao;
import com.lightning.dao.wangzelong.TypeDao;
import com.lightning.dao.yuhaiyang.ComegoDao;
import com.lightning.dao.yuhaiyang.ComeinDao;
import com.lightning.dao.yuhaiyang.IndentDao;
import com.lightning.dao.yuhaiyang.TimeDao;
@Namespace("/Indent")
public class IndentAction extends BaseAction {
	private Indent indent=new Indent();
	private IndentDao indentdao=new IndentDaoImpl();
	private Cargo cargo;
	private CargoDao cargodao=new CargoDaoImpl();
	private List tabIndent;
	private List tabCargo;
	private List rowCargo;
	private List rowIndent;
	private Type type;
	private TypeDao typedao=new TypeDaoImpl();
	private List tabType;
	private String ind;
	private Comein comein=new Comein();
	private ComeinDao comeindao=new ComeinDaoImpl();
	private Comego comego=new Comego();
	private ComegoDao comegodao=new ComegoDaoImpl();
	private String carvalue;
	private String idid;
	private Worker worker=new Worker();
	/*private String workervalue;*/
	private Car car=new Car();
	/*private Worker worker=new Worker();*/
	private Time time=new Time();
	private TimeDao timedao=new TimeDaoImpl();
	private int timedate;
	/**
	 * 查询所有的订单信息
	 * @return
	 */
	@Action(value="findIndent")
	public String findIndent(){
		tabIndent=indentdao.findIndent();
		String strIndent=JSON.toJSONString(tabIndent);
		print(strIndent);
		return null;
	}
	/**
	 * 增加一条订单信息 type="chain" 转发
	 * @return
	 */
	@Action(value="insertIndent",results={@Result(name="success",location="/before/yuhaiyang/showIndent.jsp")})
	public String insertIndent(){
		int key=indentdao.insertIndent(indent);
		cargo.setCargo_indent(key);
		cargodao.insertCargo(cargo);
		return "success";
	}
	/**
	 * 删除一条订单信息
	 * @return
	 */
	@Action(value="deleteIndent")
	public String deleteIndent(){
		indentdao.deleteIndent(indent);
		return "success";
	}
	/**
	 * 根据ID查询某一条订单信息
	 * @return
	 */
	@Action(value="showOneIndent",results={@Result(name="success",location="/before/yuhaiyang/showOneIndent.jsp")})
	public String showOneIndent(){
		tabIndent=indentdao.findIndentById(indent);
		rowIndent=(List) tabIndent.get(0);
		tabType=typedao.findType();
		return "success";
	}
	/**
	 * 修改某一条订单信息
	 * @return
	 */
	@Action(value="updateIndent",results={@Result(name="success",location="/before/yuhaiyang/showIndent.jsp")})
	public String updateIndent(){
		indentdao.updateIndent(indent);
		cargodao.updateCargo(cargo);
		return "success";
	}
	/**
	 * 查询所有订单为待审核状态的订单信息
	 * @return
	 */
	@Action(value="auditIndent")
	public String auditIndent(){
		worker= (Worker) getSession().get("worker");
		int stat=worker.getWorker_station();
		tabIndent=indentdao.findAuditIndent(stat);
		String strIndent=JSON.toJSONString(tabIndent);
		print(strIndent);
		return null;
	}
	/**
	 * 审核订单信息进行入库操作并进行入库记录的增加
	 * @return
	 */
	@Action(value="updateAuditIndentSituation")
	public String updateAuditIndentSituation() {
		String[] str=ind.split(",");
		for(int i=0;i<str.length;i++) {
			indent.setIndent_id(Integer.parseInt(str[i]));
			indentdao.updateAuditIndent(indent);
			List stationList=indentdao.findIndentStation(indent);
			Map map=(Map) stationList.get(0);
			String stationId=(String) map.get("indent_shipper_address");
			comein.setComein_station(Integer.parseInt(stationId));
			comein.setComein_indent(Integer.parseInt(str[i]));
			 Date date1 = new Date();   
		     SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
		     String str1 = sdf1.format(date1);  
			comein.setComein_time(str1);
			comeindao.insertComegoin(comein);
		}
		print("审核成功");
		return null;
	}
	/**
	 * 异常订单处理
	 * @return
	 */
	@Action(value="updateFalseIndentSituation")
	public String updateFalseIndentSituation() {
		String[] str=ind.split(",");
		for(int i=0;i<str.length;i++) {
			indent.setIndent_id(Integer.parseInt(str[i]));
			indentdao.updateFaleIndentSituation(indent);
		}
		print("审核成功");
		return null;
	}
	/**
	 * 查询所有订单为未出库状态的订单信息根据入库订单id
	 * @return
	 */
	@Action(value="comeinIndent")
	public String comeinIndent(){
		worker= (Worker) getSession().get("worker");
		int stat=worker.getWorker_station();
		tabIndent=indentdao.findComeinIndent(stat);
		String strIndent=JSON.toJSONString(tabIndent);
		print(strIndent);
		return null;
	}
	/**
	 * 查询所有订单为来货未出库状态的订单信息根据出库订单id
	 * @return
	 */
	@Action(value="comeinHomeIndent")
	public String comeinHomeIndent(){
		worker= (Worker) getSession().get("worker");
		int stat=worker.getWorker_station();
		tabIndent=indentdao.findComegoHomeIndent(stat);
		String strIndent=JSON.toJSONString(tabIndent);
		print(strIndent);
		return null;
	}
	/**
	 * 审核未出库订单信息进行未发车操作并进行出库记录的增加
	 * @return
	 */
	@Action(value="updateComeinIndentSituation")
	public String updateComeinIndentSituation() {
		String[] str=ind.split(",");
		for(int i=0;i<str.length;i++) {
			indent.setIndent_id(Integer.parseInt(str[i]));
			//indentdao.updateAuditIndent(indent);
			indentdao.updateComeinIndent(indent);
			comego.setComego_indent(Integer.parseInt(str[i]));
			List stationList=indentdao.findArriveStation(indent);
			Map map=(Map) stationList.get(0);
			String stationId=(String) map.get("indent_shipper_address");
			comego.setComego_station(Integer.parseInt(stationId));
			 Date date1 = new Date();   
		     SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
		     String str1 = sdf1.format(date1);  
			comego.setComego_time(str1);
			comegodao.insertCome(comego);
		}
		print("审核成功");
		return null;
	}
	/**
	 * 查询所有订单为未发车状态的订单信息
	 * @return
	 */
	@Action(value="comegoIndent")
	public String comegoIndent(){
		worker= (Worker) getSession().get("worker");
		int stat=worker.getWorker_station();
		tabIndent=indentdao.findComegoIndent(stat);
		String strIndent=JSON.toJSONString(tabIndent);
		print(strIndent);
		return null;
	}
	/**
	 * 查出所有状态为空闲的车辆以及司机
	 * @return
	 */
	@Action(value="findCarWorker")
	public String findCarWorker() {
		worker= (Worker) getSession().get("worker");
		int stat=worker.getWorker_station();
		//System.out.println(stat);
		String[] str=ind.split(",");
		String strCarWorker = null;
		for(int i=0;i<str.length;i++) {
			//indent.setIndent_id(Integer.parseInt(str[i]));
			indent.setIndent_shipper_address((str[i]));
			List carlist=indentdao.findCarStation(stat);
			List workerlist=indentdao.findWorkerStation(stat);
			List list=new ArrayList();
			Map map=new HashMap();
			map.put("carlist", carlist);
			map.put("workerlist", workerlist);
			list.add(map);
			strCarWorker=JSON.toJSONString(list);
		}
		print(strCarWorker);
		return null;
	}
	/**
	 * 根据订单ID查询出该订单的到达网点的空闲车辆
	 * @return
	 */
	@Action(value="findCarGohomeWorker")
	public String findCarGohomeWorker() {
		worker= (Worker) getSession().get("worker");
		int stat=worker.getWorker_station();
		String[] str=idid.split(",");
		String strCarWorker = null;
		for(int i=0;i<str.length;i++) {
			//indent.setIndent_id(Integer.parseInt(str[i]));
			indent.setIndent_receiver_address(str[i]);
			List carlist=indentdao.findCarGohomeStation(stat);
			List workerlist=indentdao.findWorkerStation(stat);
			List list=new ArrayList();
			Map map=new HashMap();
			map.put("carlist", carlist);
			map.put("workerlist", workerlist);
			list.add(map);
			strCarWorker=JSON.toJSONString(list);
		}
		print(strCarWorker);
		return null;
	}
	
	
	/**
	 * 根据订单ID将车辆ID加到出库记录表中  并且将车辆状态改为运输中  司机状态改为驾驶中 并将订单状态改为运输中
	 * @return
	 */
	/*@Action(value="insertCarWorker")
	public String insertCarWorker() {
		//String[] str=ind.split(",");
		String[] strr=idid.split(",");
		//for(int i=0;i<str.length;i++) {
			for(int j=0;j<strr.length;j++) {
				//System.out.println(str[i]);//测试ind 未发货地址
				//System.out.println(strr[j]);//测试idid订单id
				indent.setIndent_id(Integer.parseInt(strr[j]));
				comego.setComego_car(Integer.parseInt(carvalue));
				comego.setComego_indent(Integer.parseInt(strr[j]));//将修改i修改为了j
				//indent.setIndent_id(Integer.parseInt(str[i]));
				comegodao.insertComegoCar(comego);
				car.setCar_id(Integer.parseInt(carvalue));
				indentdao.updateCarState(car);
				worker.setWorker_id(Integer.parseInt(workervalue));
				indentdao.updateWorker(worker);
				indentdao.updateComegoIndent(indent);
		}//}
		print("发车成功");
		return null;
	}*/
	@Action(value="insertCarWorker")
	public String insertCarWorker() {
		//String[] str=ind.split(",");
		String[] strr=idid.split(",");
		//for(int i=0;i<str.length;i++) {
			for(int j=0;j<strr.length;j++) {
				//System.out.println(str[i]);//测试ind 未发货地址
				//System.out.println(strr[j]);//测试idid订单id
				indent.setIndent_id(Integer.parseInt(strr[j]));
				comego.setComego_car(Integer.parseInt(carvalue));
				comego.setComego_indent(Integer.parseInt(strr[j]));//将i修改为了j
				//indent.setIndent_id(Integer.parseInt(str[i]));
				comegodao.insertComegoCar(comego);
				car.setCar_id(Integer.parseInt(carvalue));
				indentdao.updateCarState(car);
				/*worker.setWorker_id(Integer.parseInt(workervalue));*/
				/*indentdao.updateWorker(worker);*/
				indentdao.updateComegoIndent(indent);
				/*增加time表中的数据   车辆id 以及  发车时间*/
				time.setTime_car_id(car.getCar_id());
		}//}
		//获取当前时间
		Date date1 = new Date();   
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String str1 = sdf1.format(date1); 
		time.setTime_start(str1);
		time.setTime_date(timedate);
		timedao.insertTime(time);
		print("发车成功");
		return null;
	}
	
	
	/**
	 * 根据订单ID将车辆ID加到出库记录表中  并且将车辆状态改为运输中  司机状态改为驾驶中 并将订单状态改为运回中5-3
	 * @return
	 */
	@Action(value="insertGoHomeCarWorker")
	public String insertGoHomeCarWorker() {
		/*String[] str=ind.split(",");*/
		String[] strr=idid.split(",");
		/*for(int i=0;i<str.length;i++) {*/
			for(int j=0;j<strr.length;j++) {
				indent.setIndent_id(Integer.parseInt(strr[j]));
				//System.out.println(strr[j]);
				comego.setComego_car(Integer.parseInt(carvalue));
				comego.setComego_indent(Integer.parseInt(strr[j]));
				//indent.setIndent_id(Integer.parseInt(str[i]));
				comegodao.insertComegoCar(comego);
				car.setCar_id(Integer.parseInt(carvalue));
				indentdao.updateGoHomeCarState(car);
				/*worker.setWorker_id(Integer.parseInt(workervalue));*/
				/*indentdao.updateWorker(worker);*/
				indentdao.updateComegoIndent(indent);
				/*增加time表中的数据   车辆id 以及  发车时间*/
				time.setTime_car_id(car.getCar_id());
				//获取当前时间
		/*}*/}
		Date date1 = new Date();   
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String str1 = sdf1.format(date1); 
		time.setTime_start(str1);
		time.setTime_date(timedate);
		timedao.insertTime(time);
		print("发车成功");
		return null;
	}
	
	
	/**
	 * 根据订单ID将车辆ID加到出库记录表中  并且将车辆状态改为运输中  司机状态改为驾驶中 并将订单状态改为运输中
	 * @return
	 */
	@Action(value="insertCarGohomeWorker")
	public String insertCarGohomeWorker() {
		String[] str=ind.split(",");
		String[] strr=idid.split(",");
		for(int i=0;i<str.length;i++) {
			for(int j=0;j<strr.length;j++) {
				comego.setComego_car(Integer.parseInt(carvalue));
				comego.setComego_indent(Integer.parseInt(str[i]));
				indent.setIndent_id(Integer.parseInt(strr[j]));
				comegodao.insertComegoCar(comego);
				car.setCar_id(Integer.parseInt(carvalue));
				indentdao.updateCarGohomeState(car);
				/*worker.setWorker_id(Integer.parseInt(workervalue));*/
				/*indentdao.updateWorker(worker);*/
				indentdao.updateComegoIndent(indent);
		}}
		print("发车成功");
		return null;
	}
	
	/**
	 * 查询出当天订单的数量，并进行统计表的生成
	 * @return
	 */
	@Action(value="findNowDateIndent")
	public String findNowDateIndent () {
		List list=indentdao.nowDateIndent();
		String strIndent=JSON.toJSONString(list);
		print(strIndent);
		return null;
	}
	/**
	 * 查询出前一天订单的数量，并进行统计表的生成
	 * @return
	 */
	@Action(value="findBeforeDateIndent")
	public String findBeforeDateIndent() {
		List list=indentdao.nowBeforeDateIndent();
		String strIndent=JSON.toJSONString(list);
		print(strIndent);
		return null;
	}
	/**
	 * 查询出前两天订单的数量，并进行统计表的生成
	 * @return
	 */
	@Action(value="findBeforeIndent")
	public String findBeforeIndent() {
		List list=indentdao.nowBeforeIndent();
		String strIndent=JSON.toJSONString(list);
		print(strIndent);
		return null;
	}
	/**
	 * 查询出三天的全部订单
	 * @return
	 */
	@Action(value="findDateIndent")
	public String findDateIndent() {
		List list=indentdao.nowDate();
		List list1=indentdao.beforeDate();
		List list2=indentdao.beforDate();
		List datelist=new ArrayList();
		datelist.add(list);
		datelist.add(list2);
		datelist.add(list1);
		String strIndent=JSON.toJSONString(datelist);
		print(strIndent);
		return null;
	}
	/**
	 * 根据订单ID增加一个出库记录并将订单状态改为完成状态
	 * @return
	 */
	@Action(value="arriveIndentSituation")
	public String arriveIndentSituation() {
		worker= (Worker) getSession().get("worker");
		int stat=worker.getWorker_station();
		String[] strr=idid.split(",");
		for(int i=0;i<strr.length;i++) {
			indent.setIndent_id(Integer.parseInt(strr[i]));
			indentdao.arriveIndent(indent);
			comego.setComego_indent(Integer.parseInt(strr[i]));
			comego.setComego_station(stat);
			Date date1 = new Date();   
		    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
		    String str1 = sdf1.format(date1);  
			comego.setComego_time(str1);
			comegodao.insertCome(comego);
		}
		print("订单完成");
		return null;
	}
	
	
	
	public Indent getIndent() {
		return indent;
	}
	public void setIndent(Indent indent) {
		this.indent = indent;
	}
	public IndentDao getIndentdao() {
		return indentdao;
	}
	public void setIndentdao(IndentDao indentdao) {
		this.indentdao = indentdao;
	}
	public List getTabIndent() {
		return tabIndent;
	}
	public void setTabIndent(List tabIndent) {
		this.tabIndent = tabIndent;
	}
	public List getRowIndent() {
		return rowIndent;
	}
	public void setRowIndent(List rowIndent) {
		this.rowIndent = rowIndent;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public CargoDao getCargodao() {
		return cargodao;
	}
	public void setCargodao(CargoDao cargodao) {
		this.cargodao = cargodao;
	}
	public List getTabCargo() {
		return tabCargo;
	}
	public void setTabCargo(List tabCargo) {
		this.tabCargo = tabCargo;
	}
	public List getRowCargo() {
		return rowCargo;
	}
	public void setRowCargo(List rowCargo) {
		this.rowCargo = rowCargo;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public TypeDao getTypedao() {
		return typedao;
	}
	public void setTypedao(TypeDao typedao) {
		this.typedao = typedao;
	}
	public List getTabType() {
		return tabType;
	}
	public void setTabType(List tabType) {
		this.tabType = tabType;
	}
	
	
	public String getInd() {
		return ind;
	}
	public void setInd(String ind) {
		this.ind = ind;
	}
	public Comein getComein() {
		return comein;
	}
	public void setComein(Comein comein) {
		this.comein = comein;
	}
	public ComeinDao getComeindao() {
		return comeindao;
	}
	public void setComeindao(ComeinDao comeindao) {
		this.comeindao = comeindao;
	}
	public Comego getComego() {
		return comego;
	}
	public void setComego(Comego comego) {
		this.comego = comego;
	}
	public ComegoDao getComegodao() {
		return comegodao;
	}
	public void setComegodao(ComegoDao comegodao) {
		this.comegodao = comegodao;
	}
	public String getCarvalue() {
		return carvalue;
	}
	public void setCarvalue(String carvalue) {
		this.carvalue = carvalue;
	}
	/*public String getWorkervalue() {
		return workervalue;
	}
	public void setWorkervalue(String workervlaue) {
		this.workervalue = workervlaue;
	}*/
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	/*public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}*/
	public String getIdid() {
		return idid;
	}
	public void setIdid(String idid) {
		this.idid = idid;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public TimeDao getTimedao() {
		return timedao;
	}
	public void setTimedao(TimeDao timedao) {
		this.timedao = timedao;
	}
	public int getTimedate() {
		return timedate;
	}
	public void setTimedate(int timedate) {
		this.timedate = timedate;
	}
	
	
}
