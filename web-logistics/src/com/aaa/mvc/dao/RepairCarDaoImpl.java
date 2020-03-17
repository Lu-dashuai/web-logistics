package com.aaa.mvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

/***
 *@className:RepairCarDaoImpl.java
 *@discripton:
 *@author:dujihu
 *@createTime:2018-10-11下午11:16:59
 *@version:1.0
 */
@Repository
public class RepairCarDaoImpl implements RepairCarDao {

	@Override
	public List<Map<String, Object>> getList() {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select service_record_id,service_address,service_time,service_cause,service_state from tb_service_record",
				null);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("delete from tb_service_record where service_record_id = ?", new Object[]{id});
	}

	@Override
	public List<Map<String, Object>> getPage(int start, int rows, Map map) {
		// TODO Auto-generated method stub
		String str = "";
		if(map.get("sort")!=null){
			str = " order by "+map.get("sort")+" "+map.get("order");
		}
		Object state4 = map.get("state4");
		return BaseDao.selectMap("select a.service_result,a.service_money,a.service_record_id,a.service_address,a.service_time,a.service_cause,a.service_state,a.emp_name,b.car_id,b.car_driver,b.car_type,b.car_driver_papers,b.car_color,b.car_bulk,b.car_load,b.car_state,b.car_outlet from tb_service_record a join tb_car_details b on a.service_car_id=b.car_id "+setParams(map)+str+" limit "+start+","+rows, null);
	}

	@Override
	public List<Map<String, Object>> getPageCount(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select count(*) as cnt from tb_service_record"+setParams(map), null);
	}

	@Override
	public int add(Map map) {
		// TODO Auto-generated method stub
	  Date parse = null;
	try {
		parse = new SimpleDateFormat("MM/dd/yyyy").parse(map.get("service_time")+"");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return BaseDao.insertAndUpdateAndDelete("insert into tb_service_record (service_address,service_time,service_cause,service_state,service_car_id) value(?,?,?,?,?)",
				new Object[]{map.get("service_address"),parse,
				map.get("service_cause"),map.get("service_state"),map.get("service_car_id")});
	}

	@Override
	public int update(Map map, int id) {
		// TODO Auto-generated method stub
		 Date parse = null;
			try {
				parse = new SimpleDateFormat("MM/dd/yyyy").parse(map.get("service_time")+"");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_address=?,service_time=?,service_cause=? where service_record_id =?",
				new Object[]{map.get("service_address"),parse,
				map.get("service_cause"),id});
	}
	
	private String setParams(Map map){
		//查询参数
				String str1 = " where 1 = 1 ";
				Object address = map.get("address");
				Object state2 = map.get("state2");
				Object state3 = map.get("state3");
				Object state4 = map.get("state4");
				Object state5 = map.get("state5");
				//拼接address
				if(address!=null&&!"".equals(address)){
					str1 += " and service_address like '%"+address+"%' ";
				}
				if(state2!=null&&!"".equals(state2)){
					str1 += " and service_state ="+state2;
				}
				if(state3!=null&&!"".equals(state3)){
					str1 += " and service_state ="+state3;
				}
				if(state4!=null&&!"".equals(state4)){
					str1 += " and service_state in (3,10) ";
				}if(state5!=null&&!"".equals(state5)){
					str1 += " and service_state ="+state5;
				}
			return str1;
	}

	@Override
	public List<Map<String, Object>> getListByCarNum(String car_driver_papers) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select car_id,car_driver,car_type,car_color,car_bulk,car_load,car_state,car_outlet from tb_car_details where car_driver_papers= ?",
				new Object[]{car_driver_papers});
	}

	@Override
	public List<Map<String, Object>> getListById(int service_record_id) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select a.service_record_id,a.emp_name,a.service_address,a.service_time,a.service_cause,a.service_state,b.car_id,b.car_driver,b.car_type,b.car_driver_papers,b.car_color,b.car_bulk,b.car_load,b.car_state,b.car_outlet from tb_service_record a join tb_car_details b on a.service_car_id=b.car_id  where service_record_id=?", new Object[]{service_record_id});
	}

	@Override
	public int updateById(int id,String val) {
		// TODO Auto-generated method stub
		if(val.equals("提交")||val.equals("2")){
		return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_state = ? where service_record_id = ?", new Object[]{1,id});
		}else if(val.equals("撤回")){
		return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_state = ? where service_record_id = ?", new Object[]{0,id});
		}else if(val.equals("分配")){
			return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_state = ? where service_record_id = ?", new Object[]{2,id});
		}else if(val.equals("自行维修")){
			return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_state = ? where service_record_id = ?", new Object[]{10,id});
		}else if(val.equals("3")){
			return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_state = ? where service_record_id = ?", new Object[]{3,id});
		}else if(val.equals("noPro")){
			return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_state = ? where service_record_id = ?", new Object[]{4,id});
		}else if(val.equals("havePro")){
			return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_state = ? where service_record_id = ?", new Object[]{1,id});
		}else if(val.equals("4")){
			return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_state = ? where service_record_id = ?", new Object[]{4,id});
		}
		if(val.equals("88")){
			return BaseDao.insertAndUpdateAndDelete("update tb_repair_history set repair_history_bill_type = ? where repair_history_id = ?", new Object[]{1,id});
		}
		return 0;
	}

	@Override
	public List<Map<String, Object>> getRepairMan() {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select emp_id,emp_name from tb_employee where duty_id = ?", new Object[]{12});
	}

	@Override
	public int updateEmpid(int id,String name) {
		// TODO Auto-generated method stub
		if(name!=null&&!"".equals(name)){
			name =  name.substring(0,name.lastIndexOf(","));
		}
		return BaseDao.insertAndUpdateAndDelete("update tb_service_record set emp_name = ? where service_record_id = ?", 
				new Object[]{name,id});
	}

	@Override
	public List<Map<String, Object>> getHistoryPageCount(Map map) {
		// TODO Auto-generated method stub
		String str = "";
		Object id = map.get("id");
		if(id!=null&&!"".equals(id)){
			str+=" where repair_history_record_id =  "+id;
		}
		return BaseDao.selectMap("select count(*) as cnt from tb_repair_history "+str, null);
	
	}

	@Override
	public List<Map<String, Object>> getHistoryPage(int start, int rows, Map map) {
		// TODO Auto-generated method stub
		String str = " where 1=1 ";
		Object id = map.get("id");
		Object repair_history_id = map.get("repair_history_id");
		Object bill_type = map.get("bill_type");
		if(id!=null&&!"".equals(id)){
			str+=" and repair_history_record_id =  "+id;
		}
		if(repair_history_id!=null&&!"".equals(repair_history_id)){
			str+=" and repair_history_id =  "+repair_history_id;
		}
		if(bill_type!=null&&!"".equals(bill_type)){
			str+=" and repair_history_bill_type is null ";
		}
		return BaseDao.selectMap("select a.repair_history_id,a.repair_history_repairman,a.repair_history_repairResult,a.repair_history_repairCause,a.repair_history_repairMoney,a.repair_history_repairByWho,a.repair_history_repairCarNum,a.repair_history_repairTime,a.repair_history_record_id,a.repair_history_car_id,a.repair_history_address,a.repair_history_details,a.repair_history_bill_type,b.car_driver from tb_repair_history a join tb_car_details b on a.repair_history_car_id=b.car_id "+str+" limit "+start+","+rows, null);
		
	}

	@Override
	public int saveHis(Map map) {
		// TODO Auto-generated method stub
		if(Integer.valueOf(map.get("val")+"")==99){
			return BaseDao.insertAndUpdateAndDelete("insert into tb_repair_history (repair_history_repairman,repair_history_repairResult,repair_history_repairCause,repair_history_repairMoney,repair_history_repairCarNum,repair_history_repairTime,repair_history_record_id,repair_history_car_id,repair_history_address,repair_history_details,repair_history_repairByWho) values (?,?,?,?,?,?,?,?,?,?,?)", 
					new Object[]{map.get("name"),map.get("repairResult"),map.get("service_cause"),map.get("money"),map.get("car_driver_papers"),map.get("service_time"),Integer.valueOf(map.get("service_record_id").toString()),Integer.valueOf(map.get("car_id").toString()),map.get("service_address"),map.get("details"),map.get("repairByWho")});
		}else if(Integer.valueOf(map.get("val")+"")==66){
			return BaseDao.insertAndUpdateAndDelete("insert into tb_bill (money,payeeNo,payeeName,remark) value (?,?,?,?)" ,new Object[]{map.get("apply"),map.get("payeeNo"),map.get("payeeName"),map.get("remark")} );
		}else{
		return BaseDao.insertAndUpdateAndDelete("insert into tb_repair_history (repair_history_repairman,repair_history_repairResult,repair_history_repairCause,repair_history_repairMoney,repair_history_repairCarNum,repair_history_repairTime,repair_history_record_id,repair_history_car_id,repair_history_address,repair_history_details,repair_history_repairByWho) values (?,?,?,?,?,?,?,?,?,?,?)", 
				new Object[]{map.get("emp_name"),map.get("repairResult"),map.get("service_cause"),map.get("money"),map.get("car_driver_papers"),map.get("service_time"),Integer.valueOf(map.get("service_record_id").toString()),Integer.valueOf(map.get("car_id").toString()),map.get("service_address"),map.get("details"),map.get("repairByWho")});
		
		}
	}

	@Override
	public int updateMoney(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_money = ?,service_result = ? where service_record_id = ?", new Object[]{map.get("money"),map.get("repairResult"),map.get("service_record_id")});
	}

	@Override
	public int updateResult(int id,String val) {
		// TODO Auto-generated method stub
		if(val.equals("noPro")){
			return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_result = ? where service_record_id = ?", new Object[]{"维修成功",id});
		}else if(val.equals("havePro")){
		return BaseDao.insertAndUpdateAndDelete("update tb_service_record set service_result = ? where service_record_id = ?", new Object[]{"维修失败",id});
		}
		return 0;
	}

	@Override
	public int updateHisResult(int id,String val) {
		// TODO Auto-generated method stub
		if(val.equals("noPro")){
		return BaseDao.insertAndUpdateAndDelete("update tb_repair_history set repair_history_repairResult = ? where repair_history_record_id = ?", new Object[]{"维修成功",id});
		}else if(val.equals("havePro")){
			return BaseDao.insertAndUpdateAndDelete("update tb_repair_history set repair_history_repairResult = ? where repair_history_record_id = ?", new Object[]{"维修失败",id});
		}
		return 0;
	}	

	
}
