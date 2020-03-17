package com.aaa.mvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.util.BaseDao;

/***
 *@className:AbnormalOrderImpl.java
 *@discripton:
 *@author:dujihu
 *@createTime:2018-10-21下午8:01:51
 *@version:1.0
 */
@Repository
public class AbnormalOrderDaoImpl implements AbnormalOrderDao {

	@Override
	public List<Map<String, Object>> getAllOrder(Map map) {
		// TODO Auto-generated method stub
		String str = " where 1=1 ";
		Object order_mailnum = map.get("order_mailnum");
		if(order_mailnum!=null&&!"".equals(order_mailnum)){
			str += "  and order_mailnum = "+order_mailnum;
		}
		return BaseDao.selectMap("select * from tb_order "+str, null);
	}

	@Override
	public int addBadOrder(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("insert into tb_badorder (id,badorder_reason,badorder_type,badorder_insure,badorder_price,order_person,order_time,order_ship_address,order_person_phone,order_freight,order_pay_type,order_name,order_mailnum,order_state,badorder_pay,order_money,get_person,get_number) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
			new Object[]{map.get("id"),map.get("badreason"),map.get("badtype"),map.get("goods_ifsupportvalue"),map.get("goods_supportvalue"),map.get("sender_name"),map.get("order_time"),map.get("sender_adr"),map.get("sender_phone"),map.get("goods_cost"),map.get("cost_type"),map.get("goods_type"),map.get("order_mailnum"),0,map.get("badpay"),map.get("goods_value"),map.get("accepter_name"),map.get("accepter_phone")}	);
	}
	@Override
	public List<Map<String, Object>> getPage(int start, int rows, Map map) {
		// TODO Auto-generated method stub
		String str = "";
		if(map.get("sort")!=null){
			str = " order by "+map.get("sort")+" "+map.get("order");
		}
		return BaseDao.selectMap("select * from tb_badorder "+setParams(map)+str+" limit "+start+","+rows, null);
	}

	@Override
	public List<Map<String, Object>> getPageCount(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.selectMap("select count(*) as cnt from tb_badorder"+setParams(map), null);
	}
	
	private String setParams(Map map){
		//查询参数
				String str1 = " where 1 = 1 ";
				Object order_mailnum = map.get("order_mailnum");
				Object state = map.get("state");
				//拼接address
				if(order_mailnum!=null&&!"".equals(order_mailnum)){
					str1 += " and order_mailnum like '%"+order_mailnum+"%' ";
				}
				if(state!=null&&!"".equals(state)){
					str1 += " and order_state = "+state;
				}
			return str1;
	}

	@Override
	public List<Map<String, Object>> getAllBadOrder(Map map) {
		// TODO Auto-generated method stub
		String str = " where 1 = 1 ";
		Object badorder_id = map.get("badorder_id");
		if(badorder_id!=null&&!"".equals(badorder_id)){
			str += " and badorder_id = "+badorder_id;
		}
		return BaseDao.selectMap("select *,CONVERT(pass1_time,char(20)) as pass1T,CONVERT(pass2_time,char(20)) as pass2T from tb_badorder"+str,null);
	}

	@Override
	public int updateState(Map map) {
		// TODO Auto-generated method stub
		Object badorder_id = map.get("badorder_id");
		Object val = map.get("val");
		Object back2_reason = map.get("back2_reason");
		Date date = new Date();
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time;
		try {
			time = sdf.parse( nowTime );
			if(Integer.valueOf(val+"")==1){//初审驳回
				return BaseDao.insertAndUpdateAndDelete("update tb_badorder set order_state = ?,badorder_pay=?,back1_reason=?,pass1_time=? where badorder_id = ?", new Object[]{1,map.get("advise_money"),map.get("emp_details"),time,badorder_id});
			}else if(Integer.valueOf(val+"")==2){//初审通过
				return BaseDao.insertAndUpdateAndDelete("update tb_badorder set order_state = ?,pass1_time=? where badorder_id = ?", new Object[]{2,time,badorder_id});
			}else if(Integer.valueOf(val+"")==0){
				if(back2_reason!=null&&!"".equals(back2_reason)){
					//复核驳回
				return BaseDao.insertAndUpdateAndDelete("update tb_badorder set order_state = ?,badorder_pay=?,back2_reason=?,pass2_time=? where badorder_id = ?", new Object[]{0,map.get("advise_money"),map.get("back2_reason"),time,badorder_id});
				}else{//初审未过再次提交
				return BaseDao.insertAndUpdateAndDelete("update tb_badorder set order_state = ?,badorder_pay=?,add2_reason=?,add_time=? where badorder_id = ?", new Object[]{0,map.get("advise_money"),map.get("emp_details"),time,badorder_id});
				}
			}else if(Integer.valueOf(val+"")==3){//复核通过
				return BaseDao.insertAndUpdateAndDelete("update tb_badorder set order_state = ?,pass2_time=? where badorder_id = ?", new Object[]{3,time,badorder_id});
			}else if(Integer.valueOf(val+"")==5){//确认赔付
				return BaseDao.insertAndUpdateAndDelete("update tb_badorder set order_state = ? where badorder_id = ?", new Object[]{5,badorder_id});
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int saveBill(Map map) {
		// TODO Auto-generated method stub
		Date date = new Date();
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time;
        try {
			time = sdf.parse( nowTime );
	
		return BaseDao.insertAndUpdateAndDelete("insert into tb_bill (billtype,spendtype,payeeNo,payeeName,remark,addtime,money) values (?,?,?,?,?,?,?)", 
				new Object[]{"异常金额",1,map.get("payeeNo"),map.get("payeeName"),map.get("remark"),time,map.get("badorder_pay")});
    	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 0;
      }

	@Override
	public int saveBadOrder(Map map) {
		// TODO Auto-generated method stub
		return BaseDao.insertAndUpdateAndDelete("update tb_badorder set badorder_paytype = ?,payeeName=?,payeeNo=? where badorder_id=?", 
				new Object[]{map.get("badpay_type"),map.get("payeeName"),map.get("payeeNo"),map.get("badorder_id")});
	}

	
}
