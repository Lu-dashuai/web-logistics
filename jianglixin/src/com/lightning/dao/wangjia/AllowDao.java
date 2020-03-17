package com.lightning.dao.wangjia;

import java.util.List;

import com.lightning.bean.wangjia.Allow;
import com.lightning.bean.wangjia.Post;

public interface AllowDao {
	public void insertAllow(Allow allow);//添加数据
	public int deleteAllow(Allow allow);//删除数据
	public void updateAllow(Allow allow);//修改
	public List findOneAllow(Allow allow);//查找一条数据  为了  修改而使用
	public List findAllow();//查询所有
	public int deleteAllowPower(Allow allow);
}
