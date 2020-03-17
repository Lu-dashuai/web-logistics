package com.lightning.action.yuhaiyang;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.yuhaiyang.Keeper;
import com.lightning.dao.impl.wangjia.WorkerDaoImpl;
import com.lightning.dao.impl.wangzelong.TypeDaoImpl;
import com.lightning.dao.impl.yuhaiyang.KeeperDaoImpl;
import com.lightning.dao.impl.yuhaiyang.WarehoseDaoImpl;
import com.lightning.dao.wangjia.WorkerDao;
import com.lightning.dao.wangzelong.TypeDao;
import com.lightning.dao.yuhaiyang.KeeperDao;
import com.lightning.dao.yuhaiyang.WarehoseDao;
@Namespace("/Keeper")
public class KeeperAction extends BaseAction {
	private Keeper keeper;
	private List tabKeeper;
	private List rowKeeper;
	private List tabWorker;
	private List tabWarehose;
	private WarehoseDao warehosedao=new WarehoseDaoImpl();
	private WorkerDao workerdao=new WorkerDaoImpl();
	private KeeperDao keeperdao=new KeeperDaoImpl();
	private List tabType;
	private TypeDao typedao=new TypeDaoImpl();
	/**
	 * 查找所有的仓管信息    需要修改查询方法   与worker表以及warehose表联合查询出来需要的信息
	 * @return
	 */
	@Action(value="findKeeper")
	public String findKeeper(){
		tabKeeper=keeperdao.findKeeper();
		String strKeeper=JSON.toJSONString(tabKeeper);
		print(strKeeper);
		return null;
	}
	/**
	 * 查找worker warehose  keeper关联的信息
	 * @return
	 */
	@Action(value="insertAllKeeper",results={@Result(name="success",location="/before/yuhaiyang/insertKeeper.jsp")})
	public String inserAlltKeeper() {
		tabWorker=workerdao.findWorker();
		System.out.println(tabWorker);
		tabWarehose=warehosedao.findWarehose();
		System.out.println(tabWarehose);
		return "success";
	}
	/**
	 * 增加仓库管理员
	 * @return
	 */
	@Action(value="insertKeeper",results={@Result(name="success",location="/before/yuhaiyang/showKeeper.jsp")})
	public String insertKeeper(){
		keeperdao.insertKeeper(keeper);
		return "success";
	}
	/** 
	 * 删除某个仓管信息
	 * @return
	 */
	@Action(value="deleteKeeper",results={@Result(name="success",location="/before/yuhaiyang/showKeeper.jsp")})
	public String deleteKeeper(){
		keeperdao.deleteKeeper(keeper);
		return "success";
	}
	/**
	 * 修改某个仓管的信息
	 * @return
	 */
	@Action(value="updateKeeper",results={@Result(name="success",location="/before/yuhaiyang/showKeeper.jsp")})
	public String updateKeeper(){
		keeperdao.updateKeeper(keeper);
		return "success";
	}
	/**
	 * 根据ID查询某个仓管信息  worker warehose  两表查询  进行选择
	 * @return
	 */
	@Action(value="showOneKeeper",results={@Result(name="success",location="/before/yuhaiyang/showOneKeeper.jsp")})
	public String showOneKeeper(){
		tabKeeper=keeperdao.findKeeperById(keeper);
		tabWorker=workerdao.findWorker();
		tabWarehose=warehosedao.findWarehose();
		rowKeeper=(List) tabKeeper.get(0);
		return "success";
	}
	
	
	
	public Keeper getKeeper() {
		return keeper;
	}
	public void setKeeper(Keeper keeper) {
		this.keeper = keeper;
	}
	public KeeperDao getKeeperdao() {
		return keeperdao;
	}
	public void setKeeperdao(KeeperDao keeperdao) {
		this.keeperdao = keeperdao;
	}
	public List getTabKeeper() {
		return tabKeeper;
	}
	public void setTabKeeper(List tabKeeper) {
		this.tabKeeper = tabKeeper;
	}
	public List getRowKeeper() {
		return rowKeeper;
	}
	public void setRowKeeper(List rowKeeper) {
		this.rowKeeper = rowKeeper;
	}
	public List getTabWorker() {
		return tabWorker;
	}
	public void setTabWorker(List tabWorker) {
		this.tabWorker = tabWorker;
	}
	public List getTabWarehose() {
		return tabWarehose;
	}
	public void setTabWarehose(List tabWarehose) {
		this.tabWarehose = tabWarehose;
	}
	public WarehoseDao getWarehosedao() {
		return warehosedao;
	}
	public void setWarehosedao(WarehoseDao warehosedao) {
		this.warehosedao = warehosedao;
	}
	public WorkerDao getWorkerdao() {
		return workerdao;
	}
	public void setWorkerdao(WorkerDao workerdao) {
		this.workerdao = workerdao;
	}
	
	
}
