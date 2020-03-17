package com.lightning.action.yuhaiyang;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.yuhaiyang.Warehose;
import com.lightning.dao.impl.wangzelong.TypeDaoImpl;
import com.lightning.dao.impl.wuminghui.StationDaoImpl;
import com.lightning.dao.impl.yuhaiyang.WarehoseDaoImpl;
import com.lightning.dao.wangzelong.TypeDao;
import com.lightning.dao.wuminghui.StationDao;
import com.lightning.dao.yuhaiyang.WarehoseDao;
@Namespace("/Warehose")
public class WarehoseAction extends BaseAction {
	private Warehose warehose;
	private WarehoseDao warehosedao=new WarehoseDaoImpl();
	private List tabWarehose;
	private List rowWarehose;
	private TypeDao typedao=new TypeDaoImpl();
	private List tabType;
	private List tabStation;
	private StationDao stationdao=new StationDaoImpl();
	/**
	 * 查询仓库表
	 * @return
	 */
	@Action(value="findWarehose")
	public String findWarehose(){
		tabWarehose=warehosedao.findWarehose();
		String strWarehose=JSON.toJSONString(tabWarehose); 
		print(strWarehose);
		return null;
	}
	/**
	 * 根据三表查询的内容进行增加
	 * @return
	 */
	@Action(value="insertAllWarehose",results= {@Result(name="success",location="/before/yuhaiyang/insertWarehose.jsp")})
	public String insertAllWarehose(){
		tabType=typedao.findType();
		tabStation=stationdao.findStation();
		tabWarehose=warehosedao.findWarehose();
		return "success";
	}
	/**
	 * 在仓库表增加信息
	 * @return
	 */
	@Action(value="insertWarehose",results={@Result(name="success",location="/before/yuhaiyang/showWarehose.jsp")})
	public String insertWarehose(){
		warehosedao.insertWarehose(warehose);
		return "success";
	}
	/**
	 * 删除某个仓库信息
	 * @return
	 */
	@Action(value="deleteWarehose",results={@Result(name="success",location="/before/yuhaiyang/showWarehose.jsp")})
	public String deleteWarehose(){
		warehosedao.deleteWarehose(warehose);
		return "success";
	}
	/**
	 * 修改某个仓库信息
	 * @return
	 */
	@Action(value="updateWarehose",results={@Result(name="success",location="/before/yuhaiyang/showWarehose.jsp")})
	public String updateWarehose(){
		warehosedao.updateWarehose(warehose);
		return "success";
	}
	/**
	 * 根据ID查询某个仓库信息
	 * @return
	 */
	@Action(value="showOneWarehose",results={@Result(name="success",location="/before/yuhaiyang/showOneWarehose.jsp")})
	public String showOneWarehose(){
		tabWarehose=warehosedao.findWarehoseById(warehose);
		rowWarehose=(List) tabWarehose.get(0);
		tabType=typedao.findType();
		tabStation=stationdao.findStation();
		return "success";
	}
	
	
	
	
	
	public Warehose getWarehose() {
		return warehose;
	}
	public void setWarehose(Warehose warehose) {
		this.warehose = warehose;
	}
	public WarehoseDao getWarehosedao() {
		return warehosedao;
	}
	public void setWarehosedao(WarehoseDao warehosedao) {
		this.warehosedao = warehosedao;
	}
	public List getTabWarehose() {
		return tabWarehose;
	}
	public void setTabWarehose(List tabWarehose) {
		this.tabWarehose = tabWarehose;
	}
	public List getRowWarehose() {
		return rowWarehose;
	}
	public void setRowWarehose(List rowWarehose) {
		this.rowWarehose = rowWarehose;
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
	public List getTabStation() {
		return tabStation;
	}
	public void setTabStation(List tabStation) {
		this.tabStation = tabStation;
	}
	public StationDao getStationdao() {
		return stationdao;
	}
	public void setStationdao(StationDao stationdao) {
		this.stationdao = stationdao;
	}
	
	
}
