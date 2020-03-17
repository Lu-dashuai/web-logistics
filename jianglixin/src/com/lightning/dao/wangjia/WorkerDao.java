package com.lightning.dao.wangjia;

import java.util.List;

import com.lightning.bean.util.Page;
import com.lightning.bean.wangjia.Worker;

public interface WorkerDao {
	public int insertWoker(Worker worker);//添加数据
	public int deleteWorker(Worker worker);//删除数据
	public void updateWorker(Worker worker);//修改
	public List findOneWorker(Worker worker);//查找一条数据  为了  修改而使用
	public List findWorker();//查询所有
	public boolean frontlogin(Worker worker);//登录验证
	public List findWorkerId();
	public List findWorker(Page page, Worker worker);
	public int selectCount(Page page,Worker worker);
	public List selectWorker(Worker worker);
	public List checkeddenglu(Worker worker);
	
	
//	//注册验证员工账号用---------
//	public List<List> selectCheckWorkerid(int worker);
//	//注册验证员工账号用---------
	
	
	
	
	
}
