package com.lightning.dao.wuminghui;

import java.util.List;

import com.lightning.bean.util.Page;
import com.lightning.bean.wuminghui.Station;

public interface StationDao {
	public void insertStation(Station station);
	public void deleteStation(Station station);
	public void updateStation(Station station);
	public List findStation();
	public List findOneStation(Station station);
	public List findAdminStation();
	public List findCountStation();
	public List findlimitStation(Page page);
	
}
