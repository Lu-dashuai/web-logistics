package com.lightning.action.wangzelong;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangjia.Worker;
import com.lightning.bean.wuminghui.Car;
import com.lightning.bean.wuminghui.Station;
import com.lightning.bean.wuminghui.Way;
import com.lightning.bean.yuhaiyang.Comego;
import com.lightning.bean.yuhaiyang.Comein;
import com.lightning.bean.yuhaiyang.Indent;
import com.lightning.bean.yuhaiyang.Time;
import com.lightning.dao.impl.wuminghui.CarDaoImpl;
import com.lightning.dao.impl.wuminghui.StateDaoImpl;
import com.lightning.dao.impl.wuminghui.StationDaoImpl;
import com.lightning.dao.impl.wuminghui.WayDaoImpl;
import com.lightning.dao.impl.yuhaiyang.ComegoDaoImpl;
import com.lightning.dao.impl.yuhaiyang.ComeinDaoImpl;
import com.lightning.dao.impl.yuhaiyang.IndentDaoImpl;
import com.lightning.dao.impl.yuhaiyang.TimeDaoImpl;
import com.lightning.dao.wuminghui.CarDao;
import com.lightning.dao.wuminghui.StateDao;
import com.lightning.dao.wuminghui.StationDao;
import com.lightning.dao.wuminghui.WayDao;
import com.lightning.dao.yuhaiyang.ComegoDao;
import com.lightning.dao.yuhaiyang.ComeinDao;
import com.lightning.dao.yuhaiyang.IndentDao;
import com.lightning.dao.yuhaiyang.TimeDao;
@Namespace("/Comein")
public class ComeinAction extends BaseAction{
	private Way way=new Way();
	private Car car=new Car();
	private WayDao waydao=new WayDaoImpl();
	private CarDao cardao=new CarDaoImpl();
	private String params;
	private ComeinDao comeindao=new ComeinDaoImpl();
	private Comein comein=new Comein();
	private Comego comego=new Comego();
	private ComegoDao comegodao=new ComegoDaoImpl();
	private IndentDao indentdao=new IndentDaoImpl();
	private Indent indent=new Indent();
	private Time time=new Time();
	private TimeDao timedao=new TimeDaoImpl();

	
	@Action("findComeinCar")
	public String findComeinCar() {//查询运来的车辆
		List<List> tabWay=new ArrayList();
		Worker worker=(Worker) getSession().get("worker");
		way.setWay_direction(worker.getWorker_station());
		tabWay=waydao.findCarOnWay(way);
		List tabCar=new ArrayList();
		List tabCarBystation=waydao.findCarOnStation(worker.getWorker_station());
		Map tabstate=new HashMap();
		for(int i=0;i<tabCarBystation.size();i++) {
			tabCar.add(tabCarBystation.get(i));
		}
		for(List row:tabWay) {
			for(Object obj:row) {
				car.setCar_id((int)obj);
				tabstate=(Map) cardao.findComeinCar(car).get(0);
				if(tabstate.get("car_state").equals(1)) {//判断是否为运来的车辆
					tabCar.add(tabstate);
				}
			}
		}
		print(JSON.toJSONString(tabCar));
		return null;
	}
	@Action(value="ComeinStation")
	public String findComeinStation(){//替换网店信息
		StationDao stationdao=new StationDaoImpl();
		List tabStation=stationdao.findStation();
		print(JSON.toJSONString(tabStation));
		return null;
	}
	@Action(value="ComeinState")
	public String findComeinState() {//替换车信息
		StateDao statedao=new StateDaoImpl();
		List tabState=statedao.findState();
		print(JSON.toJSONString(tabState));
		return null;
	}
	
	@Action(value="comeinInsert")
	public String comeinInsert() throws ParseException {//添加入库单据，并修改车辆状态和修改订单入库状态
		Worker worker=(Worker) getSession().get("worker");
		way.setWay_direction(worker.getWorker_station());//获取worker中的所属网店
		String[] str=params.split(",");//获取前台选中的车辆id
		Date date1 = new Date();   
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
	    String str1 = sdf1.format(date1); //获取日期格式
	    List<List> carBelong=cardao.findGohomeCar(worker.getWorker_station());//根据网点获得所有车辆
	    List count=new ArrayList();
	    for(List row:carBelong) {
	    	for(Object obj:row) {
	    		count.add(obj);
	    	}
	    }
	    int x=0;//用来计数，不能卸货的车+1
	    for(int i=0;i<str.length;i++) {
	    	time.setTime_car_id(Integer.parseInt(str[i]));//将所选车辆id存入time的属性中
			List list=timedao.selectTime(time);//查询出发时间和预计到达时间
			List timelist=(List) list.get(0);
			String timein=timelist.get(0).toString();//车辆出发时间
			String tim=timelist.get(1).toString();//车辆运输时间
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date begin=sdf.parse(timein);//将车辆到达时间从string类型转化为java时间
			
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			     //SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String ti=format.format(date);//ti就是当前时间
			 //System.out.println("系统时间："+time);
			   
			SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 //java.util.Date begin=dfs.parse("2004-01-02 11:30:24");
			// java.util.Date end=dfs.parse("2004-01-02 11:33:25");
			java.util.Date end=dfs.parse(ti);
			 //java.util.Date end = dfs.parse("2004-03-26 13:31:40");
			long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
			 //System.out.println("相差秒："+between);
			 /*long day1=between/(24*3600);
			 long hour1=between%(24*3600)/3600;
			 long minute1=between%3600/60;
			 long second1=between%60%60;
			 System.out.println("相差时间："+""+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");*/
			long j=Integer.parseInt(tim)*60*60;//将运输时间装换成秒
			if(between<j) {
				x++;
			}
	    }
	    
	    if(x==0) {
			for(int i=0;i<str.length;i++) {
				if(count.contains(Integer.parseInt(str[i]))) {
					car.setCar_id(Integer.parseInt(str[i]));//设置car对象的属性
					cardao.updateGohomeCar(car);//修改为空闲状态
					comego.setComego_car(Integer.parseInt(str[i]));//设置comego对象的属性
					List<List> indents=comegodao.findComeinIndent(comego);//根据获取出库单的车辆id与获得运输中订单id
					comein.setComein_time(str1);//设置入库单的属性
					comein.setComein_station(way.getWay_direction());
					
					Date datel = new Date();   
				    SimpleDateFormat sdfl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				    String strl = sdfl.format(datel); 
					time.setTime_car_id(Integer.parseInt(str[i]));
					time.setTime_end(strl);
					timedao.updateTime(time);
					
					for(List row:indents) {//循环多单订单id
						for(Object obj:row) {
							comein.setComein_indent(Integer.parseInt(obj.toString()));
							comeindao.insertComegoin(comein);//添加入库单
							indent.setIndent_id(Integer.parseInt(obj.toString()));
							indentdao.updateComeinIndentSituation(indent);
						}
					}
				}else{
					car.setCar_id(Integer.parseInt(str[i]));//设置car对象的属性
					cardao.updateComeinCar(car);//修改为休息状态
					comego.setComego_car(Integer.parseInt(str[i]));//设置comego对象的属性
					List<List> indents=comegodao.findComeinIndent(comego);//根据获取出库单的车辆id与获得运输中订单id
					comein.setComein_time(str1);//设置入库单的属性
					comein.setComein_station(way.getWay_direction());
					
					Date datel = new Date();   
				    SimpleDateFormat sdfl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				    String strl = sdfl.format(datel); 
					time.setTime_car_id(Integer.parseInt(str[i]));
					time.setTime_end(strl);
					timedao.updateTime(time);
					
					for(List row:indents) {//循环多单订单id
						for(Object obj:row) {
							comein.setComein_indent(Integer.parseInt(obj.toString()));
							comeindao.insertComegoin(comein);//添加入库单
							indent.setIndent_id(Integer.parseInt(obj.toString()));
							indentdao.updateComeinIndentSituation(indent);
						}
					}
				}
			}
			print("卸货成功");
		}else {
			print("所选有未到达的车辆，请重新选择");
		}
		return null;
	}
	
	
	
	public Way getWay() {
		return way;
	}
	public void setWay(Way way) {
		this.way = way;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public WayDao getWaydao() {
		return waydao;
	}
	public void setWaydao(WayDao waydao) {
		this.waydao = waydao;
	}
	public CarDao getCardao() {
		return cardao;
	}
	public void setCardao(CarDao cardao) {
		this.cardao = cardao;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public ComeinDao getComeindao() {
		return comeindao;
	}
	public void setComeindao(ComeinDao comeindao) {
		this.comeindao = comeindao;
	}
	public Comein getComein() {
		return comein;
	}
	public void setComein(Comein comein) {
		this.comein = comein;
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
	public IndentDao getIndentdao() {
		return indentdao;
	}
	public void setIndentdao(IndentDao indentdao) {
		this.indentdao = indentdao;
	}
	
}
