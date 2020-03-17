package com.lightning.action.yuhaiyang;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.yuhaiyang.Comego;
import com.lightning.dao.impl.wangjia.StatusDaoImpl;
import com.lightning.dao.impl.wangjia.WorkerDaoImpl;
import com.lightning.dao.impl.wuminghui.CarDaoImpl;
import com.lightning.dao.impl.wuminghui.StationDaoImpl;
import com.lightning.dao.impl.yuhaiyang.ComegoDaoImpl;
import com.lightning.dao.impl.yuhaiyang.IndentDaoImpl;
import com.lightning.dao.impl.yuhaiyang.SituationDaoImpl;
import com.lightning.dao.wangjia.StatusDao;
import com.lightning.dao.wangjia.WorkerDao;
import com.lightning.dao.wuminghui.CarDao;
import com.lightning.dao.wuminghui.StationDao;
import com.lightning.dao.yuhaiyang.ComegoDao;
import com.lightning.dao.yuhaiyang.IndentDao;
import com.lightning.dao.yuhaiyang.SituationDao;
@Namespace("/Comego")
public class ComegoAction extends BaseAction {
	private Comego comego;
	private ComegoDao comegodao=new ComegoDaoImpl();
	private List tabComego;
	private List rowComego;
	private StationDao stationdao=new StationDaoImpl();
	private List tabStation;
	private CarDao cardao=new CarDaoImpl();
	private List tabCar;
	private SituationDao situationdao=new SituationDaoImpl();
	private List tabSituation;
	private IndentDao indentdao=new IndentDaoImpl();
	private List tabIndent;
	private WorkerDao workerdao=new WorkerDaoImpl();
	private List tabWorker;
	private String indentid;
	/**
	 * 查询所有出入库记录
	 * @return
	 */
	@Action(value="findComego")
	public String findComego(){
		tabComego=comegodao.findComego();
		String strComego=JSON.toJSONString(tabComego);
		print(strComego);
		return null;
	}
	/**
	 * 查询使用中车辆信息
	 * @return
	 */
//	@Action(value="insertAllComego"/*,results={@Result(name="success",location="/before/yuhaiyang/insertComego.jsp")}*/)
//	public String insertAllComego(){
//		/*JSONObject json = new JSONObject();
//		tabSituation=situationdao.findSituation();
//		tabStation=stationdao.findStation();
//		tabCar=cardao.findCarid();
//		json.put("tabsituation",tabSituation);
//		json.put("tabstation", tabStation);
//		json.put("tabcar", tabCar);
//		String str=JSON.toJSONString(json);
//		print(str);*/
//		tabCar=cardao.findCaridid();
//		String strCar=JSON.toJSONString(tabCar);
//		print(strCar);
//		
//		return "success";
//	}
	/**
	 * 查询空闲中车辆信息
	 * @return
	 */
	/*@Action(value="insertAllComegogo")
	public String insertAllComegogo(){
		tabCar=cardao.findCarid();
		String strCar=JSON.toJSONString(tabCar);
		print(strCar);
		return "success";
	}*/
	/**
	 * 添加入库记录
	 */
	@Action(value="insertComego",results={@Result(name="success",type="redirect",location="/before/yuhaiyang/showComego.jsp")})
	public String insertComego(){
		String[] str=indentid.split(",");
		for(int i=0;i<str.length;i++) {
			comego.setComego_indent(Integer.parseInt(str[i]));
			comegodao.insertComego(comego);
		}
		return "success";
	}
	/**
	 *  添加出库信息
	 * @return
	 */
	@Action(value="insertComegogo",results={@Result(name="success",type="redirect",location="/before/yuhaiyang/showComego.jsp")})
	public String insertComegogo() {
		String[] str=indentid.split(",");
		for(int i=0;i<str.length;i++) {
			comego.setComego_indent(Integer.parseInt(str[i]));
		//	comego.setComego_situation(1);
			comegodao.insertComego(comego);;
		}
		return "success";
	}
	/**
	 * 删除出入库记录
	 */
	@Action(value="deleteComego",results={@Result(name="success",location="/before/yuhaiyang/showComego.jsp")})
	public String deleteComego(){
		comegodao.deleteComngo(comego);
		return "success";
	}
	/**
	 * 修改出入库记录
	 */
	@Action(value="updateComego",results={@Result(name="success",location="/before/yuhaiyang/showComego.jsp")})
	public String updateComego(){
		comegodao.updateComego(comego);
		return "success";
	}
	/**
	 * 根据ID查询结果
	 */
	@Action(value="showOneComego",results={@Result(name="success",location="/before/yuhaiyang/showOneComego.jsp")})
	public String showOneComego(){
		tabComego=comegodao.findByIdComego(comego);
		rowComego=(List) tabComego.get(0);
		tabStation=stationdao.findStation();
		tabCar=cardao.findCar();
		tabSituation=situationdao.findSituation();
		return "success";
	}      
	/**
	 * 发车需要关联的表信息     订单表   车辆表   员工表   网点表
	 * @return
	 */
	/*@Action(value="busComego",results={@Result(name="success",location="/before/yuhaiyang/busIndent.jsp")})
	public String busComego(){
		tabCar=cardao.findCar();
		return "success";
	}*/
	
	
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
	public List getTabComego() {
		return tabComego;
	}
	
	public void setTabComego(List tabComego) {
		this.tabComego = tabComego;
	}
	public List getRowComego() {
		return rowComego;
	}
	public void setRowComego(List rowComego) {
		this.rowComego = rowComego;
	}
	public StationDao getStationdao() {
		return stationdao;
	}
	public void setStationdao(StationDao stationdao) {
		this.stationdao = stationdao;
	}
	public List getTabStation() {
		return tabStation;
	}
	public void setTabStation(List tabStation) {
		this.tabStation = tabStation;
	}
	public CarDao getCardao() {
		return cardao;
	}
	public void setCardao(CarDao cardao) {
		this.cardao = cardao;
	}
	public List getTabCar() {
		return tabCar;
	}
	public void setTabCar(List tabCar) {
		this.tabCar = tabCar;
	}
	public SituationDao getSituationdao() {
		return situationdao;
	}
	public void setSituationdao(SituationDao situationdao) {
		this.situationdao = situationdao;
	}
	public List getTabSituation() {
		return tabSituation;
	}
	public void setTabSituation(List tabSituation) {
		this.tabSituation = tabSituation;
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
	public WorkerDao getWorkerdao() {
		return workerdao;
	}
	public void setWorkerdao(WorkerDao workerdao) {
		this.workerdao = workerdao;
	}
	public List getTabWorker() {
		return tabWorker;
	}
	public void setTabWorker(List tabWorker) {
		this.tabWorker = tabWorker;
	}
	public String getIndentid() {
		return indentid;
	}
	public void setIndentid(String indentid) {
		this.indentid = indentid;
	}
	
	
	
	
}
