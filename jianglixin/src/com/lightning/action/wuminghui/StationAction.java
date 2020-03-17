package com.lightning.action.wuminghui;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.util.Page;
import com.lightning.bean.util.PageUtil;
import com.lightning.bean.wuminghui.Station;
import com.lightning.dao.impl.wuminghui.StationDaoImpl;
import com.lightning.dao.wuminghui.StationDao;
@Namespace("/Station")
public class StationAction extends BaseAction{
	private Station station;
	private List tabStation;
	private List rowStation;
	//private List province;
	private StationDao stationdao=new StationDaoImpl();
	private Page page = new Page();
	private PageUtil pageutil = new PageUtil();
	
	/**
	 * 增加一个网点
	 * @return
	 */
	@Action(value="insertStation",results= {@Result(location="/before/wuminghui/showStation.jsp")})
	public String insertStation(){
		stationdao.insertStation(station);
	//	target="before/wuminghui/showStation";
		return "success";
	}
	/**
	 * 删除一个网点信息，一般不进行此操作
	 * @return
	 */
	@Action(value="deleteStation",results= {@Result(location="/before/wuminghui/showStation.jsp")})
	public String deleteStation() {
		stationdao.deleteStation(station);
		return "success";
	}
	/**
	 * 查询所有网点信息
	 * @return
	 */
	@Action(value="findStation",results= {@Result(location="/before/wuminghui/showStation.jsp")})
	public String findStation() {
		tabStation=stationdao.findStation();
		return "success";
	}
	/**
	 * 查询到一条网点信息进行修改操作
	 * @return
	 */
	@Action(value="findOneStation",results= {@Result(name="updateStation",location="/before/wuminghui/updateStation.jsp")})
	public String findOneStation() {
		tabStation=stationdao.findOneStation(station);
		rowStation=(List) tabStation.get(0);
		return "updateStation";
	}
	/**
	 * 修改网点信息
	 * @return
	 */
	@Action(value="updateStation",results= {@Result(location="/before/wuminghui/showStation.jsp")})
	public String updateStation(){
		stationdao.updateStation(station);
		return "success";
	}
	/**
	 * 向员工表传输网点信息
	 * @return
	 */
	@Action(value="findStationWorker")
	public String findStationWorker() {
	List<List> tabStation=stationdao.findStation();
	print(JSON.toJSONString(tabStation));
	return null;
}
	/**
	 * 把网点经理信息传到后台
	 * */
	@Action(value="findAdminStation")
	public String findAdminStation() {
	List<List> tabStation=stationdao.findAdminStation();
	print(JSON.toJSONString(tabStation));
	return null;
}
	
	@Action(value="findStationCount",results= {@Result(location="/before/wuminghui/showStation.jsp")})
	public String findStationCount() {
		List count=(List) stationdao.findCountStation().get(0);
		pageutil.setTotal(Integer.parseInt(count.get(0).toString()));
		page.setMax(10);
		if(pageutil.getTotal()%10==0) {
			page.setMaxPage(pageutil.getTotal()/10);
		}else {
			page.setMaxPage((pageutil.getTotal()/10)+1);
		}
		tabStation=stationdao.findlimitStation(page);
		return "success";
	}
	
	
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public PageUtil getPageutil() {
		return pageutil;
	}
	public void setPageutil(PageUtil pageutil) {
		this.pageutil = pageutil;
	}
	
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}

	public List getTabStation() {
		return tabStation;
	}

	public void setTabStation(List tabStation) {
		this.tabStation = tabStation;
	}

	public List getRowStation() {
		return rowStation;
	}

	public void setRowStation(List rowStation) {
		this.rowStation = rowStation;
	}

	public StationDao getStationdao() {
		return stationdao;
	}

	public void setStationdao(StationDao stationdao) {
		this.stationdao = stationdao;
	}

}
